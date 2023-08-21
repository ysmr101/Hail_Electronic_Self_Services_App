
package com.example.hailapp;


import android.os.Parcel;
import android.os.Parcelable;

public class Subject implements Parcelable {
    private String name;
    private String subjectCode;
    private int creditHours;
    private Date date;
    
    public Subject(){}

    public Subject(String name, String subjectCode, int creditHours) {
        this.name = name;
        this.subjectCode = subjectCode;
        this.creditHours = creditHours;

    }

    protected Subject(Parcel in) {
        name = in.readString();
        subjectCode = in.readString();
        creditHours = in.readInt();
        date = in.readParcelable(Date.class.getClassLoader());

    }

    public static final Creator<Subject> CREATOR = new Creator<Subject>() {
        @Override
        public Subject createFromParcel(Parcel in) {
            return new Subject(in);
        }

        @Override
        public Subject[] newArray(int size) {
            return new Subject[size];
        }
    };



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int criditHours) {
        this.creditHours = criditHours;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(subjectCode);
        parcel.writeInt(creditHours);
        parcel.writeParcelable(date , i);

    }
}
