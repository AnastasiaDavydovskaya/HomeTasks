import by.tms.lesson32.entities.Admin;
import by.tms.lesson32.repositories.AdminRepository;
import by.tms.lesson32.services.AdminService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAdminService {

    private static AdminService adminService;
    private static Admin admin;

    @BeforeAll
    private static void init() {
        adminService = new AdminService();
        admin = new Admin(0L, 34, "login", "password");
    }

    @ParameterizedTest
    @MethodSource("testChangeLoginParams")
    public void testChangeLogin(Admin admin, String login) {
        String login1 = admin.getLogin();
        adminService.changeLogin(admin, login);
        String login2 = admin.getLogin();

        assertTrue(!login1.equals(login2));
    }

    static Stream<Arguments> testChangeLoginParams() {
        return Stream.of(
                Arguments.of(admin, "newLogin1"),
                Arguments.of(admin, "newLogin2"),
                Arguments.of(admin, "newLogin3")
        );
    }

    @ParameterizedTest
    @MethodSource("testChangePasswordParams")
    public void testChangePassword(Admin admin, String password) {
        String password1 = admin.getPassword();
        adminService.changePassword(admin, password);
        String password2 = admin.getPassword();

        assertTrue(!password1.equals(password2));
    }

    static Stream<Arguments> testChangePasswordParams() {
        return Stream.of(
                Arguments.of(admin, "newPassword1"),
                Arguments.of(admin, "newPassword2"),
                Arguments.of(admin, "newPassword3")
        );
    }

    @ParameterizedTest
    @MethodSource("testIsUniqueIdParams")
    public void testIsUniqueId(int id) {
        AdminRepository adminRepository = new AdminRepository();
        adminRepository.init();
        adminRepository.createAdmin(admin);
        adminRepository.createAdmin(new Admin(1L, 2, "l", "p"));
        boolean actual = adminService.isUniqueId(id);

        assertTrue(actual);
    }

    static Stream<Arguments> testIsUniqueIdParams() {
        return Stream.of(
                Arguments.of(2),
                Arguments.of(3)
        );
    }
}
