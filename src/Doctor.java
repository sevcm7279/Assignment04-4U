
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

    /**
     * a constructor to create a new doctor
     * @param row
     * @param col 
     */
    public Doctor(int row, int col) {
        this.col = col;
        this.row = row;

    }
    /**
     * moves the doctor to the parameters of the click if click was near the doctor
     * or moves the doctor to a random location
     * @param newRow
     * @param newCol 
     */
    public void move(int newRow, int newCol) {
        // if the click was anywhere surrounding the doctor, move to that spot
        if (col == newCol || col == (newCol + 1) || col == newCol - 1) {
            if (row == newRow || row == newRow + 1 || row == newRow - 1) {
                row = newRow;
                col = newCol;
            } else {
                // if the click was far away form the doctor, randomize the coordinates
                row = (int) (Math.random() * 12);
                col = (int) (Math.random() * 12);
            }
        } else {
            // if the click was far away form the doctor, randomize the coordinates
            row = (int) (Math.random() * 12);
            col = (int) (Math.random() * 12);
        }

    }
    /**
     * returns the current row the doctor is on
     * @return the current row the doctor is one
     */
    public int getRow() {
        return this.row;
    }
    /**
     * returns the current column the doctor is on
     * @return the current column the doctor is on
     */
    public int getCol() {
        return this.col;
    }
    
    /**
     * determine if the doctor has collided with another dalek
     * @param d0 the dalek specified in the main class
     * @return if they have collided or not
     */
    public boolean isCollide(Dalek d0) {
        // if the dalek specified is in the same square as the other dalek specified
        // return true that they collided
        if (this.row == d0.getRow() && this.col == d0.getCol()) {
            return true;
        // if they are nnot in the same square, return false    
        } else {
            return false;
        }
    }
}
