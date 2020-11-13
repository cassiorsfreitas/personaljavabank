package org.academiadecodigo.javabank.service.interfaces;

import org.academiadecodigo.javabank.model.Customer;

public interface AuthService {

    boolean authenticate(Integer id);
    Customer getAccessingCustomer();

}
