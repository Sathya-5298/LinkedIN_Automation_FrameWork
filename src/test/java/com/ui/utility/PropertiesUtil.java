package com.ui.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil 
{
	public static String readProperty(Env env, String propertyName)
	{
		File propFile = new File(System.getProperty("user.dir") + "//Config//"+env+".properties");
		FileReader reader = null;
		Properties properties = new Properties();
		try {
			reader = new FileReader(propFile);
			properties.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		String value = properties.getProperty(propertyName.toUpperCase());
		
		return value;
	}
}
