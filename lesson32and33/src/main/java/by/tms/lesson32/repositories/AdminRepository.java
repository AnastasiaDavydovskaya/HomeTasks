package by.tms.lesson32.repositories;

import by.tms.lesson32.entities.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminRepository implements AdminControllable {

    public static List<Admin> admins;

    @Override
    public boolean isUniqueLogin(Admin admin) {
        for(Admin ad: admins) {
            if(admin.getLogin().equals(ad.getLogin())) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean isUniquePassword(Admin admin) {
        for(Admin ad: admins) {
            if(admin.getPassword().equals(ad.getPassword())) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void init() {
        admins = new ArrayList<>();
    }

    @Override
    public void createAdmin(Admin admin) {
        admins.add(admin);
    }

    @Override
    public void deleteAdmin(Admin admin) {
        admins.remove(admin);
    }

}
