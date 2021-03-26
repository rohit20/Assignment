package com.Flipkart.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

import com.Flipkart.utils.TestUtils;

public class BrowserStackBaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public static final String Automate_Key="s7QwZgT9Mq2LRQpMz47d";
	//Constructor
	
	public BrowserStackBaseTest() {
		try {
			prop= new Properties();
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/Flipkart/config/config.properties" );
			prop.load(ip);
			DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("os_version", "Catalina");
		    caps.setCapability("resolution", "1920x1080");
		    caps.setCapability("browser", "Chrome");
		    caps.setCapability("browser_version", "latest");
		    caps.setCapability("os", "OS X");
		    caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
		    caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
		    WebDriver driver = new RemoteWebDriver(caps);

		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
		
	
	
    @Parameters({"browserName"})
    public void beforeMethod(String browserName) {
//        logger = extent.createTest(testMethod.getName());
        BaseTest.setupDriver(browserName);
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	
	//Setting up Driver Path
	public static void setupDriver(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ File.separator + "Drivers"+ File.separator + "chromedriver");
			driver= new ChromeDriver();
			
		}else if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver");
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
            driver = new ChromeDriver();
        }
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.implicit_wait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
	
	
	
}



