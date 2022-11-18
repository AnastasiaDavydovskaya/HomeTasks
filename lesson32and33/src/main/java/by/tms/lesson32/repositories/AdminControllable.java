package by.tms.lesson32.repositories;

import by.tms.lesson32.entities.Admin;

public interface AdminControllable extends Controllable {

    void createAdmin(Admin admin);
    void deleteAdmin(Admin admin);
    boolean isUniqueLogin(Admin admin);
    boolean isUniquePassword(Admin admin);
}
