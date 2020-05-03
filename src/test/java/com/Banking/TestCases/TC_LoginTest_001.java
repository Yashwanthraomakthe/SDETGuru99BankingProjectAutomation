package com.Banking.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Banking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() {
		
		
		
		log.info("URL Opened");
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		log.info("Entered Username");
		lp.setPassword(password);
		log.info("Entered password");
		lp.clickSubmit();
		log.info("clicked on login");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			log.info("Page title verified successfull");
		}
		else {
			Assert.assertTrue(false);
		}
		
		
	}


}
