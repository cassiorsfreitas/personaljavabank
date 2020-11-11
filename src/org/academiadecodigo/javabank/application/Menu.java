package org.academiadecodigo.javabank.application;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class Menu {

    public void show() {

        Prompt prompt = new Prompt(System.in, System.out);

        String[] options = {"View Balance", "Make Deposit", "Make Withdraw", "Open Account", "Quit"};
        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage("Welcome! Insert a number:");

        int optionPicked = prompt.getUserInput(menu);

        System.out.println(optionPicked);
    }
}
