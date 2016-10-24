
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
    
    public static int randomNum(){
        return (int) (Math.random() * 12);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create the game board
        Board board = new Board(12, 12);

        // create the doctor
        Doctor doc = new Doctor (randomNum(), randomNum());
        
        // create dalek
        Dalek d1 = new Dalek(randomNum(), randomNum());
        Dalek d2 = new Dalek(randomNum(), randomNum());
        Dalek d3 = new Dalek(randomNum(), randomNum());
        
        // place the daleks
        board.putPeg(Color.YELLOW, d1.getRow(), d1.getCol());
        board.putPeg(Color.YELLOW, d2.getRow(), d2.getCol());
        board.putPeg(Color.YELLOW, d3.getRow(), d3.getCol());
        
        // place doctor peg
        board.putPeg(Color.GREEN, doc.getRow(), doc.getCol());

        while (true) {
            // get clicks on the board
            // send back a coordinate where was clicked
            Coordinate click = board.getClick();
            int row = click.getRow();
            int col = click.getCol();

            // remove the last peg
            board.removePeg(doc.getRow(), doc.getCol());
            
            // call upon the doctor's move method
            doc.move(row, col);
            
            // place a peg where you clicked
            board.putPeg(Color.GREEN, doc.getRow(), doc.getCol());
            
            // move the daleks
            d1.advanceTowards(doc);
            d2.advanceTowards(doc);
            d3.advanceTowards(doc);
            
        }



    }
}
