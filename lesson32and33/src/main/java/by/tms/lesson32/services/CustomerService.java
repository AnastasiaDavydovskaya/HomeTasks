package by.tms.lesson32.services;

import by.tms.lesson32.entities.Customer;
import by.tms.lesson32.repositories.CustomerRepository;

public class CustomerService implements CustomerServiceable{

    @Override
    public void changeName(Customer customer, String name) {
        customer.setName(name);
    }

    @Override
    public void changeAddress(Customer customer, String address) {
        customer.setAddress(address);
    }

    @Override
    public boolean isUniqueId(int id) {
        for(Customer customer: CustomerRepository.customers) {
            if(customer.getId() == id) {
                return false;
            }
        }

        return true;
    }
}
