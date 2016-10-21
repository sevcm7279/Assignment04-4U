
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sevcm7279
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create the game board
        Board board = new Board(12, 12);


        int randCol = (int) (Math.random() * 12);
        int randRow = (int) (Math.random() * 12);
        // create the doctor
        Doctor doc = new Doctor(randRow, randCol);
        // place doctor peg
        board.putPeg(Color.GREEN, randRow, randCol);

        while (true) {
            // get clicks on the board
            // send back a coordinate where was clicked
            Coordinate click = board.getClick();
            int row = click.getRow();
            int col = click.getCol();

            // remove the last peg
            board.removePeg(doc.getRow(), doc.getCol());
            
            doc.move(row, col);
            
            // place a peg where you clicked
            board.putPeg(Color.GREEN, doc.getRow(), doc.getCol());
        }



    }
}
