package com.lucifer.service;

import com.lucifer.dao.AccountRepository;
import com.lucifer.dao.domain.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lucifer on 2019/5/12 22:24
 **/
@RestController
@RequestMapping(path = "account-service")
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/account/{id}")
    Account getAccount(@PathVariable("id") long accountId) {
        return accountRepository.getAccountByAccountId(accountId);
    }

    @GetMapping("/account/{id}/cache")
    Account cache(@PathVariable("id") long accountId) {
        return accountRepository.getAccountByAccountId(accountId);
    }
}
