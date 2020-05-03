package com.Banking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {
	
	WebDriver ldriver;
	
	public NewCustomer(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.LINK_TEXT, using ="New Customer")
	@CacheLookup
	WebElement LinkNewCustomer;
	
	@FindBy(how = How.NAME, using ="name")
	@CacheLookup
	WebElement CustName;
	
	@FindBy(how = How.XPATH, using ="//input[@type='radio' and @value='m']")
	@CacheLookup
	WebElement CustGender;
	
	
	@FindBy(how = How.ID, using ="dob")
	@CacheLookup
	WebElement CustDOB;
	
	@FindBy(how = How.NAME, using ="addr")
	@CacheLookup
	WebElement CustAddress;
	
	@FindBy(how = How.NAME, using ="city")
	@CacheLookup
	WebElement CustCity;
	
	@FindBy(how = How.NAME, using ="state")
	@CacheLookup
	WebElement CustState;
	
	@FindBy(how = How.NAME, using ="pinno")
	@CacheLookup
	WebElement CustPIN;
	
	@FindBy(how = How.NAME, using ="telephoneno")
	@CacheLookup
	WebElement CustMobileNumber;
	
	@FindBy(how = How.NAME, using ="emailid")
	@CacheLookup
	WebElement CustEmail;
	
	@FindBy(how = How.NAME, using ="password")
	@CacheLookup
	WebElement CustPassword;
	
	@FindBy(how = How.NAME, using ="sub")
	@CacheLookup
	WebElement ClickSubmit;
	
	
	public void clickAddNewCustomer() {
		LinkNewCustomer.click();
	}
	
	public void SetCustomerName() {
		CustName.sendKeys("TestUser");
	}
	
	
	
	public void SelectGender() {
		CustGender.click();
	}
	
	public void EnterDOB() {
		CustDOB.sendKeys("05");
		CustDOB.sendKeys("25");
		CustDOB.sendKeys("1990");
	}
	
	public void AddCustomerAddress() {
		CustAddress.sendKeys("TestAddress");
	}
	
	public void SetCustomerCity() {
		CustCity.sendKeys("Hyderabad");
	}
	
	public void SetCustomerState() {
		CustState.sendKeys("Telangana");
	}
	
	public void SetCustomerPIN() {
		CustPIN.sendKeys("503306");
	}
	
	public void SetCustomerMobileNumber() {
		CustMobileNumber.sendKeys("8899775545");
	}
	
	public void SetCustomerEmail(String email) {
		CustEmail.sendKeys(email);
	}
	
	public void SetCustomerPassword() {
		CustPassword.sendKeys("MTest@425");
	}
	
	public void ConfirmCustomerSubmit() {
		ClickSubmit.click();
	}
	
	
	
	
}
