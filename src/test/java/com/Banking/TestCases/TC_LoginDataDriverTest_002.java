package com.Banking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Banking.PageObjects.LoginPage;
import com.Banking.Utilities.XLUtils;

public class TC_LoginDataDriverTest_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDataDrivenTest(String UserName,String Password) throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(UserName);
		lp.setPassword(Password);
		lp.clickSubmit();
		
		Thread.sleep(2000);
		
		if(isAlertPresent()==true) {
			Thread.sleep(2000);
			log.info("this is failure case");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			Thread.sleep(2000);
			log.info("this is passed case");
			lp.clickLogout();
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
		
		
	}

	public boolean isAlertPresent() { // User Defined method to check alert is present or not
		
		try{
			driver.switchTo().alert();
			return false;
		} 
		catch(Exception e ) {
				return false;
			}
		
	}
	
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		
		String filepath = "C://Users//YashPooja//Desktop//LoginData.xlsx";
		
		int rownum = XLUtils.getRowCount(filepath, "usefull");
		int columncount = XLUtils.getCellCount(filepath, "usefull", 1);
		
		String logindata[][] = new String[rownum][columncount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<columncount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(filepath, "usefull", i,j);
			}
		}
		
		return logindata;
		
	}
	
	
}
