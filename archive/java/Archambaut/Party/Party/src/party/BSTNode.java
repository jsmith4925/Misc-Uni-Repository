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
public class BSTNode {
    Profile data;
    BSTNode leftChild;
    BSTNode rightChild;
    
    /**
     *
     * @param data
     */
    public BSTNode(Profile data){    
    this.data = data;

    }

    
    Profile getProfile (){
        return data;
    }
    
    /**
     *
     * @param l
     */
    public void setLeft(BSTNode l){
        this.leftChild = leftChild;        
        
    }
    
    /**
     *
     * @param r
     */
    public void setRight(BSTNode r){
        this.rightChild = rightChild;
    }
        
    BSTNode getLeft(){
        return leftChild;
    }
    
    BSTNode getRight(){
        return rightChild;
    }

    /**
     *
     * @return
     */
    public String NodeToString(){        
        return data.getName();
    }
       
}
