package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
	initialization();
	loginPage = new LoginPage();
	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateloginpagetitle();
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void crmlogoImageTest() {
		boolean flag = loginPage.validatecrmimage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}
