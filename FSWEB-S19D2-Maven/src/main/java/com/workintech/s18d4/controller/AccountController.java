package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountResponse> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public AccountResponse findById(@PathVariable long id) {
        return accountService.findById(id);
    }

    @PostMapping("/{customerId}")
    public AccountResponse save(@RequestBody Account account, @PathVariable long customerId) {
        return accountService.save(account, customerId);
    }

    @PutMapping("/{customerId}")
    public AccountResponse update(@RequestBody Account account, @PathVariable long customerId) {
        return accountService.update(account, customerId);
    }

    @DeleteMapping("/{id}")
    public AccountResponse delete(@PathVariable long id) {
        return accountService.delete(id);
    }
}