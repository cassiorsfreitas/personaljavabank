package org.academiadecodigo.javabank.service;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.service.interfaces.AccountService;

import java.util.HashMap;
import java.util.Map;

public class AccountLogic implements AccountService {

    private Map<Integer, Account> accounts = new HashMap<>();
    @Override
    public void add(Account account) {
            accounts.put(account.getId(), account);
    }

    @Override
    public void deposit(int id, double amount) {

    }

    @Override
    public void withdraw(int id, double amount) {

    }

    @Override
    public void transfer(int srcId, int dstId, double amount) {

    }
}
