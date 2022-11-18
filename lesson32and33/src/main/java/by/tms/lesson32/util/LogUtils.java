package by.tms.lesson32.util;

import by.tms.lesson32.entities.Admin;
import by.tms.lesson32.entities.Customer;
import by.tms.lesson32.repositories.AdminRepository;
import by.tms.lesson32.repositories.CustomerRepository;
import by.tms.lesson32.services.AdminService;
import by.tms.lesson32.services.CustomerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class LogUtils {

    private LogUtils() {};

    public static void getLogsOfAdminRepository(Admin admin1,Admin admin2, Admin admin3, Admin admin4) {
        AdminRepository adminRepository = new AdminRepository();
        adminRepository.init();
        adminRepository.createAdmin(admin1);
        adminRepository.createAdmin(admin2);

        log.info("Third admin {} has unique login={} and unique password={}",
                admin3,
                adminRepository.isUniqueLogin(admin3),
                adminRepository.isUniquePassword(admin3));

        log.info("Fourth admin {} has unique login={} and unique password={}",
                admin4,
                adminRepository.isUniqueLogin(admin4),
                adminRepository.isUniquePassword(admin4));
    }

    public static void getLogsOfCustomerRepository(Customer customer1, Customer customer2) {
        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.init();
        customerRepository.createCustomer(customer1);
        customerRepository.createCustomer(customer2);

        log.info("First customer {} has address={} and name={}",
                customer1,
                customerRepository.getAddressById(0),
                customerRepository.getNameBYId(0));

        log.info("Second customer {} has address={} and name={}",
                customer2,
                customerRepository.getAddressById(1),
                customerRepository.getNameBYId(1));
    }

    public static void getLogsOfAdminService(Admin admin1, Admin admin2, Admin admin3) {
        AdminService adminService = new AdminService();
        adminService.changeLogin(admin1, "newLogin");
        adminService.changePassword(admin2, "newPassword");
        log.info("Admin1 {} change login={}", admin1, admin1.getLogin());
        log.info("Admin2 {} change password={}", admin2, admin2.getPassword());
        log.info("Admin3 {} has unique id={}", admin3,adminService.isUniqueId(Math.toIntExact(admin3.getId())));
    }

    public static void getLogsOfCustomerService(Customer customer1, Customer customer2, Customer customer3) {
        CustomerService customerService = new CustomerService();
        customerService.changeName(customer1, "newName");
        customerService.changeAddress(customer2, "newAddress");
        log.info("Customer1 {} change name={}", customer1, customer1.getName());
        log.info("Customer2 {} change address={}", customer2, customer2.getAddress());
        log.info("Customer3 {} has unique id={}", customer3, customerService.isUniqueId(Math.toIntExact(customer3.getId())));
    }
}
