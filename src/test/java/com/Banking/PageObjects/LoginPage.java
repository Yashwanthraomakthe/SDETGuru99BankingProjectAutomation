package com.Banking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(name = "uid")
	@CacheLookup
	WebElement textUserName;

	@FindBy(name = "password")
	@CacheLookup
	WebElement textPassword;

	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(linkText = "Log out")
	@CacheLookup
	WebElement logout;

	public void setUserName(String uname) {

		textUserName.sendKeys(uname);

	}

	public void setPassword(String pwd) {

		textPassword.sendKeys(pwd);

	}

	public void clickSubmit() {

		btnLogin.click();

	}

	public void clickLogout() {

		logout.click();

	}
}
