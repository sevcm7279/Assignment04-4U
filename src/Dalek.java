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
        public boolean crash;
    
    // constructor
    public Dalek(int row, int col){
        this.row = row;
        this.col = col;
        crash = false;
    }
    public void advanceTowards(Doctor doc){
        int docRow = doc.getRow();
        
        if (docRow > this.row){
            this.row ++;
        }
        int docRow1 = doc.getRow();
        if (docRow1 < this.row){
            this.row --;
        }
        int docCol = doc.getCol();
        
        if (docCol > this.col){
            this.col ++;
        }
        int docCol1 = doc.getCol();
        if (docCol1 < this.col){
            this.col --;
        }
    }
    
    public int getRow(){
        return this.row;
    }
    
    public int getCol(){
        return this.col;
    }
    
    public boolean isCollideDalek(Dalek d0){
        if (d0.row == this.row && d0.col == this.col){
            crash = true;
            d0.crash = true;
            return true;      
        }else{
            return false;
        }
    }
    
    public boolean hasDied(){
        return crash;
    }
   
   
    
}
