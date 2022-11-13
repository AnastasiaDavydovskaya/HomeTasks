package by.tms.lesson34.entities;

public enum Role {

    ADMIN("ADMIN"),
    CUSTOMER("CUSTOMER");

    private String role;

    Role(String role) {
        this.role = role;
    }
}
