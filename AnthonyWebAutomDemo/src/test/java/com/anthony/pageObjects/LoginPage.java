package com.anthony.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(name="uid")
	@CacheLookup   
	WebElement inputbox_userName;
	
	@FindBy(name="password")   
	@CacheLookup
	WebElement inputbox_password;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btn_Login;
	
	@FindBy(xpath="//*/li/a[@href='Logout.php']")
	@CacheLookup
	WebElement btn_Logout;
	
	public void setUserName(String name) {
		inputbox_userName.sendKeys(name);
	}
	
	public void setPassword(String passwd) {
		inputbox_password.sendKeys(passwd);
	}
	
	public void clickLoginBtn() {
		btn_Login.click();
	}
	
	public void clickLogout() {
		btn_Logout.click();
	}
	
}
