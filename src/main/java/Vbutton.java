import javafx.scene.control.Button;

// * Project02 *//
// Matrix.java
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

public class Vbutton {

	private int row;
	private int column;
	private int player;
	private boolean isValid; 
	private boolean playerTurn;


	public Vbutton (int row, int column, int player, boolean isValid, boolean playerTurn){
		this.row = row;
		this.column = column;
		this.player = player;
		this.isValid = false;
		this.playerTurn = false;
	}

	// Not sure whether we need these getter and setter 
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



