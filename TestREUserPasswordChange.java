package RealEstate.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import RealEstate.pages.REUserLoginPage;
import RealEstate.pages.REUserPasswordChange;

public class TestREUserPasswordChange {
	static WebDriver driver;
	static REUserPasswordChange psw;
	
	@BeforeTest
	public void verifyRegister()
	{
	
		System.setProperty("webdriver.chrome.driver", "E:\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/"+ "");
		driver.manage().window().maximize();
		
	/*	REUserPasswordChange psw=new REUserPasswordChange(driver);
		driver.navigate().to("http://realty-real-estatem1.upskills.in/change-password/");
		driver.manage().window().maximize();
		*/
	}
	
	
	@Test 
	public void SignIn()
		{
			REUserLoginPage login = new REUserLoginPage(driver);
			boolean success=login.AdminLogin("Varshu", "Varshitha");	
			Assert.assertEquals(success, true);
			REUserPasswordChange psw = new REUserPasswordChange(driver);
			//driver.get("http://realty-real-estatem1.upskills.in/change-password/");
			boolean success1=psw.PasswordChange("Varshitha", "Varshitha", "Varshitha");
			Assert.assertEquals(success1, true);	
		}
	
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
