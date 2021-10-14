import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

// * Project02 *//
// GameLogic.java
// ****************************************************************************/
// University of Illinois at Chicago
// Class: CS 342, FALL 2021
// Author: Haeun Kim
// Author: Sharon Thomeh
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

	public static Stack<Coordinate> moves = new Stack<Coordinate>();
	public static Stack<Coordinate> movesPlayer1 = new Stack<Coordinate>();
	public static Stack<Coordinate> movesPlayer2 = new Stack<Coordinate>();

	static Vector<Coordinate> matrix = new Vector<Coordinate>(7);
	public static Coordinate move;
	
	public static void addMatrix(int row, int column) {
		move = new Coordinate(row, column);
		matrix.add(move);
		System.out.println("adding matrix: " + row + " , " + column);

	}
	
	
	public static void setInStack(int row, int column) {
		playerMove = new Coordinate(row, column);
		moves.push(playerMove);
	}
	
	// stack that stores first player's move
	public static void player1Stack(int row, int column) {
		player1Move = new Coordinate(row, column);
		movesPlayer1.push(player1Move);
		System.out.println("player1move coordinate: " + player1Move);
	}
		
	
	// stack that stores second player's move
	public static void player2Stack(int row, int column) {
		player2Move = new Coordinate(row, column);
		movesPlayer2.push(player2Move);
	}
	
		
	public static boolean isValidMove(boolean isValid, int column, int row) {
		if(isValid) {
			return true;
		} else {
			return false;
		}		
	}
	
	public static Coordinate reverseMove() {
		Coordinate popedMove = null;
		if (moves.isEmpty()) {
			throw new NullPointerException("No more items left to reverse!");
		} else {
			popedMove = moves.pop();
		}
		return popedMove;
	}

	
	
	
	
	// take postion in grid and then evaluate if it is correct
	// pass the position of the button to gameButton
	// save the state of the game and a data structre to see what has occured on the grid
	// don't need to include javaFX elements
	// everything in this methods should be static!

}
