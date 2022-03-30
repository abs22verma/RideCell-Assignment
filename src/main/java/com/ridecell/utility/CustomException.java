package com.ridecell.utility;

public class CustomException extends RuntimeException{

	public CustomException(String message) {
		super(message);
	}
	
	public CustomException(String message, Throwable e) {
		super(message,e);
	}
}
