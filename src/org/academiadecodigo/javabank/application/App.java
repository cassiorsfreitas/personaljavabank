package org.academiadecodigo.javabank.application;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;


public class App {

    private boolean validation = false;
    private Customer customer;

    public void start(Bank bank, AccountManager accountManager) {

        Prompt prompt = new Prompt(System.in, System.out);
        IntegerInputScanner questionNumberId = new IntegerInputScanner();

        while (!validation) {
            questionNumberId.setMessage("Please insert your costumer number: ");
            int customerId = prompt.getUserInput(questionNumberId);
            customer = bank.checkCustomerId(customerId);
            if (customer != null) {
                validation = true;
            }
        }

        Menu menu = new Menu(prompt, customer, accountManager);
        menu.showMenu();
    }
}
