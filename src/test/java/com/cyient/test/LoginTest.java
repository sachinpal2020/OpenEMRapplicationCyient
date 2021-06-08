package com.cyient.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWrapper;
import com.cyient.page.DashboardPage;
import com.cyient.page.LoginPage;
import com.cyient.utilities.DataProviderUtils;

public class LoginTest extends WebDriverWrapper {
	
	
	

	@Test(dataProvider="invalidData",dataProviderClass=DataProviderUtils.class)
    public void invalidCredentialTest(String username, String password,String languageText, String expectedValue)
    {
		
		LoginPage login=new LoginPage(driver);
		login.sendUsername(username);
		login.sendPassword(password);
		login.selectLanguageByText(languageText);
		login.clickOnLogin();
		
		DashboardPage dashboard=new DashboardPage(driver);
		
		String actualValue=login.getErrorMessage();
		Assert.assertEquals(actualValue, expectedValue);
		
		
		//driver.findElement(By.id("authUser")).sendKeys("adminnn");
	//	driver.findElement(By.id("clearPass")).sendKeys("pass");
        
	//	Select selectLanguage=new Select(driver.findElement(By.name("languageChoice")));
		//selectLanguage.selectByVisibleText("English (Indian)");
		
		//driver.findElement(By.xpath("//button[@class='btn btn-login btn-lg']")).click();

		//String actualValue=driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText();
		//Assert.assertEquals(actualValue, "Invalid username or password");
    

    }
	
	
	@Test(dataProvider="validData",dataProviderClass=DataProviderUtils.class)
	public void validCredentialTest(String username, String password, String languageText, String expectedValue) {
		
		LoginPage login=new LoginPage(driver);
		login.sendUsername(username);
		login.sendPassword(password);
		login.selectLanguageByText(languageText);
		login.clickOnLogin();
		
		DashboardPage dashboard=new DashboardPage(driver);
		
		String actualValue=driver.findElement(By.xpath("//span[contains(text(),'Calendar')]")).getText();
		Assert.assertEquals(actualValue, expectedValue);
		
		
		
		
		
		//driver.findElement(By.xpath("//button[@class='btn btn-login btn-lg']")).click();
		
		//Assert.assertEquals(driver.getTitle(),"OpenEMR");
		
		//String actualValue=driver.findElement(By.xpath("//span[contains(text(),'Calendar')]")).getText();
		//Assert.assertEquals(actualValue, "Calendar");
		
	}
	
	@Test
	public void validateUIComponentTest() {
		
		String actualText=driver.findElement(By.xpath("//p[contains(text(),'most')]")).getText();
		Assert.assertEquals(actualText, "The most popular open-source Electronic Health Record and Medical Practice Management solution.");
	
		
		String actualText1=driver.findElement(By.xpath("//a[contains(text(),'Acknowledgments')]")).getText();
		Assert.assertEquals(actualText1, "Acknowledgments, Licensing and Certification");
	
	
		String actualUsernamePlaceholderValue=driver.findElement(By.id("authUser")).getAttribute("placeholder");
		Assert.assertEquals(actualUsernamePlaceholderValue, "Username:");
		
		
		String actualPasswordPlaceholderValue=driver.findElement(By.id("clearPass")).getAttribute("placeholder");
		Assert.assertEquals(actualPasswordPlaceholderValue, "Password:");
	
		
	
	}
	
}
