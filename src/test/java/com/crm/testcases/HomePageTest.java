package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		}

	@Test(priority=1)
	public void verifyhomepagetitletest() {
		String homePageTitle = homePage.verifyhomepagetitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home page title not matched");
	}
	@Test(priority=2)
	public void verifyusernametest() {
		testUtil.switchtoframe();
		Assert.assertTrue(homePage.verifycorrectusername());
	}
	@Test(priority=3)
	public void verifycontactslinkTest() {
		testUtil.switchtoframe();
		contactsPage = homePage.clickonContactsPage();
		}
	
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
	

