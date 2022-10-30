package by.tms.lesson32.services;

import by.tms.lesson32.entities.Admin;
import by.tms.lesson32.repositories.AdminRepository;

public class AdminService implements AdminServiceable {

    @Override
    public void changeLogin(Admin admin, String login) {
        admin.setLogin(login);
    }

    @Override
    public void changePassword(Admin admin, String password) {
        admin.setPassword(password);
    }

    @Override
    public boolean isUniqueId(int id) {
        for(Admin admin: AdminRepository.admins) {
            if(admin.getId() == id) {
                return false;
            }
        }
        return true;
    }
}
