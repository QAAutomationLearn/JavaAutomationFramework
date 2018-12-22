package com.anthony.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.anthony.pageObjects.AddNewCustomer;
import com.anthony.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_NewCustomer_004 extends BaseCase {
	
	@Test
	public void NewCustomer() throws InterruptedException, IOException {
		//登录
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickLoginBtn();
		logger.info("Login is completed");
		Thread.sleep(3000);
		
		AddNewCustomer anc = new AddNewCustomer(driver);
		anc.clickAddCustomer();
		Thread.sleep(1000);
		logger.info("Proving customer details.............");
		anc.setCustmerName("Anthony");
		anc.selectGender("male");
		Thread.sleep(500);
		anc.setBirthday("2018","12", "08");
		Thread.sleep(1000);
		anc.setAddress("CHINA");
		Thread.sleep(1000);
		anc.setCity("BeiJing");
		anc.setStage("AP");
		anc.setPIN("5000074");
		anc.setTelephoneNum("15188889999");
		Thread.sleep(1000);
		String email = randomString() + "@anthony.com";
		anc.setEmail(email);
		anc.setPwd("abcdef");
		anc.clickSubmit();
		Thread.sleep(50000);
		logger.info("Validating adding new customer..............");
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(result == true) {
			Assert.assertTrue(true);
		}else {
			captureScreen(driver, "NewCustomer");
			Assert.assertTrue(false);
		}
	}
    
	/**
	 * 随机生成一个8位数的随机字符串
	 * @return
	 */
	public static String randomString() {

	    String generatedString = RandomStringUtils.randomAlphabetic(8);
	    return generatedString;
	}
}
