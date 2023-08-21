package com.example.hailapp;


import android.os.Parcel;
import android.os.Parcelable;

public class Student extends User implements Std_Adv , Parcelable {
      private double GPA;
      private String studentId;
      private Major major;

      private Section[] subjects;



    public Student(){}
    public Student(double GPA, String studentId, Major major, String name, String ID, String passWord, String email, int age, int salary, String phoneNumber,Section[] subjects ) {
        super(name, ID, passWord, email, age, salary, phoneNumber);
        this.GPA = GPA;
        this.studentId = studentId;
        this.major = major;
        this.subjects = subjects ;

    }
    public Section[] getSubjects(){


       return subjects;
    }
    public Subject[][] CPlan() {

        Subject[] s = major.getCurriculum();
        Subject[][] levels = new Subject[2][6];
        int j = 0;
        int end = levels[0].length;
        for (int i = 0; i < levels.length; i++) {
            for (int c = 0; j < end; j++,c++)
                levels[i][c] = s[j];

            end+= levels[0].length;
        }


        return levels;
    }


    protected Student(Parcel in) {
        super(in);
        GPA = in.readDouble();
        studentId = in.readString();
        major = in.readParcelable(Major.class.getClassLoader());
        int size = in.readInt();
        subjects= new Section[size];
        in.readTypedArray(subjects ,Section.CREATOR);

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeDouble(GPA);
        dest.writeString(studentId);
        dest.writeParcelable(major, flags);
        dest.writeTypedArray(subjects, flags);

    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public void setSubjects(Section[] subjects) {
        this.subjects = subjects;
    }

    public void reviewGrades(){
        for (int i = 0; i < subjects.length; i++)
            subjects[i].viewGrade(studentId);


    }
    public double academicGPA_Review(){return 0;}
    public Schedule reviewSchedule(){return null;}

    @Override
    public void profileReview() {
       
    }

    @Override
    public void electronicReminder() {
    }

    
      @Override
    public void reviewTheAcademicRecord() {
    }

   
      @Override
    public Subject curriculumPlan() {
        return null;
    }

    @Override
    public int describeContents() {
        return 0;
    }



}
