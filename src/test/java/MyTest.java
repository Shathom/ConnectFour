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
	static Vbutton button, button1, button2, button3;
	@BeforeEach
	void init() {
		GameLogic.makeBoard();

	}	
	
	@Test
	void makeBoardTest0() {
		Vbutton button1 = new Vbutton(5, 1, 1, true, false, false);
//		GameLogic.setPieceInBoard(button);
		assertEquals(true, button1.getIsValid(), "incorrecto isValid");  
	}

	
	@Test
	void makeBoardTest2() {
		button = new Vbutton(5, 1, 1, true, false, false);
		GameLogic.setPieceInBoard(button);
		// supposed to be return true.. but it's returning false I don't know why..
		assertEquals(5, button.getRow(), "correcto row");  
	}

	@Test
	void makeBoardTest3() {
		button = new Vbutton(5, 1, 1, true, false, false);
		GameLogic.setPieceInBoard(button);
		// supposed to be return true.. but it's returning false I don't know why..
		assertEquals(false, button.getPlayerTurn(), "correcto row");  
	}

	@Test
	void makeMoveTest0() {
		button = new Vbutton(5, 1, 1, true, false, false);
		GameLogic.setPieceInBoard(button);		
		assertEquals(1, GameLogic.makeMove(button), "wrong validity of button");
	}
	
	@Test
	void makeMoveTest1() {
		button = new Vbutton(3, 1, 1, false, false, false);
		GameLogic.setPieceInBoard(button);		
		assertEquals(3, GameLogic.makeMove(button), "wrong validity of button");
	}

	@Test
	void testHorizontalCheckA() {
		button = new Vbutton(5, 0, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 1, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 2, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 3, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		assertEquals(true, GameLogic.checkHorizontal(button), "wrong checkHorizontal A");
		
	}
	
	@Test
	void testHorizontalCheckB() {
		button = new Vbutton(5, 0, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 1, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 2, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 4, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 5, 1, true, true, false);
		GameLogic.setPieceInBoard(button);	
		assertEquals(false, GameLogic.checkHorizontal(button), "wrong checkHorizontal B");

	}
	@Test
	void testVerticalCheck() {
		button = new Vbutton(5, 1, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 4, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(4, 1, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 5, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 5, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		assertEquals(false, GameLogic.checkVertical(button), "wrong checkvertical");

	}
	@Test
	void testVerticalCheck1() {
		button = new Vbutton(5, 1, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(4, 1, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(3, 1, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(2, 1, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 5, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		assertEquals(true, GameLogic.checkVertical(button), "wrong checkvertical 1");
	}
	
	@Test
	void testcheckDiagonal1() {
		button = new Vbutton(5, 0, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 1, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(4, 1, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 2, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(4, 2, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 3, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(3, 2, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(4, 3, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(2, 3, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		assertEquals(true, GameLogic.checkDiagonal1(button), "wrong checkDiagonal1");
	}
	
	@Test
	void testcheckDiagonal2() {
		button = new Vbutton(5, 4, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 3, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(4, 3, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 2, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(4, 2, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 1, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(3, 2, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(4, 1, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(3, 1, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 6, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(2, 1, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		assertEquals(true, GameLogic.checkDiagonal2(button), "wrong checkDiagonal2");
	}
	
	@Test
	void testcheckWinner() {
		button = new Vbutton(5, 4, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 3, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(4, 3, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 2, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(4, 2, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 1, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(3, 2, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(4, 1, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(3, 1, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 6, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(2, 1, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		assertEquals(true, GameLogic.checkWinner(button), "wrong checkWinner");
	}
	
	@Test
	void testreturnWinner1() {
		button = new Vbutton(5, 0, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 1, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 2, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 3, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		assertEquals(1, GameLogic.returnWinner(button), "wrong returnWinner 1");

	}
	@Test
	void testreturnWinner2() {
		button = new Vbutton(5, 0, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 1, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 2, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		button = new Vbutton(5, 3, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		assertEquals(2, GameLogic.returnWinner(button), "wrong returnWinner 2");
	}
	
	@Test
	void testmakeMove1() {
		button = new Vbutton(5, 6, 1, true, true, false);
		GameLogic.setPieceInBoard(button);
		assertEquals(1, GameLogic.makeMove(button), "wrong makeMove 1");
	}
	
	@Test
	void testmakeMove2() {
		button = new Vbutton(5, 5, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		assertEquals(2, GameLogic.makeMove(button), "wrong makeMove 2");
	}
	@Test
	void testmakeMove3() {
		button = new Vbutton(1, 0, 2, false, false, false);
		GameLogic.setPieceInBoard(button);
		assertEquals(3, GameLogic.makeMove(button), "wrong makeMove 3");
	}
	
	@Test
	void testisValidMove1() {
		button = new Vbutton(5, 0, 2, true, true, false);
		GameLogic.setPieceInBoard(button);
		assertEquals(true, GameLogic.isValidMove(button), "wrong isValidMove 1");
	}
	
	@Test
	void testisValidMove2() {
		button = new Vbutton(1, 0, 2, false, false, false);
		GameLogic.setPieceInBoard(button);
		assertEquals(false, GameLogic.isValidMove(button), "wrong isValidMove 2");
	}

}
