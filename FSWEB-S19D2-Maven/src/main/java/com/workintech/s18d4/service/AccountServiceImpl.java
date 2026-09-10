package com.workintech.s18d4.service;

import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.repository.AccountRepository;
import com.workintech.s18d4.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<AccountResponse> findAll() {
        return accountRepository.findAll().stream()
                .map(account -> new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount()))
                .collect(Collectors.toList());
    }

    @Override
    public AccountResponse findById(long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));

        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount());
    }

    @Transactional
    @Override
    public AccountResponse save(Account account, long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));

        customer.addAccount(account);
        account.setCustomer(customer);

        Account savedAccount = accountRepository.save(account);
        return new AccountResponse(savedAccount.getId(), savedAccount.getAccountName(), savedAccount.getMoneyAmount());
    }

    @Transactional
    @Override
    public AccountResponse update(Account account, long customerId) {
        Customer yeniCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));

        Account mevcutAccount = accountRepository.findById(account.getId())
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + account.getId()));

        // 1. Müşteri değişiyorsa eski müşterinin bellek içi (in-memory) listesinden çıkar
        if (mevcutAccount.getCustomer() != null && !mevcutAccount.getCustomer().equals(yeniCustomer)) {
            mevcutAccount.getCustomer().getAccounts().remove(mevcutAccount);
        }

        // 2. Mevcut nesnenin alanlarını güncelle (Gelen entity'yi direkt kaydetmek yerine)
        mevcutAccount.setAccountName(account.getAccountName());
        mevcutAccount.setMoneyAmount(account.getMoneyAmount());

        // 3. İlişkileri güncelle ve çift taraflı senkronize et
        yeniCustomer.addAccount(mevcutAccount);
        mevcutAccount.setCustomer(yeniCustomer);

        // 4. Yönetilen (managed) mevcut nesneyi kaydet
        Account updatedAccount = accountRepository.save(mevcutAccount);

        return new AccountResponse(updatedAccount.getId(), updatedAccount.getAccountName(), updatedAccount.getMoneyAmount());
    }

    @Transactional
    @Override
    public AccountResponse delete(long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));

        accountRepository.delete(account);
        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount());
    }
}