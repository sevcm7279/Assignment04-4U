/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sevcm7279
 */
public class Dalek {
        private int row;
        private int col;
    
    // constructor
    public Dalek(int row, int col){
        this.row = row;
        this.col = col;
    }
    public void advanceTowards(Doctor doc){
        int docRow = doc.getRow();
        
        if (docRow > this.row){
            this.row ++;
        }
        if (docRow < this.row){
            this.row --;
        }
        int docCol = doc.getCol();
        
        if (docCol > this.col){
            this.col ++;
        }
        if (docCol < this.col){
            this.col --;
        }
    }
    
    public int getRow(){
        return this.row;
    }
    
    public int getCol(){
        return this.col;
    }
    
   
    
}
