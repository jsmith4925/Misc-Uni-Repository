/**
 * 
 * @author 863266
 *
 */
package party;
import java.io.*;
import java.util.Scanner;

/**
 * class to read text file and construct user profiles
 * @author Smith
 */
public class FileReader {
     
	private static Profile constructProfile (String name, int day, int month, int year, String town, String country, String nationality, String[] interests) {
            
            
            Profile newProfile = new Profile(name,day,month,year,town,country,nationality,interests);
            
            
            System.out.println(newProfile.toString());
            
            return newProfile;
        }  
    
	/**
	 * Reads the data file
	 * @param in the scanner of the file
	 * @return 
	 */
	private static BST readDataFile (Scanner in) {
            BSTNode root = null;
            BST newTree = new BST(root);
		
            while (in.hasNext()){

                String profileName = in.next ();

                String name = profileName;
                int day;
                int month;
                int year;
                String town;
                String country;
                String nationality;
                String[] interests = {"dog", "cat"};

                day = in.nextInt();
                month = in.nextInt();
                year = in.nextInt();
                town = in.next();
                country = in.next();
                nationality = in.next();
            //    interests = TODO;                                                           
                constructProfile(name, day, month, year, town, country,nationality, interests);
                break;                                        
                }
             
                return newTree;
        }        
	
        /**
         *
         * @param filename
         * @return
         */
        public static BST readProfiles (String filename) {
                File inputFile = new File (filename);
                Scanner in = null;
                try {
                    in = new Scanner (inputFile);
                }
                catch (FileNotFoundException e) {
                    System.out.println ("Cannot open " + filename);
                    System.exit (0);
                }                  

                return FileReader.readDataFile(in);
        }

   }