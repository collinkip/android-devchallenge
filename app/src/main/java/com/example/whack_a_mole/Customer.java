package com.example.whack_a_mole;

public class Customer {
    private String name,email;
    private int age,id;
    boolean isActive;

    public Customer(int id,String name, String email, int age,boolean isActive) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.id=id;
        this.isActive=isActive;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", isActive=" + isActive +
                '}';
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
