package com.example.javaprojektfx.model;

public class User extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;
    @Entity(type = "VARCHAR", size = 50, isnull = false)
    String name;
    @Entity(type = "VARCHAR", size = 50, isnull = false)
    String lastname;

    /*
        @TODO add unique constraint
    */
    @Entity(type = "CHAR", size = 13, isnull = false)
    String uid;

    /*
        @TODO add ENUM datatype
    */
    @Entity(type = "VARCHAR", size = 30, isnull = false)
    String role;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
