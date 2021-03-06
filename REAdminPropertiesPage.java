package RealEstate.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REAdminPropertiesPage {
	WebDriver driver;	

	By username= By.id("user_login");

	By password = By.id("user_pass");
	By SignInbutton = By.cssSelector("#tab1 > form > p:nth-child(3) > input"); 

	By HeaderText = By.id("menu-posts-property"); 
	By AllPropertiesbutton = By.xpath("//*[@id=\"wpbody-content\"]/div[3]/h1 "); //*[@id=\"menu-posts-property\"]/ul/li[2]/a
	
	By SearchProperty=By.id("search-submit");
	By EditProperty=By.cssSelector("#post-11448 > td.title.column-title.has-row-actions.column-primary.page-title > div.row-actions > span.edit > a");   //*[@id=\"post-11448\"]/td[1]/div[3]/span[2]/a
	By title=By.cssSelector("#tinymce > p");
	By publish=By.xpath("//*[@id=\"publish\"]");
	
	By updated=By.cssSelector("#message > p");


	//creating parameterized constructor to initialize WebDriver reference
	public REAdminPropertiesPage(WebDriver driver)
	{
		this.driver =driver;
	}

	public boolean isHeaderFound()

	{
		
		boolean found=false;
		try {
			
			/*WebElement element = driver.findElement(HeaderText);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//Dashboard header present in page?
			found=driver.findElement(HeaderText).isDisplayed();*/
			
			WebElement element = driver.findElement(AllPropertiesbutton );
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//Dashboard header present in page?
			found=driver.findElement(AllPropertiesbutton ).isDisplayed();
			
			WebElement searchelement = driver.findElement(SearchProperty);
			JavascriptExecutor searchjs = (JavascriptExecutor) driver;
			
			//Dashboard header present in page?
			found=driver.findElement(SearchProperty).isDisplayed();
			
			
		}
		
		
		catch (NoSuchElementException e)
		{
			found=false;
			
		}
		
		return found;
		
	}	
	
	public boolean isUpdated()
	{
		boolean found=false;
		try {
			WebElement element = driver.findElement(updated);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			found=driver.findElement(updated).isDisplayed();
		}
		catch(Exception e)
		{
			found=false;
		}
		return found;
	}
	
	
	public boolean propertyEdit()
    {
		driver.findElement(AllPropertiesbutton).click();
    	driver.findElement(EditProperty).click();
		driver.findElement(title).sendKeys("hiiiiiii511");
		driver.findElement(publish).click();
		boolean done=this.isUpdated();
		return done;
    }

		public boolean AdminLogin(String un,String pw)
		{
			WebElement element = driver.findElement(username);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			driver.findElement(username).sendKeys(un);
			driver.findElement(password).sendKeys(pw);
			driver.findElement(SignInbutton).click();
			driver.findElement(HeaderText).click();
			
			
			
			boolean success=this.isHeaderFound();
			
			return success;
			
		
		}
		
		public boolean property(String pro)
		{
			driver.findElement(AllPropertiesbutton).click();
			
			driver.findElement(SearchProperty).click();
			driver.findElement(SearchProperty).sendKeys(pro);
			
			boolean result=this.isHeaderFound();
			return result;
		}

		public String getRELoginTitle(WebDriver driver) {
			// TODO Auto-generated method stub
			
			System.out.println(driver.getTitle());
			String curTitle = driver.getTitle();
			return curTitle;
			
			
		}
		

	}

