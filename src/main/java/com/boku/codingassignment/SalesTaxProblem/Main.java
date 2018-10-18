package com.boku.codingassignment.SalesTaxProblem;

import java.io.IOException;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// IInputProcessor inputProcessor = new StdInputProcessor(System.in);
		IInputProcessor inputProcessor = new FileInputProcessor("SampleInput");
		try {
			List<PurchaseItem> purchaseItems = inputProcessor.parseInput();
			ReceiptProcessor receiptProcessor = new ReceiptProcessor();
			TaxProcessor taxProcessor = new TaxProcessor();
			process(purchaseItems, taxProcessor, receiptProcessor);
		} catch (InvalidInputException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void process(List<PurchaseItem> purchaseItems, TaxProcessor taxProcessor,
			ReceiptProcessor receiptProcessor) {

		taxProcessor.process(purchaseItems);
		receiptProcessor.generateReceipt(purchaseItems);
	}
}
