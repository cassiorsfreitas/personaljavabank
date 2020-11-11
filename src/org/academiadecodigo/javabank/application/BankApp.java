package org.academiadecodigo.javabank.application;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;


public class BankApp {

    //SANDBOX
    AccountManager accountManager = new AccountManager();
    Bank bank = new Bank(accountManager);
    Customer customer1 = new Customer();
    Customer customer2 = new Customer();

    private boolean validation = false;

    public void start() {

        //SANDBOX
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        Prompt prompt = new Prompt(System.in, System.out);
        IntegerInputScanner questionNumberId = new IntegerInputScanner();

        while (!validation) {
            questionNumberId.setMessage("Please insert your costumer number: ");
            int customerId = prompt.getUserInput(questionNumberId);
            validation = bank.checkCustomerId(customerId);
        }

        Menu menu = new Menu();
        menu.show();

    }
}
