import java.util.ArrayList;
import java.util.Stack;

import javafx.scene.control.Button;

// * Project02 *//
// GameButton.java
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

public class GameButton extends Button {
	public int row = 0;
	public int column = 0;
	public int player = 0;
	public boolean isValid = false; // to check whether the move is valid 
	public boolean playerTurn = false;

	GameButton (int row, int column, int player, boolean isValid, boolean playerTurn){
		Button gameButton = new Button();
		this.row = row;
		this.column = column;
		this.player = player;
		this.isValid = isValid;
		this.playerTurn = playerTurn;
	}
	
	public void nowValidButton(int row, int column) {
		this.isValid = true;
	}
	
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	public int getPlayer() {
		return player;
	}
	public boolean getIsValid() {
		return isValid;
	}
	public boolean getPlayerTurn() {
		return playerTurn;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public void setPlayer(int player) {
		this.player = player;
	}
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
	public void setPlayerTurn(boolean playerTurn) {
		this.playerTurn = playerTurn;
	}
	
	

}
