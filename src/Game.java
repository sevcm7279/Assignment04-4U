
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

    public static int randomNum() {
        return (int) (Math.random() * 12);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create the game board
        Board board = new Board(12, 12);

        // create the doctor
        Doctor doc = new Doctor(randomNum(), randomNum());

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

            // remove the daleks
            board.removePeg(d1.getRow(), d1.getCol());
            board.removePeg(d2.getRow(), d2.getCol());
            board.removePeg(d3.getRow(), d3.getCol());
            // move the daleks if they have not crashed
            if (d1.hasDied() == false){
                d1.advanceTowards(doc);
            }    
            if (d2.hasDied() == false){
                d2.advanceTowards(doc);
            }    
            if (d3.hasDied() == false){
                d3.advanceTowards(doc);
            }
            // replace the daleks
            board.putPeg(Color.YELLOW, d1.getRow(), d1.getCol());
            board.putPeg(Color.YELLOW, d2.getRow(), d2.getCol());
            board.putPeg(Color.YELLOW, d3.getRow(), d3.getCol());

            // check for collisions between daleks
            // and initiate crashes
            if (d1.isCollideDalek(d2) == true|| d1.isCollideDalek(d3)== true) {
                // put a red peg on the location of collision
                board.putPeg(Color.RED, d1.getRow(), d1.getCol());
            }
            if (d2.isCollideDalek(d1) == true|| d1.isCollideDalek(d3)== true) {
                board.putPeg(Color.RED, d2.getRow(), d2.getCol());
            }
            if (d3.isCollideDalek(d1) == true|| d3.isCollideDalek(d2)== true){
                board.putPeg(Color.RED, d3.getRow(), d3.getCol());   
            }
            
            // check if doctor has collided
            if (doc.isCollide(d1) || doc.isCollide(d2) || doc.isCollide(d3)){
                // place a crash peg
                board.putPeg(Color.RED, doc.getRow(), doc.getCol());
                // display win message
                board.displayMessage("You Lose");
                // stop the game
                break;
                
                
            }
        }



    }
}
