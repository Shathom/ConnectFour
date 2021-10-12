import java.util.ArrayList;
import java.util.Stack;

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
	public static Coordinate player1Move;
	public static Coordinate player2Move;
	public static Coordinate validMove;
	
	public static Coordinate move;

	
	public static Stack<Coordinate> moves = new Stack<Coordinate>();
	public static Stack<Coordinate> movesPlayer1 = new Stack<Coordinate>();
	public static Stack<Coordinate> movesPlayer2 = new Stack<Coordinate>();
	public static Stack<Coordinate> validMoveStack = new Stack<Coordinate>();


	public static ArrayList<Coordinate> validMoveCheck = new ArrayList<Coordinate>();
	
	
	public static void setInStack(int row, int column) {
		playerMove = new Coordinate(row, column);
		moves.push(playerMove);
	}
	
	// stack that stores first player's move
	public static void player1Stack(int row, int column) {
		player1Move = new Coordinate(row, column);
		movesPlayer1.push(player1Move);
		System.out.println("player1move coordinate: " + player1Move);


//		System.out.println("prints row and column: " + row + " , " + column);
	}
		
	
	// stack that stores second player's move
	public static void player2Stack(int row, int column) {
		player2Move = new Coordinate(row, column);
		movesPlayer2.push(player2Move);
	}
	
	// stack that stores valid move
	public static void vaidMoveStack(boolean isValid, int row, int column) {
		validMove = new Coordinate(row, column);
		validMoveStack.push(validMove);
		System.out.println("prints valid move coordinate: " + row + " , " + column);

	}
		
		
	
	public static boolean isValidMove(boolean isValid, int column, int row) {
		if(isValid) {
			if (isValid) {
				if(isValidMove2(isValid, column, row)) {
					return true;
				}

			}
			return true;
		} else {
			return false;
		}		
	}
	public static boolean isValidMove2(boolean isValid, int column, int row) {
		move = new Coordinate(row, column);
		System.out.println("Does the Stack contains this coordinate? "
                + validMoveStack.contains(move));
		if(validMoveStack.contains(move)) {
			return true;
		} else {
			return false;
		}
//		row = row - 1;
//		isValid = true;
		
		
		
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
