package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.models.TestData;
import com.ui.models.User;
import com.ui.utility.CSVReaderUtility;
import com.ui.utility.ExcelReaderUtility;

public class LoginDataProvider 
{
	
	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider()
	{
		Gson gson = new Gson();
		FileReader reader = null;
		
		File testDatafile = new File(System.getProperty("user.dir") + "\\TestData\\logindata.json");
		try {
			 reader = new FileReader(testDatafile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		TestData data = gson.fromJson(reader, TestData.class);
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		
		for(User user:data.getData())
		{
			dataToReturn.add(new Object[] {user});
		}
		return dataToReturn.iterator();
	}
	
	@DataProvider(name = "LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider()
	{
		return CSVReaderUtility.readCSVFile("logindata.csv");
	}
	
	@DataProvider(name = "LoginTestExcelDataProvider")
	public Iterator<User> loginExcelDataProvider()
	{
		return ExcelReaderUtility.readExcelFile("logindata.xlsx");
	}
}
