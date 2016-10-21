
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sevcm7279
 */
public class Doctor {
    
    // set up instance varibales
    private int row;
    private int col;
    private Color color;
    
    // contructor
    public Doctor(int row, int col){
    this.col = col;
    this.row = row; 
    
    }
    
    public void move(int newRow, int newCol){
        this.row = newRow;
        this.col = newCol;
        if (newRow == row || newRow == row + 1 || newRow == row - 1 && newCol == col || newCol == col +1 || newCol == col -1){
            row = newRow;
            col = newCol;
        }else{
            row = (int) (Math.random() * 12);
            col = (int) (Math.random() * 12);
        }
        
    }
    public int initialRow(){
        return (int)(Math.random()*12);
    }
    public int initialColumn(){
        return(int)(Math.random()*12);
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    
}
