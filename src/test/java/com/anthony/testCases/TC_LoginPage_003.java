package com.anthony.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.anthony.pageObjects.LoginPage;
import com.anthony.utils.ExcelUtil;

public class TC_LoginPage_003 extends BaseCase {
	
	
	/**
	 * 这个用例，专门用来演示用户名和密码登录的DDT场景
	 */
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String name, String password) throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(name);
		logger.info("input user name.");
		lp.setPassword(password);
		logger.info("input password");
		lp.clickLoginBtn();
		logger.info("click Login button");
		
		if(isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Thread.sleep(2000);
		}else {
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	/**
	 * 登录之后判断弹窗是否出现
	 * @return
	 */
	public boolean isAlertPresent() {
	    try {
	        driver.switchTo().alert();
	        return true;

	    }catch (NoAlertPresentException e) {
	        return false;
	    }

	}
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\anthony\\testDatas\\LoginData.xlsx";
		//System.out.println(path);
		int rownum = ExcelUtil.getRowCount(path,"Sheet1");
		int colcount = ExcelUtil.getCellCount(path,"Sheet1",1);
		
		String[][] logindata = new String[rownum][colcount];

		for(int i = 1; i <= rownum; i++) {
		    for( int j=0; j < colcount; j++){
		        logindata[i-1][j] = ExcelUtil.getCellData(path,"Sheet1",i,j);
		    }
		}
		return logindata;
	}
}
