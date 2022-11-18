import by.tms.lesson32.entities.Customer;
import by.tms.lesson32.repositories.CustomerRepository;
import by.tms.lesson32.services.CustomerService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCustomerService {

    private static CustomerService customerService;
    private static Customer customer;

    @BeforeAll
    private static void init() {
        customerService = new CustomerService();
        customer = new Customer(0L, 34, "login", "password");
    }

    @ParameterizedTest
    @MethodSource("testChangeNameParams")
    public void testChangeName(Customer customer, String name) {
        String name1 = customer.getName();
        customerService.changeName(customer, name);
        String name2 = customer.getName();

        assertTrue(!name1.equals(name2));
    }

    static Stream<Arguments> testChangeNameParams() {
        return Stream.of(
                Arguments.of(customer, "newName1"),
                Arguments.of(customer, "newName2"),
                Arguments.of(customer, "newName3")
        );
    }

    @ParameterizedTest
    @MethodSource("testChangeAddressParams")
    public void testChangeAddress(Customer customer, String address) {
        String name1 = customer.getAddress();
        customerService.changeAddress(customer, address);
        String name2 = customer.getAddress();

        assertTrue(!name1.equals(name2));
    }

    static Stream<Arguments> testChangeAddressParams() {
        return Stream.of(
                Arguments.of(customer, "newAddress1"),
                Arguments.of(customer, "newAddress2"),
                Arguments.of(customer, "newAddress3")
        );
    }

    @ParameterizedTest
    @MethodSource("testIsUniqueIdParams")
    public void testIsUniqueId(int id) {
        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.init();
        customerRepository.createCustomer(customer);
        customerRepository.createCustomer(new Customer(1L, 2, "l", "p"));
        boolean actual = customerService.isUniqueId(id);

        assertTrue(actual);
    }

     static Stream<Arguments> testIsUniqueIdParams() {
        return Stream.of(
                Arguments.of(2),
                Arguments.of(3)
        );
    }
}
