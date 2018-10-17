package com.boku.codingassignment.SalesTaxProblem;

public class InvalidInputException extends Exception {
	public InvalidInputException() {
		super("Input is invalid.");
	}

	public InvalidInputException(String errorMessage) {
		super(errorMessage);
	}
}
