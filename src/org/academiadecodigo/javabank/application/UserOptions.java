package org.academiadecodigo.javabank.application;

public enum UserOptions {
    VIEW_BALANCE("View Balance"),
    MAKE_DEPOSIT("Make Deposit"),
    MAKE_WITHDRAW("Make Withdraw"),
    OPENA_ACCOUNT("Open Account"),
    QUIT("Quit");

    private final String nameOption;

    UserOptions(String nameOption) {
        this.nameOption = nameOption;
    }

    public String getNameOption() {
        return nameOption;
    }
}
