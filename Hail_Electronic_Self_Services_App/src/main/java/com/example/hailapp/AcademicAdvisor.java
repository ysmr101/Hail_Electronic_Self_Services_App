
package com.example.hailapp;


import android.os.Parcel;
import android.os.Parcelable;

public class AcademicAdvisor extends FacultyMember implements Std_Adv , Parcelable {
   private boolean request;
    private Major majorCurriculum;
    public AcademicAdvisor( String officeNumber, Major major, String weeklySchedule, String officeHours, Section[] sections, String name, String ID, String passWord, String email, int age, int salary, String  phoneNumber) {
        super(officeNumber, major.getMName(), weeklySchedule, officeHours, sections, name, ID, passWord, email, age, salary, phoneNumber);
        this.request = false;
        majorCurriculum = major;

    }
    public void reviewTheAcademicRecord(){}//student , adivsor

    public Subject curriculumPlan() {
        Subject[] s = majorCurriculum.getCurriculum();
        Subject[][] levels = new Subject[3][6];
        int j = 0;
        int end = levels[0].length;
        for (int i = 0; i < levels.length; i++) {
            for (int c = 0; j < end; j++,c++)
                levels[i][c] = s[j];

            end+= levels[0].length;
        }

        for (int i = 0; i < levels.length; i++) {

            for (int x = 0; x < levels[i].length; x++)
                System.out.print(levels[i][x].getName()+" ");

            System.out.println();
        }
        return null;
    }
    protected AcademicAdvisor(Parcel in) {
        super(in);
        request = in.readByte() != 0;
        majorCurriculum = in.readParcelable(Major.class.getClassLoader());
    }

    public static final Creator<AcademicAdvisor> CREATOR = new Creator<AcademicAdvisor>() {
        @Override
        public AcademicAdvisor createFromParcel(Parcel in) {
            return new AcademicAdvisor(in);
        }

        @Override
        public AcademicAdvisor[] newArray(int size) {
            return new AcademicAdvisor[size];
        }
    };




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte((byte) (request ? 1 : 0));
        parcel.writeParcelable(majorCurriculum, i);

    }
}
