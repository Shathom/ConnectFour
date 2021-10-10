import java.util.Stack;

import javafx.scene.control.Button;

// * Project02 *//
// GameButton.java
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

public class GameButton extends Button {
	public int row = 0;
	public int column = 0;
	public int player = 0;
	public boolean isValid = false; // to check whether the move is valid 
	public boolean playerTurn = false;
	public Coordinate playerMove;
	public Stack<Coordinate> moves;

	GameButton (int row, int column, int player, boolean isValid, boolean playerTurn){
		Button gameButton = new Button();
		this.row = row;
		this.column = column;
		this.player = player;
		this.isValid = false;
		this.playerTurn = false;
		playerMove = new Coordinate(row, column);
//		moves.push(playerMove);
	}
	
	public void reverseMove() {
		moves.pop();
	}
	
	

}
