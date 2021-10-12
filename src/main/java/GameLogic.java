import java.util.ArrayList;
import java.util.Stack;

import javafx.scene.control.Button;

// * Project02 *//
// GameLogic.java
// ****************************************************************************/
// University of Illinois at Chicago
// Class: CS 342, FALL 2021
// Author: Haeun Kim, UIC
// Author: Sharon Thomeh
// UIN number: 657655430
// Connect Four JavaFX GUI
// Implement the classic game of Connect Four. This is a simple game to
// understand and play which should allow you to focus on learning GUI
// development in JavaFx and trying your hand at event driven programming.
// ****************************************************************************/
public class GameLogic {
	
	// everything in this methods should be static!
	public static Coordinate playerMove;
	public static Stack<Coordinate> moves = new Stack<Coordinate>();
	public static ArrayList<Coordinate> validMoveCheck = new ArrayList<Coordinate>();
	
	
	GameLogic (int row, int column){
		playerMove = new Coordinate(row, column);
		moves.push(playerMove);
	}

	public static boolean isValidMove(boolean isValid, int column, int row) {
		if(isValid) {
			if (isValid) {
				row = row -1;
			}
			return true;
		} else {
			return false;
		}		
	}
	
	public static void addArray() {
		ArrayList<Coordinate> array = new ArrayList<Coordinate>();   
		array.add(playerMove);
        for(int i=0;i<array.size();i++){
            System.out.println(array);
        }	
	}
	
	public static void reverseMove() {
		moves.pop();
	}
	
	public static Coordinate returnPrevMove() {
		return moves.peek();
	}
	
	
	
	
	// take postion in grid and then evaluate if it is correct
	// pass the position of the button to gameButton
	// save the state of the game and a data structre to see what has occured on the grid
	// don't need to include javaFX elements
	// everything in this methods should be static!

}
