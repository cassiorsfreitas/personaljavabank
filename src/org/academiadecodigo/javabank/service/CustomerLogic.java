package org.academiadecodigo.javabank.service;

import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.service.interfaces.CustomerService;

import java.util.*;

public class CustomerLogic implements CustomerService {


    private final HashMap<Integer, Customer> customers;
    private AccountManager accountManager;

    private int loginCustomer;

    public CustomerLogic() {
        this.customers = new HashMap<>();
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public Set<Integer> getCustomerIds() {
        return customers.keySet();
    }

    public void setLoginCustomer(int id) {
        this.loginCustomer = id;
    }

    @Override
    public Customer get(Integer id) {
        return customers.get(id);
    }

    @Override
    public List<Customer> list() {

        List<Customer> customerList = new LinkedList<>();

        for (Map.Entry<Integer, Customer> entry: customers.entrySet()) {
            customerList.add(entry.getValue());
        }

        return customerList;
    }

    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {
        return customers.get(id).getAccountIds();
    }

    @Override
    public double getBalance(int customerId) {
        return customers.get(customerId).getBalance();
    }

    @Override
    public void add(Customer customer) {
        customers.put(customer.getId(), customer);
    }
}
