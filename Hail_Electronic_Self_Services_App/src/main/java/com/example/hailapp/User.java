package com.example.hailapp;


import android.os.Parcel;
import android.os.Parcelable;

public abstract class User implements EIS , Parcelable {

     String name;
     String ID;
     String passWord;
     String email;
     int age;
     int salary;
     String phoneNumber;
    public User(){this.ID = "Unknown";}

    public User(String name, String ID, String passWord, String email, int age, int salary, String phoneNumber) {
        this.name = name;
        this.ID = ID;
        this.passWord = passWord;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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
    
     public String getID() {
        return ID;
    }

    protected User(Parcel in) {
        this.name =in.readString();
        this.ID = in.readString();
        this.passWord = in.readString();
        this.email = in.readString();
        this.age = in.readInt();
        this.salary =  in.readInt();
        this.phoneNumber = in.readString();

    }
    public void writeToParcel(Parcel dest, int flags){
       dest.writeString(name);
       dest.writeString(ID);
       dest.writeString(passWord);
       dest.writeString(email);
       dest.writeInt(age);
       dest.writeInt(salary);
       dest.writeString(phoneNumber);


    }
}
