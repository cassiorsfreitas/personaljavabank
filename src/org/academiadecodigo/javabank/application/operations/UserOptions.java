package org.academiadecodigo.javabank.application.operations;

import java.util.ArrayList;
import java.util.List;

public enum UserOptions {
    VIEW_BALANCE(new ViewBalance(), "View Balance"),
    MAKE_DEPOSIT(new MakeDeposit(), "Make Deposit"),
    MAKE_WITHDRAW(new MakeWithdraw(), "Make Withdraw"),
    OPEN_ACCOUNT(new OpenAccount(), "Open Account"),
    QUIT(new Quit(),"Quit");

    private final String message;
    private final Operation operation;

    UserOptions(Operation operation, String message) {
        this.message = message;
        this.operation = operation;
    }

    public static String[] getMessages() {
        List<String> list = new ArrayList<>();

        for (UserOptions options: UserOptions.values()) {
            list.add(options.message);
        }

        String[] messages = new String[list.size()];
        list.toArray(messages);
        return messages;
    }

    public Operation getOperation() {
        return operation;
    }
}
