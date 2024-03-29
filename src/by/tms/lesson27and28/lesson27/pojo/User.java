package by.tms.lesson27and28.lesson27.pojo;

import java.util.Objects;

public class User {

    String name;
    String number;
    Role role;

    public User(String name, String number, Role role) {
        this.name = name;
        this.number = number;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(number, user.number) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, role);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
