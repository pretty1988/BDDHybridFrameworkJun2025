package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;

import cucumber.api.Scenario;

/**
 * @author prett
 *
 * this class has page factory code for orangehrm login page
 */
public class LoginPage {
	
	WebDriver driver;
	Scenario scenario;
	
	//3 things each class created for a new page required
	//page object repository - Elements located by find by annotation
	//Page class constructor
	//Page operation methods
	
	//page object repository - Elements located by find by annotation
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;

	@FindBy(xpath = "//button[text()=' Login ']")
	WebElement loginButton;

	@FindBy(xpath = "//h6[text()='Dashboard']")
	WebElement homepageTitle;
	
	//Page class constructor
	
	/**
	 * @param driver
	 * @param scenario
	 * 
	 * driver initialization
	 */
	public LoginPage(WebDriver driver,Scenario scenario){
		
		this.driver=driver;
		this.scenario=scenario;
		PageFactory.initElements(driver, this);
		
	}
	
	/**
	 * @param userName
	 * @param userPassword
	 * @return 
	 * 
	 * this method will accept username and password and return home page text
	 */
	public String logintoApplication(String userName, String userPassword){
		
		ElementActions.sendKeys(driver, userNameField, scenario, userName);
		ElementActions.sendKeys(driver, passwordField, scenario,userPassword );
		ElementActions.clickElement(driver, loginButton, scenario);
		return ElementActions.getText(driver, homepageTitle, scenario);
		
	}

}
