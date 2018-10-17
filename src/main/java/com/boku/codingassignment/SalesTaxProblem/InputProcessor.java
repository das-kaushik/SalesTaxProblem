package com.boku.codingassignment.SalesTaxProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public abstract class InputProcessor {

	private static final String SPACE = " ";
	private static final String IMPORTED = "imported ";

	public List<PurchaseItem> parseInput(InputStream inputStream) throws InvalidInputException {
		List<String> inputs = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		System.out.println("Enter the number of inputs");
		try {
			int noOfLines = Integer.parseInt(bufferedReader.readLine());
			while (noOfLines-- > 0) {
				inputs.add(bufferedReader.readLine());
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new InvalidInputException();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new InvalidInputException();
			}
		}
		List<PurchaseItem> purchaseItems = new ArrayList<>();

		if (inputs != null && !inputs.isEmpty()) {
			for (String input : inputs) {
				String inputStr = input.trim();
				String[] inputArr = inputStr.split(SPACE);
				Integer quantity = Util.tryParseInt(inputArr[0].trim());
				int index = 1;
				String productDesc = inputStr.substring(inputStr.indexOf(inputArr[index]), inputStr.lastIndexOf("at"))
						.trim();
				boolean isImported = productDesc.contains(IMPORTED);
				if (isImported) {
					productDesc = productDesc.replace(IMPORTED, "");
				}
				Double price = Util.tryParseDouble(inputArr[inputArr.length - 1]);
				if (quantity == null || price == null)
					throw new InvalidInputException();
				PurchaseItem purchaseItem = PurchaseItemFactory.createPurchaseItem(productDesc, quantity, isImported,
						price);
				purchaseItems.add(purchaseItem);
			}
		}
		return purchaseItems;
	}
}
