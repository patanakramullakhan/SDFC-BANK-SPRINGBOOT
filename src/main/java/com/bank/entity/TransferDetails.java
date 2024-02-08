package com.bank.entity;

public class TransferDetails {

	private int accountNumber;
	private double balance;
	private double amount;
	private int targetAccountNumber;
	private double targetPrevBalance;
	private double targetCurrentBalnce;
	
	
	
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getTargetAccountNumber() {
		return targetAccountNumber;
	}
	public void setTargetAccountNumber(int targetAccountNumber) {
		this.targetAccountNumber = targetAccountNumber;
	}
	public double getTargetPrevBalance() {
		return targetPrevBalance;
	}
	public void setTargetPrevBalance(double targetPrevBalance) {
		this.targetPrevBalance = targetPrevBalance;
	}
	public double getTargetCurrentBalnce() {
		return targetCurrentBalnce;
	}
	public void setTargetCurrentBalnce(double targetCurrentBalnce) {
		this.targetCurrentBalnce = targetCurrentBalnce;
	}
	
	
	
	
	
}
