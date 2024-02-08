package com.bank.service;

import java.util.List;

import com.bank.entity.AmountResult;
import com.bank.entity.Bank;
import com.bank.entity.TransferDetails;

public interface BankService {

	public Bank saveAccount(Bank bank);
	public void findByAccount(int accountNumber);
	public List<Bank> allUsers();
	public AmountResult deposit(Bank bank,int accountNo,String name,String password,double amount);
	public AmountResult withdraw(Bank bank, int accountNumber, String name, String password, double amount);
	public TransferDetails transfer(int accountNumber,String name,String password,int targetAccountNumber,double targetAmount,Bank bank);
	public Bank balance(Bank bank,int accountNo,String name,String password);
	
	
	
	
}
