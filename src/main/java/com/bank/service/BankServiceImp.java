




package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.AmountResult;
import com.bank.entity.Bank;
import com.bank.entity.TransferDetails;
import com.bank.repo.BankRepo;
@Service
public class BankServiceImp implements BankService {

	
	@Autowired
	private BankRepo repo;
	
	
	@Override
	public Bank saveAccount(Bank bank) {

		Bank b=repo.save(bank);
		return b;
	}

	
	
	@Override
	public void findByAccount(int accountNumber) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Bank> allUsers() {
		// TODO Auto-generated method stub
		return null;
	}



	



	@Override
	public AmountResult withdraw(Bank bank, int accountNumber, String name, String password, double amount) {
		Bank existData = repo.findById(accountNumber).get();
		
		if(accountNumber==existData.getAccountNumber()&&password.equals(existData.getPassword())  ) {
			
			double prevBalance = existData.getAmount();
			double currentBalance = prevBalance-amount;
			
			existData.setAmount(currentBalance);
			repo.save(existData);
			
			AmountResult withdrawResult = new AmountResult();
			withdrawResult.setCurrentBalance(currentBalance);
			withdrawResult.setPrevBalance(prevBalance);
			withdrawResult.setAmount(amount);
			
			return withdrawResult;
			
		}
		else {
			return null;
		}
	}


	@Override
	public Bank balance(Bank bank, int accountNumber, String name, String password) {

		Bank b1=null;
		
		if(accountNumber==bank.getAccountNumber()&&name.equals(bank.getName())&&password.equals(bank.getPassword())) {
			
			b1 = repo.findById(accountNumber).get();
		}
		else {
			return null;
		}
		
		
		return b1;
	}



	@Override
	public AmountResult deposit(Bank bank, int accountNumber, String name, String password, double amount) {

//		double principleAmt=0.0;
//		
//		
//		if(accountNumber==bank.getAccountNumber() && name.equals(bank.getName()) && password.equals(bank.getPassword())) {
//			
//			principleAmt=bank.getAmount()+amount;
//			
//			
//		}
//			bank.setPricipleAmt(principleAmt);
//			Bank bb=repo.save(bank);
		
		
		
		Bank existData = repo.findById(accountNumber).get();
		
		if(accountNumber==existData.getAccountNumber()&&password.equals(existData.getPassword())  ) {
			
			double prevBalance = existData.getAmount();
			double currentBalnce = prevBalance+amount;
			
			existData.setAmount(currentBalnce);
			repo.save(existData);
			
			AmountResult result = new AmountResult();
			result.setCurrentBalance(currentBalnce);
			result.setPrevBalance(prevBalance);
			result.setAmount(amount);
			
			return result;
			
		}
		else {
			return null;
		}
		
		
		
	}



	@Override
	public TransferDetails transfer(int accountNumber, String name, String password, 
			int targetAccountNumber, double targetAmount, Bank bank) {

		
		
		Bank fromACTdata = repo.findById(accountNumber).get();
		Bank targetACTdata = repo.findById(targetAccountNumber).get();
		
		
		if(accountNumber==fromACTdata.getAccountNumber() && password.equals(targetACTdata.getPassword()) && name.equals(targetACTdata.getName()) ) {
			
			double prevBalance  = fromACTdata.getAmount();
			double currentBalance = prevBalance - targetAmount;
			
			fromACTdata.setAmount(currentBalance);
			repo.save(fromACTdata);
			
			
			TransferDetails accountDetails = new TransferDetails();
			accountDetails.setAccountNumber(accountNumber);
			accountDetails.setBalance(prevBalance);
			accountDetails.setAmount(targetAmount);
			
			
			
			
			
			double prevTargetBalance = targetACTdata.getAmount();
			double currentTargetBalance = prevTargetBalance + targetAmount;
			
			targetACTdata.setAmount(currentTargetBalance);
			repo.save(targetACTdata);
			
			accountDetails.setTargetAccountNumber(targetAccountNumber);
			accountDetails.setTargetPrevBalance(prevBalance);
			accountDetails.setTargetCurrentBalnce(currentBalance);
			
			return accountDetails;
			
			
		}
		
		
		
		
		
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
