
package com.example.hailapp;


import android.os.Parcel;
import android.os.Parcelable;

public class FacultyMember extends User implements Employee , Parcelable {
    private String officeNumber;
    private String major;// Major major
    private String weeklySchedule;//Schedule weeklySchedule
    private String officeHours;
    private Section [] sections; 

    
public FacultyMember(){}

    public FacultyMember(String officeNumber, String major, String weeklySchedule, String officeHours, Section[] sections, String name, String ID, String passWord, String email, int age, int salary, String phoneNumber) {
        super(name, ID, passWord, email, age, salary, phoneNumber);
        this.officeNumber = officeNumber;
        this.major = major;
        this.weeklySchedule = weeklySchedule;
        this.officeHours = officeHours;
        this.sections = sections;
    }


    protected FacultyMember(Parcel in) {
        super(in);
        officeNumber = in.readString();
        major = in.readString();
        weeklySchedule = in.readString();
        officeHours = in.readString();
        sections = in.createTypedArray(Section.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(officeNumber);
        dest.writeString(major);
        dest.writeString(weeklySchedule);
        dest.writeString(officeHours);
        //dest.writeTypedArray(sections, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FacultyMember> CREATOR = new Creator<FacultyMember>() {
        @Override
        public FacultyMember createFromParcel(Parcel in) {
            return new FacultyMember(in);
        }

        @Override
        public FacultyMember[] newArray(int size) {
            return new FacultyMember[size];
        }
    };

    public void setGrades(){

        Section s;
        for(int i = 0; i < sections.length; i++) {
            s = sections[i];
            s.setGrades();
        }

    }


    public void attendanceRecording(){
        Section s;
        for(int i = 0; i < sections.length; i++) {
            s = sections[i];
            s.takeAttendance();
        }
    }
    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getWeeklySchedule() {
        return weeklySchedule;
    }

    public void setWeeklySchedule(String weeklySchedule) {
        this.weeklySchedule = weeklySchedule;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public Section[] getSections() {
        return sections;
    }

    public void setSections(Section[] sections) {
        this.sections = sections;
    }



    @Override
    public void profileReview(){
     
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




}
