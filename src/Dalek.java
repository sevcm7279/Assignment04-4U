/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sevcm7279
 */
public class Dalek {
    // set up the instance variables
    private int row;
    private int col;
    public boolean crash;
    
    /**
     * a constructor to create a new dalek
     * @param row
     * @param col 
     */
    public Dalek(int row, int col){
        this.row = row;
        this.col = col;
        crash = false;
    }
  /**
   * 
   * @param doc 
   */
    public void advanceTowards(Doctor doc){
        // set the doctors row as a variable
        int docRow = doc.getRow();
        // set the doctor column as a variable
        int docCol = doc.getCol();
        
        // if the doctors row is greater than the dalek row
        // move the dalek up a row
        if (docRow > this.row){
            this.row ++;
        }
        // if the doctors row is less than the dalek row
        // move the dalek down a row
        if (docRow < this.row){
            this.row --;
        }
        // if the doctors column is greater than the dalek coloumn
        // move the dalek up a column      
        if (docCol > this.col){
            this.col ++;
        }
        // if the doctors column is less than the dalek column
        // move the dalek down a coloumn
        if (docCol < this.col){
            this.col --;
        }
    }
    
    /**
     * returns the current row of the specified dalek
     * @return the current row of the specified dalek
     */
    public int getRow(){
        return this.row;
    }
    /**
     * returns the current column of the specified dalek
     * @return the current column of the specified dalek
     */
    public int getCol(){
        return this.col;
    }
    /**
     * determine if a dalek has collided with another dalek
     * @param d0 the dalek specified
     * @return true or false of the daleks have collided
     */
    public boolean isCollideDalek(Dalek d0){
        // if the row and column of both daleks are the same
        // return true that they collided
        // set both crash as true
        if (d0.row == this.row && d0.col == this.col){
            crash = true;
            d0.crash = true;
            return true; 
        // if not, return false    
        }else{
            return false;
        }
    }
    /**
     * returns if crash is true or false
     * @return crash
     */
    public boolean hasDied(){
        return crash;
    }
   
   
    
}
