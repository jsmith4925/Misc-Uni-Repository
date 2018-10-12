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
public class BST {   
    
    BSTNode root;
        
    /**
     *
     * @param root
     */
    public BST(BSTNode root){
        this.root = root;
    }    
    
    /**
     *
     * @param p
     */
    public void insertProfile(Profile p){
        
        if(root == null){
            this.root = new BSTNode(p);           
        }else{
            recursiveInsert(p);
        }
    }    
        
    private void recursiveInsert(Profile p){

        String rootName = (root.getProfile()).getName();
        String profileName = (p.getName());
        
        if (profileName.compareTo(rootName) > 0){
            
            if( root.getRight() == null){
                root.rightChild = new BSTNode(p);
            }else{
                root = root.getRight();
                recursiveInsert(p);
            }
            
        }else{
            
            if( root.getLeft() == null){
                root.leftChild = new BSTNode(p);
            }else{
                root = root.getLeft();
                recursiveInsert(p);
            }
        }
        
    }
    
    /**
     *
     * @param node
     */
    public void printRightToLeft(BSTNode node) {
        if(node != null) {
            if(node.getRight() != null) {
                printRightToLeft(node.getRight());
            }
            System.out.println(node.NodeToString());
            if(node.getLeft() != null) {
                printRightToLeft(node.getLeft());
            }
        }
    }

    /**
     *
     * @param node
     */
    public void printLeftToRight(BSTNode node) {
        if(node != null) {
            if(node.getLeft() != null) {
                printLeftToRight(node.getLeft());
            }
            System.out.println(node.NodeToString());
            if(node.getRight() != null) {
                printLeftToRight(node.getRight());
            }
        }
    }
    
    /**
     *
     */
    public void printRightToLeft() {
        printRightToLeft(this.root);
    }

    /**
     *
     */
    public void printLeftToRight() {
        printLeftToRight(this.root);
    }

    
}
    
    