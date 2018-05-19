/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author user
 */
public enum Player {
    X(1), O(2);
    
    private int value;
    
    private Player(int value){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
}
