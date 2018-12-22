package com.anthony.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.anthony.pageObjects.LoginPage;


public class TC_LoginPage_001 extends BaseCase {
	
	@Test
	public void TestLogin() throws InterruptedException {
		
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
			logger.info("页面title判断正确，打开页面正常, title的值是：" + driver.getTitle());
	
		}else {
			Assert.assertFalse(false);
		}
		
	}
}
