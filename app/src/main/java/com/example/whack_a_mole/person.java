package com.example.whack_a_mole;


public class person implements Comparable<person>{

    String name;
    int age,picture_number;

    public person(String name, int age, int picture_number) {
        this.name = name;
        this.age = age;
        this.picture_number = picture_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPicture_number() {
        return picture_number;
    }

    public void setPicture_number(int picture_number) {
        this.picture_number = picture_number;
    }

    @Override
    public int compareTo(person person) {
        return this.name.compareTo(person.name);
    }
}
