package com.qa.opencart.util;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;



public class OptionsManagerUtil {
	
	Properties prop;
	ChromeOptions co;
	FirefoxOptions fo;
	
	
	//consrtuctor
	
	public OptionsManagerUtil(Properties prop) {
		this.prop=prop;
		
	}
	
	
	public ChromeOptions getChromeOptions() {
	
		co=new ChromeOptions();
		
		if(prop.getProperty("headless").trim().equals("true")) co.addArguments("--headless");
		if(prop.getProperty("incognito").trim().equals("true")) co.addArguments("--incognito");
		return co;
		
		}
	
	
	public FirefoxOptions getFirefoxOptions() {
		
		fo=new FirefoxOptions();
		System.out.println(prop.getProperty("headless"));
		System.out.println(prop.getProperty("incognito"));
		if(prop.getProperty("headless").trim().equals("true")) fo.addArguments("--headless");
		if(prop.getProperty("incognito").trim().equals("true")) fo.addArguments("--incognito");
		return fo;
		
		}
	
}