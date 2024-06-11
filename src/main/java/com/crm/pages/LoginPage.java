package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up']")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	//Initializing the Page Objects
	public LoginPage () {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public String validateloginpagetitle() {
		return driver.getTitle();
	}
	
	public boolean validatecrmimage() {
		return crmlogo.isDisplayed();
		
	}
	
	public HomePage login (String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn.click();
		
		return new HomePage();
	}
	
	
	
	
	

}
