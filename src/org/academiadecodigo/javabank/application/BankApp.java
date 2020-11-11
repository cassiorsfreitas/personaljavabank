package org.academiadecodigo.javabank.application;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class BankApp {

    public void start() {

        System.out.println("Welcome to the Java Bank");
        Menu menu = new Menu ();
        menu.show();

    }
}
