package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.javabank.managers.AccountManager;

import java.util.HashMap;
import java.util.Map;

/**
 * The bank entity
 */
public class Bank {

    private AccountManager accountManager;
    private Map<Integer, Customer> customers;
    private int id = 0;

    /**
     * Creates a new instance of Bank and initializes it with the given account manager
     *
     * @param accountManager the account manager
     */
    public Bank(AccountManager accountManager) {
        this.accountManager = accountManager;
        customers = new HashMap<>();
    }

    /**
     * Adds a new customer to the bank
     *
     * @param customer the new bank customer
     * @see Customer#setAccountManager(AccountManager)
     */
    public void addCustomer(Customer customer) {
        id++;
        customers.put(id, customer);
        customer.setAccountManager(accountManager);
    }

    /**
     * Gets the total balance of the bank
     *
     * @return the bank total balance
     */
    public double getBalance() {

        double balance = 0;

        for (Customer customer : customers.values()) {
            balance += customer.getBalance();
        }

        return balance;
    }

    public Customer checkCustomerId(int id) {
        return customers.get(id);
    }
}
