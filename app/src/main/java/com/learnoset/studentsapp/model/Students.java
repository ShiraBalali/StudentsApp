package com.learnoset.studentsapp.model;

public class Students {
    public String name;
    public String id;
    public String avatarUrl;
    public Boolean cb;

    public String phone;
    public String address;

    public Students(String name, String id, String avatarUrl, Boolean cb, String phone, String address) {
        this.name = name;
        this.id = id;
        this.avatarUrl = avatarUrl;
        this.cb = cb;
        this.phone = phone;
        this.address = address;
    }
}
