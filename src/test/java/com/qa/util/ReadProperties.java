package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author prett
 * This class has common methods to read from config.properties file	
 */
public class ReadProperties {

	/**
	 * @return this method will read properties and load properties and return the object
	 */
	public static Properties loadProperties() {
		// Open the File
		File objfile = new File("AppConfig/config.properties");
		// Read the File

		FileInputStream objfis = null;
		try {
			objfis = new FileInputStream(objfile);
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}

		Properties objprop = new Properties();
		try {
			objprop.load(objfis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return objprop;

	}
	
	
	/**
	 * @return
	 */
	public static String getappURL() {

		return loadProperties().getProperty("appURL");

	}
	
	
	
	/**
	 * @return This method will read implicitWaitTime from config file
	 */
	public static long implicitWaitTime() {

		return Long.parseLong(loadProperties().getProperty("implicitWaitTime"));
	}
	
	/**
	 * @return This method will read userName from config file
	 */
	public static String getAppUserName() {
		return loadProperties().getProperty("userName");
	}
	
	/**
	 * @return This method will read password from config file
	 */
	public static String getAppPassword() {
		return loadProperties().getProperty("password");
	}
	
	/**
	 * @return This method will read fluentWaitTime from config file
	 */
	public static long getFluentWaitTime() {

		return Long.parseLong(loadProperties().getProperty("fluentWaitTime"));
	}
}
