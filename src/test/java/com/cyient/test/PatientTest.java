package com.cyient.test;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWrapper;
import com.cyient.page.DashboardPage;
import com.cyient.page.LoginPage;
import com.cyient.page.PatientFinderPage;

public class PatientTest extends WebDriverWrapper {

	
	@Test
	public void addPatientTest() throws InterruptedException
	{
		/*driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		Select selectLanguage = new Select(driver.findElement(By.name("languageChoice")));
		selectLanguage.selectByVisibleText("English (Indian)");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();*/
		
		LoginPage login=new LoginPage(driver);
		login.sendUsername("admin");
		login.sendPassword("pass");
		login.selectLanguageByText("English (Indian)");
		login.clickOnLogin();
		
		//Dashboard
		DashboardPage dashboard=new DashboardPage(driver);
		dashboard.mousehoverOnPatientClient();
		dashboard.clickOnPatientClient();
		
		
		
		//Actions action1=new Actions(driver);
		//action1.moveToElement(driver.findElement(By.xpath("//div[ @ data-bind='text:label']"))).perform();
		//driver.findElement(By.xpath("//div[contains(text(),'Patients')]")).click();
		
		
		//PatientFinder Page
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@ src='/a/openemr/interface/main/finder/dynamic_finder.php']")));
		//driver.findElement(By.id("create_patient_btn1")).click();
		//driver.switchTo().defaultContent();
		
		//Add Patient
		
		PatientFinderPage patient=new PatientFinderPage(driver);
		patient.switchToFinFrame();
		patient.clickOnAddNewPatient();
		patient.switchOutOfFrame();
		
		
		
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@ src='/a/openemr/interface/new/new.php']")));
		Select sirname=new Select(driver.findElement(By.id("form_title")));
		sirname.selectByValue("Mr.");
		driver.findElement(By.id("form_fname")).sendKeys("xYZ");
		driver.findElement(By.id("form_mname")).sendKeys("ABC");
		driver.findElement(By.id("form_lname")).sendKeys("PQRS");
		driver.findElement(By.id("form_DOB")).sendKeys("2021-06-07");
		
		Select sex =new Select(driver.findElement(By.id("form_sex")));
		sex.selectByValue("Male");
		driver.findElement(By.id("create")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@ id='modalframe']")));
		driver.findElement(By.xpath("//input[@ value='Confirm Create New Patient']")).click();
		//Thread.sleep(5000);
		//driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).click();
		//driver.switchTo().alert().accept();
		
		Thread.sleep(5000);
		 driver.switchTo().alert().accept();
		 driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).click();
		 
		 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pat']")));
		 
		 String actualValue=driver.findElement(By.xpath("//h2[contains(text(),'Medical Record')]")).getText();
		 
		 System.out.println(actualValue);
			Assert.assertEquals(actualValue, "Medical Record Dashboard - XYZ PQRS   ");
		 
		
	}
}
