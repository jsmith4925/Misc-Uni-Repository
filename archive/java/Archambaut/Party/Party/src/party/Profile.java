/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package party;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Smith
 * A Profile is a collection of all data stored on one person.
 * This class defines the values stored
 * 
 */
public class Profile {
    
    /**
    * The name of the user
    */
    private String name;
    
    /**
    * The D.O.B of the user
    */    
    private int day;       
    private int month;
    private int year;
    
    /**
    * The user's Town of Residence
    */
    private String town;
    
    /**
    * The user's Country of Residence
    */
    private String country;
    
    /**
    * The user's Nationality
    */    
    private String nationality;
    
    /**
    * An array of the user's Interests
    */    
    private String[] interests;
    
    /**
    * The name of the user's friends stored in an array
    */
    List<Profile> friends = new ArrayList<Profile>();
    
    /**
    * Creates a Users profile.
    * @param name The name of the user.
    * @param day The day for DoB.
    * @param month The month for DoB.
    * @param year The year for DoB.
     * @param town The Town of the user
     * @param country the country of the user
     * @param nationality the nationality of the user
     * @param interests interests of the user stored as an array
    */
    protected Profile (String name, int day, int month, int year, String town, String country, String nationality, String[] interests) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
            this.town = town;
            this.country = country;
            this.nationality = nationality;
            this.interests = interests;
          //  this.friends = friends;
            
            
	}
    
    /**
     * 
     * @return name of the profile
     */
    public String getName () {
        return name;    
    }
    
    /**
     *
     * @return date as string
     */
    public String getDob () {
        return  Integer.toString(day) + "/" +  Integer.toString(month) +"/"+  Integer.toString(year);
    }
    
    /**
     *
     * @return town name
     */
    public String getTown () {
        return town;
    }
    
    /**
     *
     * @param town town name
     */
    public void setTown (String town) {
        this.town = town;
    }
    
    /**
     *
     * @return country
     */
    public String getCountry () {
        return country;
    }
    
    /**
     *
     * @param country country
     */
    public void setCountry (String country) {
        this.country = country;
    }    
    
    /**
     *
     * @return nationality
     */
    public String getNationality () {
        return nationality;
    }
    
    /**
     *
     * @param town
     */
    public void setNationality (String town) {
        this.nationality = nationality;
    }    
    
    /**
     *
     * @return
     */
    public String[] getInterests () {
        return interests;
    }
    
    /**
     *
     * @param interests
     */
    public void setInterests (String[] interests) {
        this.interests = interests;
    }
    
    /**
     *
     * @param p profile to be added to user
     */
    public void addfFriend (Profile p){
        friends.add(p);
        System.out.println("Friend " + p.getName() + " added");
    }
    
    /**
     *
     * @param i
     * @return
     */
    public Profile getFriend (int i){
        Profile result = friends.get(i);
        System.out.println("Friend "+ i + ": " + result.getName());
        return result;
    }
    
    /**
     *
     * @return
     */
    public int numOfFriends (){
        int friendCount = friends.size();
        return friendCount;
    }
    
    @Override
    public String toString(){
        String profileData = "";
        profileData += "Name: " + name + "\n";
        profileData += "DoB: " + getDob() + "\n";
        profileData += "Town: " + town + "\n";        
        profileData += "Country: " + country + "\n";
        profileData += "Nationality: " + nationality + "\n";
        profileData += "Interests: " + Arrays.toString(interests) + "\n";
        profileData += "Friends: " + Arrays.toString(friends.toArray()) + "\n";
        
        return profileData;
    }
 
}
