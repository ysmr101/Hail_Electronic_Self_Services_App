
package com.example.hailapp;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Scanner;

public class Section implements Parcelable {
    public static Scanner input = new Scanner(System.in);
    private FacultyMember teacher;
    private Subject subject;
    private String[] students;
    public int[] time;
    public int day[];
    private int[] studentsGrades;
    private int[] studentsattendace;
    private int studentsCounter = 0;
    private String sectionNumber;
    private String classRoom;
    private int prohibtionLimit;
    private String[] finalGrade;
    
    public Section(){}

    public Section(Subject subject, String sectionNumber, String classRoom) {

        this.students = new String[20];
        this.subject = subject;
        this.sectionNumber = sectionNumber;
        this.classRoom = classRoom;
        prohibtionLimit = subject.getCreditHours()*3;
    }


    protected Section(Parcel in) {
        teacher = in.readParcelable(FacultyMember.class.getClassLoader());
        subject = in.readParcelable(Subject.class.getClassLoader());
        students = in.createStringArray();
        studentsGrades = in.createIntArray();
        studentsattendace = in.createIntArray();
        studentsCounter = in.readInt();
        sectionNumber = in.readString();
        classRoom = in.readString();
        prohibtionLimit = in.readInt();
        finalGrade = in.createStringArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(teacher, flags);
        dest.writeParcelable(subject, flags);
        dest.writeStringArray(students);
        dest.writeIntArray(studentsGrades);
        dest.writeIntArray(studentsattendace);
        dest.writeInt(studentsCounter);
        dest.writeString(sectionNumber);
        dest.writeString(classRoom);
        dest.writeInt(prohibtionLimit);
        dest.writeStringArray(finalGrade);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Section> CREATOR = new Creator<Section>() {
        @Override
        public Section createFromParcel(Parcel in) {
            return new Section(in);
        }

        @Override
        public Section[] newArray(int size) {
            return new Section[size];
        }
    };

    public void addStudents(String id){
        if(studentsCounter>=students.length)
        {}
        else { students[studentsCounter] = id;
            studentsCounter++;
        }


    }
    public void addTeacher(FacultyMember teacher){
        this.teacher = teacher;
    }
    public void calculateFinalGrades(){
        for(int i = 0; i <studentsCounter ; i++) {
            if(studentsGrades[i]>101 || studentsGrades[i]<0)

                finalGrade[i]="err";

            else{


                if(studentsGrades[i]>94)
                    finalGrade[i] = "A+";
                else
                if(studentsGrades[i]>89)
                    finalGrade[i] = "A";
                else
                if(studentsGrades[i]>84)
                    finalGrade[i] = "B+";
                else
                if(studentsGrades[i]>79)
                    finalGrade[i] = "B";
                else
                if(studentsGrades[i]>74)
                    finalGrade[i] = "C+";
                else
                if(studentsGrades[i]>69)
                    finalGrade[i] = "C";
                else
                if(studentsGrades[i]>64)
                    finalGrade[i] = "D+";
                else
                if(studentsGrades[i]>59)
                    finalGrade[i] = "D";
                else
                    finalGrade[i] = "F";}

        }

    }


    public String viewGrade(String id){

        setGrades();
        for (int i = 0; i < students.length; i++) {
            if(students[i].equals(id)){

                return finalGrade[i];
            }
        }
        return "ned";
    }
    public void setGrades(){

        finalGrade = new String[students.length];
        studentsGrades = new int [studentsCounter];//System.out.println(studentsCounter);

        for (int i = 0; i <studentsCounter ; i++) {

            studentsGrades[i] = 90+i;


        }calculateFinalGrades();
    }
    public void takeAttendance(){
        studentsattendace = new int [studentsCounter];//System.out.println(studentsCounter);
        for (int i = 0; i <studentsCounter ; i++) {
            System.out.println(students[i]+", "+subject.getName()+", attendance:");
            studentsattendace[i] += input.nextInt();

        }
    }

    public FacultyMember getTeacher() {
        return teacher;
    }

    public void setTeacher(FacultyMember teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public int[] getTime() {
        return time;
    }

    public void setTime(int[] time) {
        this.time = time;
    }
}
