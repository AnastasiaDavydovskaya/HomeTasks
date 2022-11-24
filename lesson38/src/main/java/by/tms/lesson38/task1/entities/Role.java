package by.tms.lesson38.task1.entities;

public enum Role {

    ADMIN("ADMIN"),
    CUSTOMER("CUSTOMER"),
    UNDEFINED("UNDEFINED");

    private String role;

    Role(String role) {
        this.role = role;
    }
}
