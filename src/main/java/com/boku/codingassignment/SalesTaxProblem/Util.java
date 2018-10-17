package com.boku.codingassignment.SalesTaxProblem;

public class Util {
	public static Integer tryParseInt(String inputStr) {
		try {
			return Integer.parseInt(inputStr);
		} catch (NumberFormatException ex) {
			return null;
		}

	}

	public static Double tryParseDouble(String inputStr) {
		try {
			return Double.parseDouble(inputStr);
		} catch (NumberFormatException ex) {
			return null;
		}
	}

	public static double roundOff(double value, double roundOff) {
		return Math.ceil(value / roundOff) * roundOff;
	}
}
