package com.example.aiapplication.controller;

import com.example.aiapplication.model.Account;
import com.example.aiapplication.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestParam BigDecimal balance) {
		// comment added.
		// fixed indentation.
		// add declaration
		Account account = accountService.updateAccount(id, balance);

		return ResponseEntity.ok(account);
	}
}