package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase () {
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("H:\\Faizan\\Java\\WFM\\src\\Package\\POMframework\\src\\main\\java\\com\\crm\\config\\config.properties");
		
		prop.load(ip); }
		
		catch(FileNotFoundException e) {
			e.printStackTrace(); }
		catch (IOException e) {
			e.printStackTrace();}
	}
		
	public static  void initialization() {
			String broswerName = prop.getProperty("browser");
			if (broswerName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "H:\\Faizan\\chromedriver.exe");
			driver = new ChromeDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			
			
		
		
	}
	
}
