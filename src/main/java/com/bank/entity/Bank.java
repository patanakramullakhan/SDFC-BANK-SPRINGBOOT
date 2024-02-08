package com.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Bank {

    @Id
    private int accountNumber;
    private String name;
    private String password;
    private String confirmPassword;
    private double amount;
    private String address;
    private long mobileNo;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    public enum Status {
        ACTIVE,
        INACTIVE;
        // Add more statuses if needed
    }

	public Bank() {
		super();
	}

	public Bank(int accountNumber, String name, String password, String confirmPassword, double amount, String address,
			long mobileNo, Status status) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.amount = amount;
		this.address = address;
		this.mobileNo = mobileNo;
		this.status = status;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bank [accountNumber=" + accountNumber + ", name=" + name + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", amount=" + amount + ", address=" + address + ", mobileNo="
				+ mobileNo + ", status=" + status + "]";
	}
    
   
    
    
    
}
