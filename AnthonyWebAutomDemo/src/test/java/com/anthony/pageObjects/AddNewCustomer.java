package com.anthony.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer extends BasePage {
	
	public AddNewCustomer(WebDriver rdriver) {
		driver = rdriver; // driver是BasePage的，rdriver是需要测试基类传递过来
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*/ul[@class='menusubnav']/li[2]")
	@CacheLookup   
	WebElement link_newCustomer;
	
	@FindBy(xpath="//*/td/p[text()='Add New Customer']")
	@CacheLookup   
	WebElement title_AddCustomer;
	
	@FindBy(name="name")  // xpath://*/td/input[@name='name']
	@CacheLookup   
	WebElement inputBox_CustomerName;
	
	@FindBy(xpath="//*/tr/td/input[@value='f']")
	@CacheLookup   
	WebElement radio_Gender_female;
	
	@FindBy(xpath="//*/tr/td/input[@value='m']")
	@CacheLookup   
	WebElement radio_Gender_male;
	
	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement txtdob;
	
	@FindBy(name="addr")
	@CacheLookup   
	WebElement textArea_Address;
	
	@FindBy(name="city")
	@CacheLookup   
	WebElement inputBox_City;
	
	@FindBy(name="state")
	@CacheLookup   
	WebElement inputBox_State;
	
	@FindBy(name="pinno")
	@CacheLookup   
	WebElement inputBox_PIN;
	
	@FindBy(name="telephoneno")
	@CacheLookup   
	WebElement inputBox_Telephone;
	
	@FindBy(name="emailid")
	@CacheLookup   
	WebElement inputBox_Email;
	
	@FindBy(name="password")
	@CacheLookup   
	WebElement inputBox_Password;
	
	@FindBy(name="sub")
	@CacheLookup   
	WebElement btn_Submit;
	
	public void clickAddCustomer () {
		link_newCustomer.click();
	}
	
	public void setCustmerName (String name) {
		inputBox_CustomerName.sendKeys(name);
	}
	
	public void selectGender (String gender) {
		
		if("male".equals(gender)) {
			radio_Gender_male.click();
		}else {
			radio_Gender_female.click();
		}
	}
	
	public void setBirthday(String yy, String mm, String dd) {
		txtdob.sendKeys(yy);
		txtdob.sendKeys(Keys.ARROW_RIGHT);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(Keys.ARROW_RIGHT);
		txtdob.sendKeys(dd);
		
	}
	
	public void setAddress (String address) {
		textArea_Address.sendKeys(address);
	}
	
	public void setCity (String cityName) {
		inputBox_City.sendKeys(cityName);
	}
	
	public void setStage (String state) {
		inputBox_State.sendKeys(state);
	}
	
	public void setPIN (String pin) {
		inputBox_PIN.sendKeys(pin);
	}
	
	public void setTelephoneNum (String telephone) {
		inputBox_Telephone.sendKeys(telephone);
	}
	
	public void setEmail (String email) {
		inputBox_Email.sendKeys(email);
	}
	
	public void setPwd (String pwd) {
		inputBox_Password.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btn_Submit.click();
	}
	
}
