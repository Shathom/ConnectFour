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
				matrixRow.add(button);
			}
			matrix.add(matrixRow);
		}
	}
	
	public static void setInMainStack(Vbutton button) {
		playerMove = new Coordinate(button.getRow(), button.getColumn());
		moves.push(playerMove);
	}
	
	public static void setPieceInBoard(Vbutton button) {
		matrix.get(button.getRow()).get(button.getColumn()).setRow(button.getRow());
		matrix.get(button.getRow()).get(button.getColumn()).setColumn(button.getColumn());
		matrix.get(button.getRow()).get(button.getColumn()).setPlayer(button.getPlayer());
		matrix.get(button.getRow()).get(button.getColumn()).setIsValid(button.getIsValid());
		matrix.get(button.getRow()).get(button.getColumn()).setPlayerTurn(button.getPlayerTurn());
	}
	
	public static void makeMove(Vbutton button) {
		if (isValidMove(button.getIsValid(), button.getColumn(), button.getRow())) {
			if (!button.getPlayerTurn()) {
				playerTurns++;
				button.setPlayerTurn(true);
				if (playerTurns % 2 == 0) {
					button.setPlayer(1);
					setInMainStack(button);
					player1Stack(button.getRow(), button.getColumn());
//					prevButton = enableButton(gameButton.isValid, gameButton.row-1, gameButton.column, grid);
//					prevButton.setDisable(false);
//					gameButton.setStyle("-fx-background-color: Blue");
				} else {
					button.setPlayer(2);
					setInMainStack(button);
					player2Stack(button.getRow(), button.getColumn());
//					gameButton.setStyle("-fx-background-color: Red");
//					prevButton = enableButton(gameButton.isValid, gameButton.row-1, gameButton.column, grid);
//					prevButton.setDisable(false);
				}
			}
//			gameButton.setDisable(true);
//			displayPlayer.getItems().clear();
//			displayPlayer.getItems()
//					.add("Player " + gameButton.player + " pressed " + gameButton.row + ", " + gameButton.column + ". Valid move.");
		} else if (!isValidMove(button.getIsValid(), button.getColumn(), button.getRow())){
			if (playerTurns % 2 == 0) {
				button.setPlayer(2);
			} else {
				button.setPlayer(1);

			}
//			gameButton.setDisable(false);
//			displayPlayer.getItems().clear();
//			displayPlayer.getItems().add("Player " + gameButton.player + " moved to " + gameButton.row + ", " + gameButton.column
//					+ ". This is NOT a valid move. Player " + gameButton.player + " pick again.");
		}
	
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
