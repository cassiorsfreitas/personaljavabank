package org.academiadecodigo.javabank.application;

import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;

public class LauncherApp {
    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();
        Bank bank = new Bank(accountManager);
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        App app = new App();
        app.start(bank, accountManager);
    }

}
