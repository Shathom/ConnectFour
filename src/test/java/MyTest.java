// * Project02 *//
// MyTestt.java
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

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Testing GameLogic class 
class MyTest {
	static ArrayList<ArrayList<Vbutton>> matrix = new ArrayList<ArrayList<Vbutton>>();
	static ArrayList<Vbutton> matrixRow = new ArrayList<Vbutton>();
	static Vbutton button;
	
	@BeforeEach
	void init() {
		
	}	
	
	
	@Test
	void makeBoardTest0() {
		GameLogic.makeBoard();
		button = new Vbutton(5, 1, 1, true, false);
		GameLogic.setPieceInBoard(button);
		// supposed to be return true.. but it's returning false I don't know why..
		assertEquals(true, button.getIsValid(), "correcto isValid");  
	}

	
	@Test
	void makeBoardTest2() {
		GameLogic.makeBoard();
		button = new Vbutton(5, 1, 1, true, false);
		GameLogic.setPieceInBoard(button);
		// supposed to be return true.. but it's returning false I don't know why..
		assertEquals(5, button.getRow(), "correcto row");  
	}

	@Test
	void makeBoardTest3() {
		GameLogic.makeBoard();
		button = new Vbutton(5, 1, 1, true, false);
		GameLogic.setPieceInBoard(button);
		// supposed to be return true.. but it's returning false I don't know why..
		assertEquals(false, button.getPlayerTurn(), "correcto row");  
	}

}
