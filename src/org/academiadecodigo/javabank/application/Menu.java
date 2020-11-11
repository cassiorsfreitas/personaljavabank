package org.academiadecodigo.javabank.application;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.application.operations.UserOptions;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    private final Prompt prompt;
    private final Map<Integer, Operation> operations = new HashMap<>();
    private final Customer customer;
    private final AccountManager accountManager;

    public Menu(Prompt prompt, Customer customer, AccountManager accountManager) {
        this.prompt = prompt;
        this.customer = customer;
        this.accountManager = accountManager;
        initMenu();
    }

    private void initMenu() {

        for (UserOptions option : UserOptions.values()) {
            operations.put((option.ordinal() + 1), option.getOperation());
        }
    }

    public void showMenu() {

        while (true) {
            String[] options = UserOptions.getMessages();

            MenuInputScanner menu = new MenuInputScanner(options);
            menu.setMessage("Insert a number:");
            int optionPicked;

            while (!customer.hasAccount()) {
                System.out.println("You have no accounts. Open an account first.");
                optionPicked = prompt.getUserInput(menu);

                if (optionPicked == 4) {
                    executeOption(optionPicked);
                }
            }

            optionPicked = prompt.getUserInput(menu);
            executeOption(optionPicked);

        }
    }

    public void executeOption(int optionPicked) {
        Operation operation = operations.get(optionPicked);
        operation.execute(prompt, accountManager, customer);
    }
}
