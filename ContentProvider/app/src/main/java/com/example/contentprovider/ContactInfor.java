package com.example.contentprovider;

import java.io.Serializable;
import java.io.StringReader;

public class ContactInfor implements Serializable {
    private String name;
    private String Phone;
    public ContactInfor(String name, String Phone) {
        this.name = name;
        this.Phone = Phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return "ContactInfor{" +
                "name='" + name + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }
}
