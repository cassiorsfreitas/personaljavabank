package org.academiadecodigo.javabank.application.operations;

import org.academiadecodigo.javabank.application.BankApplicationController;
import org.academiadecodigo.javabank.domain.Customer;

/**
 * A generic bank operation to be used as a base for concrete types of bank operations
 * @see Operation
 */
public abstract class AbstractBankOperation implements Operation {

    protected BankApplicationController bankApplicationController;
    protected Customer customer;

    /**
     * Initializes a new {@code AbstractBankOperation} given a bank application
     *
     * @param bankApplication the bank application
     */
    public AbstractBankOperation(BankApplicationController bankApplication) {
        this.bankApplicationController = bankApplication;
        customer = bankApplication.getBank().getCustomer(bankApplication.getAccessingCustomerId());
    }
}
