package by.tms.lesson25and26.jspandservlets;

import java.util.Objects;

public class User {

    private String name;
    private String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(number, user.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
