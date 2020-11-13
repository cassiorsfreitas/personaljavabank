package org.academiadecodigo.javabank.application;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.domain.Bank;

public class BankApplicationView {

    private final Prompt prompt;
    private MenuInputScanner mainMenu;
    private final BankApplicationController bankApplicationController;

    public BankApplicationView(Bank bank) {
        this.prompt = new Prompt(System.in, System.out);
        bankApplicationController = new BankApplicationController(bank, this);
    }

    public Prompt getPrompt() {
        return prompt;
    }

    public void start() {
        mainMenu = buildMainMenu();
        bankApplicationController.setAccessingCustomerId(scanCustomerId());
        bankApplicationController.setOperationsMap(bankApplicationController.buildOperationsMap());
        bankApplicationController.menuLoop(mainMenu);
    }

    private MenuInputScanner buildMainMenu() {

        MenuInputScanner mainMenu = new MenuInputScanner(UserOptions.getMessages());
        mainMenu.setError(Messages.ERROR_INVALID_OPTION);
        mainMenu.setMessage(Messages.MENU_WELCOME);

        return mainMenu;
    }

    private int scanCustomerId() {

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(bankApplicationController.getBank().getCustomerIds());
        scanner.setMessage(Messages.CHOOSE_CUSTOMER);
        scanner.setError(Messages.ERROR_INVALID_CUSTOMER);

        return prompt.getUserInput(scanner);
    }
}
