package by.tms.lesson32.repositories;

import by.tms.lesson32.entities.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements CustomerControllable {

    public static List<Customer> customers;

    @Override
    public void init() {
        customers = new ArrayList<>();
    }

    @Override
    public void createCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customers.remove(customer);
    }

    @Override
    public String getAddressById(int id) {
        return customers.get(id).getAddress();
    }

    @Override
    public String getNameBYId(int id) {
        return customers.get(id).getName();
    }
}
