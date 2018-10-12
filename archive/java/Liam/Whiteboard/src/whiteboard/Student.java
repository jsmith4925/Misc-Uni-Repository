/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whiteboard;

import java.util.Arrays;

/**
 *
 * @author Smith
 */
public class Student {
    
    private int studentId;
    private String firstName;
    private String lastName;   
    private String[] moduleCode;
    private String[] grade;
    
            
    protected Student (int studentId, String firstName, String lastName, String[] moduleCode, String[] grade) {
            this.studentId = studentId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.moduleCode = moduleCode;
            this.grade = grade;
    }
    
    public int getStudentId() {
        return studentId;    
    }
    public String getFirstName() {
        return firstName;    
    }
    
    public String getLastName() {
        return lastName;    
    }
    public String[] getModuleCode() {
        return moduleCode;
    }
    public String[] getGrade() {
        return grade;
    }
    
     public String toString(){
        String profileData = "";
        profileData += "ID: " + studentId + "\n";
        profileData += "First name: " + firstName + "\n";
        profileData += "Last name: " + lastName + "\n";
        profileData += "Enrolled Modules:   " + Arrays.toString(moduleCode) + "\n"; 
        profileData += "Overall Grades:     " + Arrays.toString(grade) + "\n";
        
        return profileData;
    }
    
    
}
