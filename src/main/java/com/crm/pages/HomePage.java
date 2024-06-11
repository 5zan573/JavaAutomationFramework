package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: Mohd Faizan Hussain')]")
	WebElement UsernameLabel;
	
	@FindBy(xpath="//*[text()=('Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//*[text()=('Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//*[text()=('Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement newContactsLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
		public String verifyhomepagetitle() {
			return driver.getTitle();
		}
		
		public boolean verifycorrectusername() {
			return UsernameLabel.isDisplayed();
			}
		
		public DealsPage clickonDealsLink() {
			dealsLink.click();
			return new DealsPage();
		}
	
		public TasksPage clickonTasksPage() {
			tasksLink.click();
			return new TasksPage();
		}
		public ContactsPage clickonContactsPage() {
			contactsLink.click();
			return new ContactsPage();	
	    }
		public void clickonNewContactLink() {
			Actions action = new Actions(driver);
			action.moveToElement(contactsLink).build().perform();
			newContactsLink.click();
			}
		
		
}
