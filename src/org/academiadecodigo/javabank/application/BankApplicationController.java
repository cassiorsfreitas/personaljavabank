package org.academiadecodigo.javabank.application;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.application.operations.BalanceOperation;
import org.academiadecodigo.javabank.application.operations.NewAccountOperation;
import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.application.operations.transaction.DepositOperation;
import org.academiadecodigo.javabank.application.operations.transaction.WithdrawOperation;
import org.academiadecodigo.javabank.domain.Bank;

import java.util.HashMap;
import java.util.Map;

public class BankApplicationController {

    private final Bank bank;
    private int accessingCustomerId;
    private Map<Integer, Operation> operationsMap;
    private final BankApplicationView bankApplicationView;

    public BankApplicationController(Bank bank, BankApplicationView bankApplicationView) {
        this.bank = bank;
        this.bankApplicationView = bankApplicationView;
    }

    public Bank getBank() {
        return bank;
    }

    public int getAccessingCustomerId() {
        return accessingCustomerId;
    }

    public Map<Integer, Operation> buildOperationsMap() {

        Map<Integer, Operation> map = new HashMap<>();
        map.put(UserOptions.GET_BALANCE.getOption(), new BalanceOperation(this));
        map.put(UserOptions.DEPOSIT.getOption(), new DepositOperation(this));
        map.put(UserOptions.WITHDRAW.getOption(), new WithdrawOperation(this));
        map.put(UserOptions.OPEN_ACCOUNT.getOption(), new NewAccountOperation(this));

        return map;
    }

    public void setOperationsMap(Map<Integer, Operation> operationsMap) {
        this.operationsMap = operationsMap;
    }

    public void menuLoop(MenuInputScanner mainMenu) {

        int userChoice = bankApplicationView.getPrompt().getUserInput(mainMenu);

        if (userChoice == UserOptions.QUIT.getOption()) {
            return;
        }

        operationsMap.get(userChoice).execute();
        menuLoop(mainMenu);
    }

    public Prompt getPrompt() {
        return bankApplicationView.getPrompt();
    }

    public void setAccessingCustomerId(int accessingCustomerId) {
        this.accessingCustomerId = accessingCustomerId;
    }
}
