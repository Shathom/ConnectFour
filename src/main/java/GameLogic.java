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
	public static Vbutton button;
	public static int playerTurns = 1;
	
	
	static ArrayList<ArrayList<Vbutton>> matrix = new ArrayList<ArrayList<Vbutton>>();
	
	public static Coordinate move;
	
	public static void makeBoard() {
		for(int col = 0; col < 7; col++) {
			ArrayList<Vbutton> matrixRow = new ArrayList<Vbutton>();
			for(int row = 0; row < 6; row++) {
				button = new Vbutton(row, col, 1, false, false);
				if(row == 5) {
					
					button.setIsValid(true); // setting the 5th row set to valid for the beginning of the game
//					System.out.println("row and col ... etc" + button.getRow() + ", "+ button.getColumn() + " : valid:" + button.getIsValid());
				}
				matrixRow.add(button);
//				System.out.println("row and col ... etc" + button.getRow() + ", "+ button.getColumn() + " : valid:" + button.getIsValid());

			}
			matrix.add(matrixRow);
		}
	}
	
	public static void setInMainStack(Vbutton button) {
		playerMove = new Coordinate(button.getRow(), button.getColumn());
		moves.push(playerMove);
	}
	
	public static void setPieceInBoard(Vbutton button) {
		Vbutton checking = matrix.get(button.getColumn()).get(button.getRow());
		
		checking.setRow(button.getRow());
		checking.setColumn(button.getColumn());
		checking.setPlayer(button.getPlayer());
		checking.setIsValid(button.getIsValid());
		checking.setPlayerTurn(button.getPlayerTurn());
	}
	
	
	// we need to make almost most of these functions to return boolean so we can use eventhandler in javaFX
	public static int makeMove(Vbutton button) {
		int result=0;
		if (isValidMove(button)){
			if (!button.getPlayerTurn()) {
				playerTurns++;
				System.out.println("playerTurns:" + playerTurns);
				button.setPlayerTurn(true);
				if (playerTurns % 2 == 0) {
					button.setPlayer(1);
					setInMainStack(button);
					player1Stack(button.getRow(), button.getColumn());
					result = 1;
				} else {
					button.setPlayer(2);
					setInMainStack(button);
					player2Stack(button.getRow(), button.getColumn());
					result = 2;
				}
			}
		} else {
			System.out.println("playerTurns:" + playerTurns);

			if (playerTurns % 2 == 0) {
				button.setPlayer(2);
			} else {
				button.setPlayer(1);
			}
			result = 3;
		}
		return result;
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
	
		
	public static boolean isValidMove(Vbutton button) {
		System.out.println("the button's validity: "+button.getIsValid());
		System.out.println("the button's row and column: "+button.getRow() + ", " + button.getColumn());

		if(button.getIsValid()) {
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
