package org.academiadecodigo.javabank.application.operations;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;

public class OpenAccount implements Operation {

    @Override
    public void execute(Prompt prompt, AccountManager accountManager, Customer customer) {
        String[] options = {"Checking Account", "Saving Account", "Quit"};
        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage("Which account would you like to create?");
        int optionPicked = prompt.getUserInput(menu);

        switch (optionPicked) {
            case 1:
                customer.openAccount(AccountType.CHECKING);
                System.out.println("Account created!");
                break;
            case 2:
                customer.openAccount(AccountType.SAVINGS);
                System.out.println("Account created!");
                break;
        }

    }
}
