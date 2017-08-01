package com.example.ricardoangulo.api_rest_android;

/**
 * Created by RicardoAngulo on 01/08/2017.
 */

public class ApiRestUsers {
    private String userId;
    private String name;
    private String lastName;
    private String age;

    public ApiRestUsers(){

    }

    public ApiRestUsers(String userId, String name, String lastName, String age){
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String email) {
        this.age = email;
    }
}