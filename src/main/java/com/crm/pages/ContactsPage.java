package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.TestBase;

public class ContactsPage extends TestBase {
	
	 public ContactsPage() {
	    	PageFactory.initElements(driver, this);
	 }
	 
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	@FindBy(id="surname")
	WebElement lastName;
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@value='Save' and @type='submit']")
	WebElement saveBtn;
	
	public boolean verifycontactslabel() {
		return contactslabel.isDisplayed();
	}
	
	public void selectcontactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title, String fName, String lName, String comp ) {
	Select select= new Select(driver.findElement(By.name("title")));
	select.selectByVisibleText(title);
	
	firstName.sendKeys(fName);
	lastName.sendKeys(lName);
	company.sendKeys(comp);
	saveBtn.click();
	}

	
}

