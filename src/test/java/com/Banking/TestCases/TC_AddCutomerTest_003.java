package com.Banking.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Banking.PageObjects.LoginPage;
import com.Banking.PageObjects.NewCustomer;

public class TC_AddCutomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCutomer() throws InterruptedException {
		
		
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		
		NewCustomer addcustomer = new NewCustomer(driver);
		addcustomer.clickAddNewCustomer();
		
		addcustomer.SetCustomerName();
		addcustomer.SelectGender();
		addcustomer.EnterDOB();
		addcustomer.AddCustomerAddress();
		addcustomer.SetCustomerCity();
		addcustomer.SetCustomerState();
		
		Thread.sleep(3000);
		
		addcustomer.SetCustomerPIN();
		addcustomer.SetCustomerMobileNumber();
		addcustomer.SetCustomerEmail(GenerateRandomstring()+"@gmail.com");
		addcustomer.SetCustomerPassword();
		addcustomer.ConfirmCustomerSubmit();
		
		Thread.sleep(3000);
		
		boolean result=driver.getPageSource().contains("Customer Registerd Successfully!!!");   
		if(result==true) {
			Assert.assertTrue(true);
		}else
			Assert.assertTrue(false);
		
	}
	
	
	

}
