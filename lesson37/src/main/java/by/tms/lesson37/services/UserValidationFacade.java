package by.tms.lesson37.services;

import by.tms.lesson37.entities.Role;

public class UserValidationFacade {

    private UserService userService;
    private ValidationService validationService;

    public UserValidationFacade(UserService userService, ValidationService validationService) {
        this.userService = userService;
        this.validationService = validationService;
    }

    public boolean addUserByAdmin(String email, String password) {
        Role role = validationService.validateUser(email, password);

        if(role.equals(Role.ADMIN)) {
            userService.addNewUser(email, password);
            return true;
        }

        return false;
    }

}
