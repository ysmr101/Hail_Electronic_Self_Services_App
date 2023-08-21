package com.example.hailapp;


import android.os.Parcel;
import android.os.Parcelable;

public class Date implements Parcelable {
   private int day;
   private int month;
   private int year;

    public Date(int day, int month, int year) {
        if(day>31||day<1||month>12||month<1){
            System.out.println("Date is incorrect.");
            System.exit(0);
        }
            
        this.day = day;
        this.month = month;
        this.year = year;
    }

    protected Date(Parcel in) {
        day = in.readInt();
        month = in.readInt();
        year = in.readInt();
    }

    public static final Creator<Date> CREATOR = new Creator<Date>() {
        @Override
        public Date createFromParcel(Parcel in) {
            return new Date(in);
        }

        @Override
        public Date[] newArray(int size) {
            return new Date[size];
        }
    };

    @Override
   public String toString(){
       return day+"/"+month+"/"+year;
   }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(day);
        parcel.writeInt(month);
        parcel.writeInt(year);
    }
}
