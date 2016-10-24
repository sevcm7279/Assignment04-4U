
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
    public Doctor(int row, int col) {
        this.col = col;
        this.row = row;

    }

    Doctor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void move(int newRow, int newCol) {
        // if the click was anywhere surrounding the doctor, move to that spot
        if (col == newCol || col == (newCol + 1) || col == newCol - 1){
            if (row == newRow || row == newRow + 1 || row == newRow - 1){
                row = newRow;
            col = newCol;
            }
              
        } else {
            // if the click was far away form the doctor, randomize the coordinates
            row = (int) (Math.random() * 12);
            col = (int) (Math.random() * 12);
        }

    }

   
    

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}
