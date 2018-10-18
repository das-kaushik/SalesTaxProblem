package com.boku.codingassignment.SalesTaxProblem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FileInputProcessor extends InputProcessor implements IInputProcessor {
	private String filePath;

	public FileInputProcessor(String filePath) {
		this.filePath = filePath;
	}

	/*
	 * Passes on the stream to base class InputStreamProcessor where the stream is
	 * read and parsed. If file is not found, IOException(FileNotFoundException is
	 * thrown to outer layer from where it is called.)
	 */
	@Override
	public List<PurchaseItem> parseInput() throws InvalidInputException, IOException {
		File file = new File(filePath);
		InputStream inputStream = new FileInputStream(file);
		return this.parseInput(inputStream);
	}

}
