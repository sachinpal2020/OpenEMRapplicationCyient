package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage {

	private By patientClientLocator=By.xpath("//div[ @ data-bind='text:label']");
	private By patientsLocator=By.xpath("//div[contains(text(),'Patients')]");
	
	private WebDriver driver;

	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getDashboardPageTitle()
	{
		return driver.getTitle().trim();
	}
	
	public void mousehoverOnPatientClient()
	{
		Actions action1=new Actions(driver);
		action1.moveToElement(driver.findElement(patientClientLocator)).perform();
	}
	public void clickOnPatientClient() 
	{
		driver.findElement(patientsLocator).click();

	}
}
