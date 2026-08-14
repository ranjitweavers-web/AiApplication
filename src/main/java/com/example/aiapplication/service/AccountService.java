package com.example.aiapplication.service;

import com.example.aiapplication.model.Account;
import com.example.aiapplication.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

	private final AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Transactional
	public Account updateAccount(Long id, BigDecimal balance) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
		account.setBalance(balance);
		return accountRepository.save(account);
	}
}