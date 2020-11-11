package org.academiadecodigo.javabank.application.operations;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;

public class MakeDeposit implements Operation{

    @Override
    public void execute(Prompt prompt, AccountManager accountManager, Customer customer) {

        IntegerInputScanner id = new IntegerInputScanner();
        id.setMessage("Choose ID account: ");
        int accountId = prompt.getUserInput(id);

        double balance = customer.getBalance(accountId);
        System.out.println("Balance: " + balance);
    }
}
