package by.tms.lesson32;

import by.tms.lesson32.entities.Admin;
import by.tms.lesson32.entities.Customer;
import by.tms.lesson32.util.LogUtils;

public class Main {

    public static void main(String[] args) {
        Admin admin1 = new Admin(0L, 30,"admin1", "admin11");
        Admin admin2 = new Admin(1L, 27, "admin2", "admin22");
        Admin admin3 = new Admin(2L, 34, "admin3", "admin33");
        Admin admin4 = new Admin(3L, 87, "admin4", "admin44");

        Customer customer1 = new Customer(0L, 5, "Nastya", "Lenin");
        Customer customer2 = new Customer(1L, 7, "Olga", "Kolban");
        Customer customer3 = new Customer(1L, 7, "Olga", "Kolban");

        LogUtils.getLogsOfAdminRepository(admin1, admin2, admin3, admin4);
        LogUtils.getLogsOfCustomerRepository(customer1, customer2);
        LogUtils.getLogsOfAdminService(admin1, admin2, admin3);
        LogUtils.getLogsOfCustomerService(customer1, customer2, customer3);
    }
}
