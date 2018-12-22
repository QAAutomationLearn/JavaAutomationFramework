package com.anthony.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	/**
	 * 用来读取./Configs/config.properties文件下的内容
	 */
	
	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./Configs/config.properties");
		try {
			
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getServerUrl() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserName() {
		String name = pro.getProperty("userName");
		return name;
	}
	
	public String getPassword() {
		String passwd = pro.getProperty("password");
		return passwd;
	}
	
	public String getChromePath() {
		String chromePath = pro.getProperty("chromepath");
		return chromePath;
	}
	
	public String getFirefoxPath() {
		String firefoxPath = pro.getProperty("firefoxpath");
		return firefoxPath;
	}
	
	public String getBrowser() {
		String browser = pro.getProperty("browser");
		return browser;
	}
}
