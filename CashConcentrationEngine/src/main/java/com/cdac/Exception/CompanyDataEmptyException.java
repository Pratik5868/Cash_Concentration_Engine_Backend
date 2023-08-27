package com.cdac.Exception;

public class CompanyDataEmptyException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public CompanyDataEmptyException(String message) {
		super(message);
	}

}
