package RealEstate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REUserPasswordChange {
	WebDriver driver;
	
	/*By username= By.id("user_login");
	By password = By.id("user_pass");
	By SignInbutton = By.cssSelector("#tab1 > form > p:nth-child(3) > input");
	*/
	
	//By chpass=By.linkText("http://realty-real-estatem1.upskills.in/change-password/");
	By chpass=By.cssSelector("#post-133 > div.col-md-4 > div > div > ul:nth-child(2) > li:nth-child(1) > a");
	By currpass=By.name("current_pass");
	By newpass=By.xpath("//*[@id=\'post-129\']/div[2]/div/div[1]/form/input[2]");
	By conpass=By.xpath("//*[@id=\'post-129\']/div[2]/div/div[1]/form/input[3]");
	By save=By.id("wp-submit");
	By res=By.xpath("//*[@id=\'post-129\']/div[2]/div/div[1]/div/p");
	
	
	public REUserPasswordChange(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public boolean isHeaderFound()
	{
		boolean found= false;
		try
		{
			/*WebElement element = driver.findElement(chpass);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			found=driver.findElement(chpass).isDisplayed();
			*/
			
			WebElement element = driver.findElement(res);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			found=driver.findElement(res).isDisplayed();
		}
		catch (NoSuchElementException e)
		{
			found=false;
		}
		return found;
	}
	public boolean PasswordChange(String c, String n, String cp)
	{
		driver.findElement(chpass).click();
		WebElement element=driver.findElement(currpass);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(currpass).sendKeys(c);
		driver.findElement(newpass).sendKeys(n);
		driver.findElement(conpass).sendKeys(cp);
		driver.findElement(save).click();
		
		boolean success=this.isHeaderFound();
		return success;
		
	}
}

