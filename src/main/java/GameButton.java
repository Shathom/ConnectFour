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
	int row = 0;
	int column = 0;
	int player = 0;
	
	GameButton(int row, int column, int player){
		Button gameButton = new Button();
		this.row = row;
		this.column = column;
		this.player = player;
	}
	
	
	
	
	
}
