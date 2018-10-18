package com.boku.codingassignment.SalesTaxProblem;

public class InvalidInputException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidInputException() {
		super("Input is invalid.");
	}

	public InvalidInputException(String errorMessage) {
		super(errorMessage);
	}
}
