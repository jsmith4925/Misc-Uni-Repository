/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package party;

/**
 *
 * @author Smith
 */
public class BSTMain {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        String[] interests = {"Dogs", "Cats", "Your Mum", "Beans"};
    //  List<Profile> friends = new ArrayList<Profile>(Arrays.asList(Dylan, "Kieron", "Harriet"));

        Profile James = new Profile ("James", 9, 11, 1995, "Brynmill", "Wales" , "English", interests);
        Profile Dylan = new Profile ("Dylan",12, 02, 1997, "Brynmill", "Wales" , "Welsh", interests);
        Profile Kieron = new Profile ("Kieron", 14, 7, 1996, "Brynmill", "Wales" , "English", interests);
        Profile Harriet = new Profile ("Harriet", 14, 7, 1996, "Brynmill", "Wales" , "English", interests);

        BSTNode root = null;
        BST profileTree = new BST(root);
        
        profileTree.insertProfile(James);        
        profileTree.insertProfile(Dylan);        
        profileTree.insertProfile(Kieron);
        profileTree.printLeftToRight();
        System.out.println("=========");
        System.out.println("Adding H");
        System.out.println("=========");
        profileTree.insertProfile(Harriet);
        profileTree.printLeftToRight();
        
    }
}
