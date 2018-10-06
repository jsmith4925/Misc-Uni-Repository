/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whiteboard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author Smith
 */
public class Whiteboard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int studentId = 863266;
        String firstName = "James";
        String lastName = "Smith";
        String[] moduleCode = {"CS-230", "CS-205", "CS-270", "CS-250"};
        String[] grade = {"First","2:1","2:1","2:2"};
        
        Student James = new Student(studentId, firstName, lastName, moduleCode, grade);
     
        System.out.println(James.toString());
    }
    
}
