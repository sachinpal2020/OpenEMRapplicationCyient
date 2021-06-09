package com.cyient.test;



import org.openqa.selenium.By;

import org.testng.Assert;

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

    }
	
	
	@Test(dataProvider="validCredentialExcelData",dataProviderClass=DataProviderUtils.class)
	public void validCredentialTest(String username, String password, String languageText, String expectedValue) {
		
		LoginPage login=new LoginPage(driver);
		login.sendUsername(username);
		login.sendPassword(password);
		login.selectLanguageByText(languageText);
		login.clickOnLogin();
		
		DashboardPage dashboard=new DashboardPage(driver);
		
		String actualValue=driver.getTitle();
		Assert.assertEquals(actualValue, expectedValue);
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
