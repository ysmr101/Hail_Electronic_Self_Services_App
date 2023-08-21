
package com.example.hailapp;


import android.os.Parcel;
import android.os.Parcelable;

public class Major implements Parcelable {
    String name;
    private Subject [] curriculum;
    private FacultyMember [] academicStaff;
    private FacultyMember chairman;

    public Major(){}

    public Major(String name, Subject[] curriculum, FacultyMember[] academicStaff,  FacultyMember chairman) {
        this.name = name;
        this.curriculum = curriculum;
        this.academicStaff = academicStaff;
        this.chairman = chairman;
    }

    protected Major(Parcel in) {
        name = in.readString();
        curriculum = in.createTypedArray(Subject.CREATOR);
        academicStaff = in.createTypedArray(FacultyMember.CREATOR);
        chairman = in.readParcelable(FacultyMember.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeTypedArray(curriculum, flags);
        dest.writeTypedArray(academicStaff, flags);
        dest.writeParcelable(chairman, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Major> CREATOR = new Creator<Major>() {
        @Override
        public Major createFromParcel(Parcel in) {
            return new Major(in);
        }

        @Override
        public Major[] newArray(int size) {
            return new Major[size];
        }
    };

    public String getMName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject[] getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Subject[] curriculum) {
        this.curriculum = curriculum;
    }

    public FacultyMember[] getAcademicStaff() {
        return academicStaff;
    }

    public void setAcademicStaff(FacultyMember[] academicStaff) {
        this.academicStaff = academicStaff;
    }



    public FacultyMember getChairman() {
        return chairman;
    }

    public void setChairman(FacultyMember chairman) {
        this.chairman = chairman;
    }

}
