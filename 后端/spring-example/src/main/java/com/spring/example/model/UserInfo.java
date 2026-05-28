package com.spring.example.model;

public class UserInfo {
    private String username;
    private Integer gender;
    private Integer age;

    public UserInfo (String username, Integer gender, Integer age) {
        this.username = username;
        this.gender = gender;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
