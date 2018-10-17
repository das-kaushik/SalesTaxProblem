package com.boku.codingassignment.SalesTaxProblem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class FileInputProcessor extends InputProcessor implements IInputProcessor {
	private String filePath;

	public FileInputProcessor(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public List<PurchaseItem> parseInput() throws InvalidInputException {
		File file = new File(filePath);
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (inputStream != null) {
			return this.parseInput(inputStream);
		}
		return null;
	}

}
