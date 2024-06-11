package com.crm.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "Sheet1";

	public ContactsPageTest() {
		super();
	}
	@BeforeMethod
	public void Setup() {
		TestBase.initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		testUtil.switchtoframe();
		contactsPage = homePage.clickonContactsPage();
		}
	
    @Test(priority=1)
    public void contactslabletest() {
    	contactsPage.verifycontactslabel();
    }
    
    @Test(priority=2)
    public void selectcontactsverify() {
    	contactsPage.selectcontactsByName("Test Test");
    	contactsPage.selectcontactsByName("Test2 Test2");
    }
        
    
    @Test(priority=3, dataProvider="getTestDataTest")
    public void newcontactsTest () {
    	homePage.clickonNewContactLink();
    	contactsPage.createNewContact("Mr.", "Tom", "Peter", "google");
    }
	
    @AfterMethod
    public void teardown() {
	driver.quit();
    }

}
