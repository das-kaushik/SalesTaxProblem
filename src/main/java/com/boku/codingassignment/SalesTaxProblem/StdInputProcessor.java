package com.boku.codingassignment.SalesTaxProblem;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StdInputProcessor extends InputProcessor implements IInputProcessor {
	private InputStream inputStream;

	public StdInputProcessor(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public List<PurchaseItem> parseInput() throws InvalidInputException, IOException {
		if (inputStream != null) {
			return this.parseInput(inputStream);
		}
		return null;
	}

}
