package com.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	
	public static String config(String key) throws IOException {		
		Properties properties = new Properties();		
		FileInputStream file = new FileInputStream(new File("Config.properties"));		
		properties.load(file);
		return properties.get(key).toString();
	}

	
	public  static void main(String[] args) throws IOException {
		String url = config("Url");
		System.out.println(url);
		System.out.println(config("Password"));
		System.out.println(config("UserName"));
	}
}
