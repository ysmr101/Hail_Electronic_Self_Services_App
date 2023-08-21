
package com.example.hailapp;


public class College {
    private FacultyMember dean;
    private Major[] majors;
    private String contactEmail;
    
    public College(){}
    public College(FacultyMember dean, Major[] majors, String contactEmail) {
        this.dean = dean;
        this.majors = majors;
        this.contactEmail = contactEmail;
    }
    public void contactCollege(){
        
    }
    
    
}
