package com.wipro.crm.util;

public class InvalidInputException extends Exception {
	private String message ;
	
	public InvalidInputException (String message ) {
		this.message=message;
	}
	@Override
	public String toString() {
		return "Invalid Input Exception"+message ;
		
	}
	

}
