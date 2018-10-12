/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package party;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Smith
 */
public class ProfileMain {

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) {
        String name = "James";
        int day = 9;
        int month = 11;
        int year = 1995;
        String town = "Brynmill";
        String country = "Wales";
        String nationality = "English";
        String[] interests = {"Dogs", "Cats", "Your Mum", "Beans"};
    //   List<Profile> friends = new ArrayList<Profile>(Arrays.asList(Dylan, "Kieron", "Harriet"));
        
        Profile James = new Profile(name, day, month, year, town, country, nationality, interests);
     
        System.out.println(James.toString());
        
        
      
        
    }
    
}
