package com.cyient.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils 
{
	@DataProvider
	public Object [][] validData()
	{
		Object[][] main = new Object[3][4];
		
		main[0][0]="admin";
		main[0][1]="pass";
		main[0][2]="English (Indian)";
		main[0][3]="Calendar";
		
		main[1][0]="physician";
		main[1][1]="physician";
		main[1][2]="English (Indian)";
		main[1][3]="Calendar";
		
		main[2][0]="clinician";
		main[2][1]="clinician";
		main[2][2]="English (Indian)";
		main[2][3]="Calendar";
		
		return main;
	}
	
	@DataProvider
	public Object [][] invalidData()
	{
		Object[][] main = new Object[2][4];
		
		main[0][0]="john";
		main[0][1]="john123";
		main[0][2]="Dutch";
		main[0][3]="Invalid username or password";
		
		main[1][0]="peter";
		main[1][1]="peter123";
		main[1][2]="German";
		main[1][3]="Invalid username or password";
		
		
		return main;
	}
}
