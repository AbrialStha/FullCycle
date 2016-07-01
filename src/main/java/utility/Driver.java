package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * @author Abiral Sthapit
 * @since April 11,2016
 * A class to chose which driver to chose to run the program
 */
public class Driver {
public WebDriver driver;
	
	//Setting Up the Driver
	public Driver(String name){
		
		if(name.toLowerCase().equalsIgnoreCase("firefox") ){
			driver = new FirefoxDriver();
		}else if(name.toLowerCase().equalsIgnoreCase("chrome") ){
			 System.setProperty(ConfigUtils.getProperty("driver"), ConfigUtils.getProperty("driverPath"));
			 driver = new ChromeDriver();
		}	
	}
}
