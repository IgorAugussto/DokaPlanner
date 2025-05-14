package com.doka.organizer.entity;

public enum UserRole {

    MASTER("master"),
    ADMIN("admin"),
    USER("user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    //Metodo que vai pegar a Role que esse ENUM representa
    public String getRole(){
        return role;
    }
}
