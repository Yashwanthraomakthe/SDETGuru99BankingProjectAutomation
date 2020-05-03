package com.Banking.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Banking.Utilities.ReadConfig;

public class BaseClass {

	// public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	public static Logger log = LogManager.getLogger();

	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();

	public static WebDriver driver;

	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String browsername) {
		
		if(browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", readconfig.getChromeDriverPath());
		driver = new ChromeDriver();
		}
		else if(browsername.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", readconfig.getChromeDriverPath());
			driver = new FirefoxDriver();
		}
		else if(browsername.equals("ie")){
			System.setProperty("webdriver.ie.driver", readconfig.getChromeDriverPath());
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	
	public void getScreenshot(String result) throws IOException {
		
		File src = (File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\YashPooja\\BankingProjectAutomation\\Screenshots\\" +result+ "Screenshot.png"));
		//FileUtils.copyFile(src,new File("./" + "//Screenshots" + result+ "Screenshot.png"));
		//FileUtils.copyFile(src,new File("F://" + result+ "Screenshot.png")); -->Working one
}
	
	public String GenerateRandomstring() {
		String genreratedstring = RandomStringUtils.randomAlphabetic(8);
		return(genreratedstring);
	}
	
	public String GenerateRandomNumber() {
		String genreratedstring = RandomStringUtils.randomNumeric(8);
		return(genreratedstring);
	}

}
