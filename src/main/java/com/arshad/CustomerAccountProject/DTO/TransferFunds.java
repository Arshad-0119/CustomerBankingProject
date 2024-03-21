package com.arshad.CustomerAccountProject.DTO;


public class TransferFunds {
	
	private int sourceAccountId;
	private int destinationAccountId;
	private int amount;
	
	public TransferFunds() {
		
	}
	
	public TransferFunds(int sourceAccountId, int destinationAccountId, int amount) {
		super();
		this.sourceAccountId = sourceAccountId;
		this.destinationAccountId = destinationAccountId;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TransferFunds [sourceAccountId=" + sourceAccountId
				+ ", destinationAccountId=" + destinationAccountId + ", amount=" + amount + "]";
	}

	public int getSourceAccountId() {
		return sourceAccountId;
	}
	public void setsourceAccountId(int sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}
	public int getDestinationAccountId() {
		return destinationAccountId;
	}
	public void setDestinationAccount(int destinationAccountId) {
		this.destinationAccountId = destinationAccountId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
