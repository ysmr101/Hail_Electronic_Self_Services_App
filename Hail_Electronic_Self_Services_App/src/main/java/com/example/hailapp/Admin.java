
package com.example.hailapp;


import android.os.Parcel;
import android.os.Parcelable;

public class Admin extends User implements Employee , Parcelable {
private boolean request;
    
    public Admin(){}
    
    public Admin(boolean request) {
        this.request = request;
    }

    public Admin(boolean request, String name, String ID, String passWord, String email, int age, int salary, String phoneNumber) {
        super(name, ID, passWord, email, age, salary, phoneNumber);
        this.request = request;
    }


    protected Admin(Parcel in) {
        super(in);
        request = in.readByte() != 0;
    }

    public static final Creator<Admin> CREATOR = new Creator<Admin>() {
        @Override
        public Admin createFromParcel(Parcel in) {
            return new Admin(in);
        }

        @Override
        public Admin[] newArray(int size) {
            return new Admin[size];
        }
    };

    @Override
    public void profileReview() {
      
    }

    @Override
    public void electronicReminder() {
        
    }

    @Override
    public int vacationBalance() {
       return 0; 
    }

    @Override
    public int viewSalary() {
       return 0;  
    }

    @Override
    public String SIC() {
        return null; 
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (request ? 1 : 0));
        parcel.writeByte((byte) (request ? 1 : 0));
    }
}
