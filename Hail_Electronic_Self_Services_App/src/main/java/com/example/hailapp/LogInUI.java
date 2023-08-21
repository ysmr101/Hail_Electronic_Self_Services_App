package com.example.hailapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class LogInUI extends AppCompatActivity {

    public static String PREFS_NAME = "MyPrefsFile";
    public static String std_key = "STD";
    public static Student user;
    private EditText userID ,password;

    private Student[] listofStd = new Student[3];
    private FacultyMember[] listofMember = new FacultyMember[2];




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login page");

        CreateLists();


    }


    public void Sign(View v) {



        TextView w = findViewById(R.id.userDoseNotExist);
        TextView p = findViewById(R.id.WrongPassWord);

        userID = findViewById(R.id.userName);
        password = findViewById(R.id.passWord);


        p.setVisibility(View.INVISIBLE);
        w.setVisibility(View.INVISIBLE);


        user = CheckUserID();
        if(user == null) {
            w.setVisibility(View.VISIBLE);
        }else {

            CheckUserPassWord(user , p);
        }





    }
    public Student CheckUserID() {



            for (Student s : listofStd) {

                if (s.getStudentId().equals(userID.getText().toString().trim())) {


                    return s;
                }
            }


        return null;

    }
    public void CheckUserPassWord(Student user , TextView p) {

        if (user.getPassWord().equals(password.getText().toString())) {
            openHomePage(user);

        }
        else p.setVisibility(View.VISIBLE);
    }

    private void openHomePage(Student user) {

        Intent i = new Intent(LogInUI.this, HomePageUI.class);
        i.putExtra(std_key , user);
        startActivity(i);
        finish();

    }
    public void ForgetPassword(View v) {


    }

    private void CreateLists() {

        Major mj = new Major();
        mj.setName("Computer science");

        Subject [] curriculum = new Subject[12];
        //Level 1
        curriculum[0] = new Subject("Discrete Mathematics 1","CS114",3);
        curriculum[1] = new Subject("Introduction to Computer Programming","CS150",4);
        curriculum[2] = new Subject("Applied Calculus 1","MATH101",4);
        curriculum[3] = new Subject("The Holy Qur'an 1","QUR101",1);
        curriculum[4] = new Subject("General Physics","PHY103",3);
        curriculum[5] = new Subject("English 1","ENG140",3);
        //Level 2
        curriculum[6] = new Subject("Object-Oriented Programming","CS151",4);
        curriculum[7] = new Subject("Digital Design","CS125",4);
        curriculum[8] = new Subject("Cyber Security and Ethics","CS180",2);
        curriculum[9] = new Subject("Introduction to Probability & Statistics","STA111",3);
        curriculum[10] = new Subject("Applied Physics","PHY104",3);
        curriculum[11] = new Subject("The Holy Qur'an 2","QUR151",1);




       Section[] sections = new Section[2];



        sections[0] = new Section(curriculum[0],"171","3190" );
        sections[1] = new Section(curriculum[1],"172","3197" );

        FacultyMember[] fms = new FacultyMember[2];
        fms[0] = new FacultyMember("99","Computer Science",null,"4",sections,"Saad","44235790","14071407","salabbad@imamu.edu.sa",35,30000,"0554143177");
        fms[1] = new FacultyMember("89","Information Systems",null,"16:30",null,"Abdulaziz","440012323","17001700","abaziz@imamu.edu.sa",30,20000,"0552343127");
        FacultyMember chairman = fms[0];



        Major cs = new Major("Computer Science",curriculum,fms,chairman);
        AcademicAdvisor milad = new AcademicAdvisor("123",cs,null,"12:00",null,"Milad","23435790","123123","milada@imamu.edu.sa",40,25000,"0552343177");

        Major[] cs2 = new Major[2];

        cs2[0]= new Major("Computer Science",curriculum,fms,chairman);
        cs2[1]= new Major("Computer Science",curriculum,fms,chairman);

        sections[0].addTeacher(fms[0]);
        sections[1].addTeacher(fms[0]);


        listofStd[0] = new Student(4.88,"4",cs,"Yasser","1109270452","1","ycsmr101@gmail.com",21,990,"0554143173",sections );
        listofStd[1] = new Student(4.45,"440016617",cs,"Abdulkarim Ali Alluhaydan","1102472342","ecb","aluhaydan@imamu.edu",21,990,"0507025834",sections);
        listofStd[2] = new Student(4.45,"440032567",cs,"Abdulkarim","1102472342","1234512345","Ahmed1@gmail.com",21,990,"0554233124",sections);


        sections[0].addStudents(listofStd[0].getStudentId());
        sections[0].addStudents(listofStd[1].getStudentId());
        sections[1].addStudents(listofStd[0].getStudentId());
        sections[1].addStudents(listofStd[1].getStudentId());

        sections[0].setTime(new int[]{1 , 3});
        sections[1].setTime(new int[]{4 , 5});
        sections[1].day = new int[]{1 , 3 , 5};
        sections[1].day = new int[]{1 , 4 , 5};

    }
}