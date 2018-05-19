/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class TicTacToeTest {
    
    @Test
    public void testEmptyCell(){
        TicTacToeTable table = new TicTacToeTable();
        
        assertThat(table.isEmpty(0,0), equalTo(true));
    }
    
    @Test
    public void testNotEmptyCell(){
        TicTacToeTable table = new TicTacToeTable();
        table.put(Player.X, 0, 0);
        
        assertThat(table.isEmpty(0,0), equalTo(false));
    }
    
    @Test
    public void testEmptyState(){
        TicTacToeTable table = new TicTacToeTable();
        
        assertThat(table.currentState(), equalTo(GameState.ONGOING));
    }
    
    @Test
    public void testOnGoingState(){
        TicTacToeTable table = new TicTacToeTable();
        table.put(Player.X, 0, 0);
        table.put(Player.O, 1, 0);
        
        
        assertThat(table.currentState(), equalTo(GameState.ONGOING));
    }
    
    @Test
    public void testXWinsState(){
        TicTacToeTable table = new TicTacToeTable();
        table.put(Player.X, 0, 0);
        table.put(Player.O, 1, 0);
        table.put(Player.X, 0, 1);
        table.put(Player.O, 2, 1);
        table.put(Player.X, 0, 2);
        
        assertThat(table.currentState(), equalTo(GameState.X_WIN));
    }
    
    @Test
    public void testDrawState(){
        TicTacToeTable table = new TicTacToeTable();
        table.put(Player.X, 0, 0);
        table.put(Player.O, 1, 0);
        table.put(Player.X, 0, 1);
        table.put(Player.O, 0, 2);
        table.put(Player.X, 2, 0);
        table.put(Player.O, 1, 1);
        table.put(Player.X, 1, 2);
        table.put(Player.O, 2, 1);
        table.put(Player.X, 2, 2);
        
        assertThat(table.currentState(), equalTo(GameState.DRAW));
    }
}
