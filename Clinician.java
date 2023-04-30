package io.validitron.telesimclient.models;

import org.json.JSONObject;

public class Clinician implements UserInterface{

    private String uid;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;

    public Clinician() {
    }

    public Clinician(String uid, String firstName, String lastName, int age, String gender) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String search() {
        return null;
    }

    @Override
    public String update() {
        return null;
    }

    @Override
    public String delete() {
        return null;
    }

    @Override
    public String add() {
        return null;
    }

    @Override
    public JSONObject getJSON() {
        return null;
    }
}
