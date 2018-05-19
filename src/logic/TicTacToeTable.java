/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author user
 */
public class TicTacToeTable {
    
    public static final int SIZE = 3;
    public static final int WINNING_SIZE = 3;
    
    private List<List<Integer>> table;

    public TicTacToeTable() {
        table = new ArrayList<>();
        for(int i = 0; i < SIZE; i++) {
            table.add(Stream.iterate(0, a -> a).limit(SIZE).collect(Collectors.toList()));
        }
    }
   
    public TicTacToeTable(List<List<Integer>> table) {
        this.table = table;
    }
    
    public List<List<Integer>> getTable(){
        return table;
    }
    
    public boolean isEmpty(int x, int y) {
        if(x<0 || x>= SIZE){
            throw new IllegalArgumentException("First coordinate cannot be negative or greater than the size of the table");
        }
        if(y<0 || y>= SIZE){
            throw new IllegalArgumentException("First coordinate cannot be negative or greater than the size of the table");
        }
        return table.get(x).get(y) == 0;
    }
    
    public void put(Player player, int x, int y){
        if(x<0 || x>= SIZE){
            throw new IllegalArgumentException("First coordinate cannot be negative or greater than the size of the table");
        }
        if(y<0 || y>= SIZE){
            throw new IllegalArgumentException("First coordinate cannot be negative or greater than the size of the table");
        }
        table.get(x).set(y,player.getValue());
    }
    
    public GameState currentState(){
        for (int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if (isHorizontal(i,j) || isVertical(i, j) || isDiagonalUp(i, j) || isDiagonalDown(i,j)){
                    if(table.get(i).get(j) == Player.X.getValue()) return GameState.X_WIN;
                    if(table.get(i).get(j) == Player.O.getValue()) return GameState.O_WIN;
                }
            }
        }
        if(table.stream().flatMap(List::stream).filter(a -> a == 0).count() > 0) return GameState.ONGOING;
        return GameState.DRAW;
    }
    
    private boolean isHorizontal(int startX, int startY){
        try{
            for (int i = startY; i < startY + WINNING_SIZE - 1; i++){
                if(table.get(startX).get(i) != table.get(startX).get(i+1))
                    return false;
            }
        } catch (IndexOutOfBoundsException ex){
            return false;
        }
        return true;
    }
    
    private boolean isVertical(int startX, int startY){
        try{
            for (int i = startX; i < startX + WINNING_SIZE - 1; i++){
                if(table.get(i).get(startY)!= table.get(i+1).get(startY))
                    return false;
            }
        } catch (IndexOutOfBoundsException ex){
            return false;
        }
        return true;
    }
    
    private boolean isDiagonalUp(int startX, int startY){
        try{
            for (int i = 0; i < WINNING_SIZE; i++){
                if(table.get(startX - i).get(startY + i) != table.get(startX - i - 1).get(startY + i + 1))
                    return false;
            }
        } catch (IndexOutOfBoundsException ex){
            return false;
        }
        return true;
    }
    
    private boolean isDiagonalDown(int startX, int startY){
        try{
            for (int i = 0; i < WINNING_SIZE; i++){
                if(table.get(startX + i).get(startY + i) != table.get(startX + i + 1).get(startY + i + 1))
                    return false;
            }
        } catch (IndexOutOfBoundsException ex){
            return false;
        }
        return true;
    }
    
}
