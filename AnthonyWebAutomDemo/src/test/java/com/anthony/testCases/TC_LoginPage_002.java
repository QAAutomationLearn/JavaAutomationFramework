package com.anthony.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.anthony.pageObjects.LoginPage;


public class TC_LoginPage_002 extends BaseCase {
	
	@Test
	public void TestLogin() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		logger.info("LoginPage opened.");
		Thread.sleep(2000);
		lp.setUserName(userName);
		logger.info("Type userName:" + userName);
		lp.setPassword(password);
		logger.info("Type userName");
		lp.clickLoginBtn();
		logger.info("Click Login submit Button");
		Thread.sleep(2000);
		
		if("Guru99 Bank Manager HomePage".equalsIgnoreCase(driver.getTitle().trim())) {
			Assert.assertTrue(true);
			logger.info("Verifyed open url and title is " + driver.getTitle());
	
		}else {
			captureScreen(driver,"logintest");
			Assert.assertFalse(false);
		}
		
	}
}
