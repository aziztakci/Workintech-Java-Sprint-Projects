package com.workintech.s19d2.service;

import com.workintech.s19d2.entity.Account;
import com.workintech.s19d2.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(long id) {
        return accountRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(long id, Account account) {
        Account foundedAccount = accountRepository.findById(id).orElseThrow(RuntimeException::new);
        foundedAccount.setName(account.getName());
        return  accountRepository.save(foundedAccount);
    }

    @Override
    public Account delete(long id) {
        Account foundedAccount = accountRepository.findById(id).orElseThrow(RuntimeException::new);
        accountRepository.delete(foundedAccount);
        return foundedAccount;
    }
}
