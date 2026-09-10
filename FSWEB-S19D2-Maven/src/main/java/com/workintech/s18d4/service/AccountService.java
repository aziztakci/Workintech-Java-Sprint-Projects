package com.workintech.s18d4.service;

import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {

    List<AccountResponse> findAll();
    AccountResponse findById(long id);
    AccountResponse save(Account account,long customerId);
    AccountResponse update(Account account,long customerId);
    AccountResponse delete(long id);

}
