package org.academiadecodigo.javabank.application.operations;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.managers.AccountManager;

import java.util.ArrayList;
import java.util.List;

public class ViewBalance implements Operation {

    @Override
    public void execute(Prompt prompt, AccountManager accountManager, Customer customer) {

        List<String> list = new ArrayList<>();
        for (Account account : customer.getAccounts().values()) {
            list.add(account.getAccountType() + " " + account.getId());
        }

        String[] options = new String[list.size()];
        list.toArray(options);

        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage("Select account:");
        int accountId = prompt.getUserInput(menu);

        double balance = customer.getBalance(accountId);
        System.out.println("Balance: " + balance);

    }
}
