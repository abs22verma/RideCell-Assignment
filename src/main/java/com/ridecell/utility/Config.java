package com.ridecell.utility;

import java.util.ResourceBundle;

public class Config {

	public static ResourceBundle rs =ResourceBundle.getBundle("base");
	
	public static ResourceBundle getResource() {
		return rs;
	}
	
	
}
