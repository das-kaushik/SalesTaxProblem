package com.boku.codingassignment.SalesTaxProblem;

import java.io.InputStream;
import java.util.List;

public class StdInputProcessor extends InputProcessor implements IInputProcessor {
	private InputStream inputStream;

	public StdInputProcessor(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public List<PurchaseItem> parseInput() throws InvalidInputException {
		if (inputStream != null) {
			return this.parseInput(inputStream);
		}
		return null;
	}

}
