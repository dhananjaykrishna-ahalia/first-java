package com.example.entity;


public class Users {
    private int userid;
    private String role;
    private String description;

    public Users(int userid, String role, String description) {
        this.userid = userid;
        this.role = role;
        this.description = description;
    }

    public Users() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "users{" +
                "userid=" + userid +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
