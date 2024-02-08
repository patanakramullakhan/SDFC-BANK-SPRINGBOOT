package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.entity.Bank;
import com.bank.service.BankService;

@Controller
public class BankController {
	@Autowired
	private BankService service;
	
	
	@RequestMapping("/")
	public String homePage() {
		
		return "home";
	}
	
	@RequestMapping("/newAccountUrl")
	public String newAccountPage() {
		
		return "newAccount";
	}
	
	
	@RequestMapping("/newAccount")
	public String saveAccountDetails(Bank bank) {
		Bank s = service.saveAccount(bank);
		
		return "success";
	}
	
//	balance
	@RequestMapping("/balanceUrl")
	public String balanceFormPage() {
		
		return "balanceForm";
	}
	
	@RequestMapping("/balanceForm")
	public String balance(@RequestParam int accountNumber,@RequestParam String name,@RequestParam String password,Bank bank,ModelMap model) {
		
		model.put("banks",service.balance(bank,accountNumber,name,password) );
		
		
		return "balanceResult";
	}
	
	
	
	
	
	
	
	
//	deposit
	@RequestMapping("/depositUrl")
	public String depositFormPage() {
		
		return "depositForm";
	}
	
	
	@RequestMapping("/deposit")
	public String deposit (@RequestParam int accountNumber,@RequestParam String name,@RequestParam String password,@RequestParam double amount, Bank bank,ModelMap model) {
		
		model.put("result", service.deposit(bank,accountNumber,name,password,amount));
		
		return "depositResult";
	}
	
	
//	withdraw
	@RequestMapping("/withdrawUrl")
	public String withdrawFormPage() {
		
		return "withdrawForm";
	}
	
	
	@RequestMapping("/withdraw")
	public String withdraw (@RequestParam int accountNumber,@RequestParam String name,@RequestParam String password,@RequestParam double amount, Bank bank,ModelMap model) {
		
		model.put("withdrawResult", service.withdraw(bank,accountNumber,name,password,amount));
		
		return "withdrawResult";
	}
	
	
	
	
	//transfer
	@RequestMapping("/transferUrl")
	public String transferMoneyForm() {
		
		return "transferForm";
	}
	
	@RequestMapping("/transfer")
	public String transfer(@RequestParam int accountNumber,@RequestParam String name,@RequestParam String password,@RequestParam int targetAccountNumber ,@RequestParam double targetAmount, Bank bank,ModelMap model) {
		
		model.put("accountDetails",service.transfer(accountNumber, name, password, targetAccountNumber, targetAmount, bank) );
		
		
		return "transferResult";
	}
	
	
	
	
	
	
	
	
	
	
	
}
