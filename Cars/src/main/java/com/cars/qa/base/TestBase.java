package com.cars.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.cars.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis=new FileInputStream("src//main//java//com//cars//qa/config//config.properties");
				prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initializeBrowser() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\santh\\Desktop\\Selenium\\browers exe files\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();		
			}else if(browserName.equals("FF")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\santh\\Desktop\\Selenium\\browers exe files\\firefox.exe");
				driver = new FirefoxDriver();		
				}else if(browserName.equals("IE")) {
					System.setProperty("webdriver.ie.driver", "C:\\Users\\santh\\Desktop\\Selenium\\browers exe files\\chromedriver\\ie.exe");
					driver = new InternetExplorerDriver();		
					}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		log.info(browserName + " driver is instantiated");
	}
}
