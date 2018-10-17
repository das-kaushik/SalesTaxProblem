package com.boku.codingassignment.SalesTaxProblem;

public class Main {
	public static void main(String[] args) throws Exception{
		IInputProcessor inputProcessor = new StdInputProcessor(System.in);
		ReceiptProcessor receiptProcessor = new ReceiptProcessor();
		TaxProcessor taxProcessor = new TaxProcessor(inputProcessor, receiptProcessor);
		taxProcessor.process();
	}
}
