
package com.example.hailapp;


public class Visitor {
    private String name;
    private String phoneNumber;
    private String email;
    private Admin administartion;
    
    public Visitor(){}
    
    public Visitor(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Admin getAdministartion() {
        return administartion;
    }

    public void setAdministartion(Admin administartion) {
        this.administartion = administartion;
    }
    
    
    public void administrativeCommunications(){
    }
}