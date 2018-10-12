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
public class BSTNodeMain {
    
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
        
        
        BSTNode newNode = new BSTNode(James);
        BSTNode temp = new BSTNode(Kieron);

        System.out.println(James.toString());
        System.out.println(newNode.NodeToString());
        System.out.println(Dylan.toString());
        System.out.println(Kieron.toString());
        
       newNode.setLeft(temp);
       BSTNode left = newNode.getLeft();
       if(left == null){
       System.out.println("left.NodeToString() is null");    
       }else{
       System.out.println(left.NodeToString());
       }
       
        
        
    }
}
