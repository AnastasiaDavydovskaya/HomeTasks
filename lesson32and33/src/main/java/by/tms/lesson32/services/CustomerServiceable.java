package by.tms.lesson32.services;

import by.tms.lesson32.entities.Customer;

public interface CustomerServiceable extends Serviceable {

    void changeName(Customer customer, String name);
    void changeAddress(Customer customer, String address);
}
