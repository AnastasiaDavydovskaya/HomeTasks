package by.tms.lesson32.repositories;

import by.tms.lesson32.entities.Customer;

public interface CustomerControllable extends  Controllable {

    void createCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    String getAddressById(int id);
    String getNameBYId(int id);
}
