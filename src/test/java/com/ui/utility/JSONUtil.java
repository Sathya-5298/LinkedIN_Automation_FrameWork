package com.ui.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.models.Config;
import com.ui.models.Environment;

public class JSONUtil 
{
	public static Environment readJson(Env env)
	{
		Gson gson = new Gson();
		File jsonFile = new File(System.getProperty("user.dir") + "//Config//config.json");
		FileReader reader = null;
		try {
			reader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Config config = gson.fromJson(reader, Config.class);
		Environment environment = config.getEnvironments().get("QA");
		return environment;
	}
}
