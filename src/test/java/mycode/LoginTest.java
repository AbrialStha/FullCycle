package mycode;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;




import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.ConfigUtils;
import utility.Driver;

@Listeners(utility.Listners.class)
public class LoginTest {
	Driver browser;
	String userName = ConfigUtils.getProperty("UserName");
	String password = ConfigUtils.getProperty("password");
	String baseUrl = ConfigUtils.getProperty("baseUrl");

	@BeforeTest
	public void setup() {
		browser = new Driver("Chrome");
		browser.driver.manage().window().maximize();
	}
	
	@Test
	public void LoadLoginTest() throws InterruptedException{
		browser.driver.get(ConfigUtils.getProperty("initialPath"));
		Thread.sleep(4000);
		Assert.assertEquals(browser.driver.getTitle(), "Automate Sales", "Load the login page");
	}
	
	@Test(dependsOnMethods = { "LoadLoginTest" })
	public void wrongCredentialsTest() throws InterruptedException {
		browser.driver.get(baseUrl+"login");
		Thread.sleep(3000);
		browser.driver.findElement(By.name("username")).sendKeys("wrongcredentails");;
		browser.driver.findElement(By.name("password")).sendKeys("wrongcredentails");
		browser.driver.findElement(By.className("btn-padding")).click();
		Thread.sleep(3000);
		String messageStr = browser.driver.findElement(By.className("error-credential")).getText();
		
		Assert.assertEquals("Username or Password is incorrect", messageStr, "Wrong Credentials Test");
	}
	
	@Test(dependsOnMethods = { "wrongCredentialsTest" })
	public void loginAndLogoutTest() throws InterruptedException {
		browser.driver.get(baseUrl+"login");
		Thread.sleep(3000);
		browser.driver.findElement(By.name("username")).sendKeys(userName);
		browser.driver.findElement(By.name("password")).sendKeys(password);
		browser.driver.findElement(By.className("btn-padding")).click();
		Thread.sleep(10000);
		Assert.assertEquals(baseUrl+"discover/search",browser.driver.getCurrentUrl(), "Check the redirection");
		
		
	}

	@AfterTest
	public void teadown() {

	}
}
