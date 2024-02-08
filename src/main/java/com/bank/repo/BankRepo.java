package com.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.Bank;

public interface BankRepo extends JpaRepository<Bank, Integer> {

}
