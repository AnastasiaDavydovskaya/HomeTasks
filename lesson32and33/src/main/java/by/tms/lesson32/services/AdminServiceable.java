package by.tms.lesson32.services;

import by.tms.lesson32.entities.Admin;

public interface AdminServiceable extends Serviceable {

    void changeLogin(Admin admin, String login);
    void changePassword(Admin admin, String password);
}
