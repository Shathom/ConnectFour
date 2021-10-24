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
	public static Coordinate playerMoveForWinner;
	public static Coordinate player2Move;

	public static Stack<Coordinate> moves = new Stack<Coordinate>();
	public static Stack<Coordinate> winnerMoves = new Stack<Coordinate>();
	public static Vbutton button, prevButton;
	public static int winnerButton = 0;
	public static int playerTurns = 1;
	public static int counterDiagonal1, counterDiagonal2, counterHorizontal, counterVerical;
	
	
	static ArrayList<ArrayList<Vbutton>> matrix = new ArrayList<ArrayList<Vbutton>>();
	
	public static Coordinate move; 
	
	
	public static void makeBoard() {
	    matrix = new ArrayList<ArrayList<Vbutton>>();
		for(int row = 0; row < 6; row++) {
			ArrayList<Vbutton> matrixRow = new ArrayList<Vbutton>();
			for(int col = 0; col < 7; col++) {
				button = new Vbutton(row, col, 0, false, false, false);
				if(row == 5) {					
					button.setIsValid(true); // setting the 5th row set to valid for the beginning of the game
//					System.out.println("row and col ... etc" + button.getRow() + ", "+ button.getColumn() + " : valid:" + button.getIsValid());
				}
				matrixRow.add(button);
				System.out.print(button.getIsValid() + " ");
//				System.out.println("row and col ... etc" + button.getRow() + ", "+ button.getColumn() + " : valid:" + button.getIsValid());

			}
			matrix.add(matrixRow);
			System.out.println();
			
			
		}
	}
	
	public static void setInMainStack(Vbutton button) {
		playerMove = new Coordinate(button.getRow(), button.getColumn());
		moves.push(playerMove);
	}
	

	public static void winnerStack(Vbutton button) {
	playerMoveForWinner = new Coordinate(button.getRow(), button.getColumn());
	winnerMoves.push(playerMoveForWinner);
	
}
	
	
	public static void setPieceInBoard(Vbutton button) {
		Vbutton checking = matrix.get(button.getRow()).get(button.getColumn());
		checking.setRow(button.getRow());
		checking.setColumn(button.getColumn());
		checking.setPlayer(button.getPlayer());
		checking.setIsValid(button.getIsValid());
		checking.setPlayerTurn(button.getPlayerTurn());
	}
	
	static boolean checkHorizontal(Vbutton button) {
		counterHorizontal = 0;
		boolean isWinner = false;
		int buttonPlayer = button.getPlayer();
		for(int col = 0; col < 7; col++) {
			Vbutton matrixbutton = matrix.get(button.getRow()).get(col);
			if(matrixbutton.getPlayer() == buttonPlayer) {
				winnerStack(matrixbutton);
				counterHorizontal++;
				winnerStack(button);
			    System.out.print("horizontal count: "+counterHorizontal+ "\n");
			    System.out.println(col + ", "+ button.getRow() + "\n");
			} else {
				
				counterHorizontal = 0;
				winnerMoves.clear();
			}
			if(counterHorizontal == 4) {
				isWinner = true;
				break;
			}
		}
		if (isWinner == false) {
			winnerMoves.clear();
		}
		return isWinner;
	}
	
	static boolean checkVertical(Vbutton button) {
		counterVerical = 0;
		boolean isWinner = false;
		int buttonPlayer = button.getPlayer();

		for (int row = 0; row < matrix.size(); row++) {
			Vbutton matrixbutton = matrix.get(row).get(button.getColumn());
			if(matrixbutton.getPlayer() == buttonPlayer) {
				counterVerical++;
				winnerStack(matrixbutton);
			    System.out.print("vertical count++: "+counterVerical + "\n");

			} else {
				counterVerical = 0;
				winnerMoves.clear();
			}
			
			if(counterVerical == 4) {
				isWinner = true;
				break;
			}			
		}
		if (isWinner == false) {
			winnerMoves.clear();
		}
		return isWinner;
	}
	
	
	static boolean checkDiagonal1(Vbutton button) {
		counterDiagonal1 = 1;
		boolean isWinner = false;
		int buttonPlayer = button.getPlayer();
		int buttonRow = button.getRow()+1;
		int buttonColumn = button.getColumn()-1;
		for(int i = 0; i < 4; i++) {
			if(buttonRow < 6 && buttonColumn >= 0) {
			Vbutton matrixbuttonColumn = matrix.get(buttonRow).get(buttonColumn); // getting the col from the "grid"
				if(matrixbuttonColumn.getPlayer() == buttonPlayer) {
					buttonRow++;
					buttonColumn--;
					counterDiagonal1++;
					winnerStack(matrixbuttonColumn);
					System.out.print("DIAGONAL count--: "+counterDiagonal1 + " row: " + button.getRow() + "column: " + button.getColumn() + "\n");	
					if (counterDiagonal1 == 4) {
						isWinner = true;
						return true;
					} 
				} 
			} else {
				winnerMoves.clear();
				break;
			}						
		}
		buttonRow = button.getRow();
		buttonColumn = button.getColumn();
		buttonRow = button.getRow()-1;
		buttonColumn = button.getColumn()+1;
		for(int i = 0; i < 4; i++) {
			if(buttonRow >= 0 && buttonColumn < 7) {			
			Vbutton matrixbuttonColumn = matrix.get(buttonRow).get(buttonColumn); // getting the col from the "grid"
				if(matrixbuttonColumn.getPlayer() == buttonPlayer) {
					buttonRow--;
					buttonColumn++;
					counterDiagonal1++;
					winnerStack(matrixbuttonColumn);
					System.out.print("DIAGONAL count--: "+counterDiagonal1 + " row: " + button.getRow() + "column: " + button.getColumn() + "\n");	
					if (counterDiagonal1 == 4) {
						isWinner = true;
						return true;
					} 
				}
			} else {
				winnerMoves.clear();
				break;
			}
	    }
		if (isWinner == false) {
			winnerMoves.clear();
		}
		return isWinner;

	}

	static boolean checkDiagonal2(Vbutton button) {
		counterDiagonal2 = 1;
		boolean isWinner = false;
		int buttonPlayer = button.getPlayer();
		int buttonRow = button.getRow()+1;
		int buttonColumn = (button.getColumn())+1;
		
		for(int i = 0; i < 4; i++) {
			if(buttonRow < 6 && buttonColumn < 7) {			
			Vbutton matrixbuttonColumn = matrix.get(buttonRow).get(buttonColumn); // getting the col from the "grid"
				if(matrixbuttonColumn.getPlayer() == buttonPlayer) {
					buttonRow++;
					buttonColumn++;
					counterDiagonal2++;
					winnerStack(matrixbuttonColumn);
					System.out.print("DIAGONAL count--: "+counterDiagonal2 + " row: " + button.getRow() + "column: " + button.getColumn() + "\n");	
					if (counterDiagonal2 == 4) {
						isWinner = true;
						return true;
					} 
				}
			} else {
				winnerMoves.clear();
				break;
			}
		}
		buttonRow = button.getRow();
		buttonColumn = button.getColumn();
		buttonRow = button.getRow()-1;
		buttonColumn = button.getColumn()-1;
		
		for(int i = 0; i < 4; i++) {
			if(buttonRow >= 0 && buttonColumn >= 0) {			
			Vbutton matrixbuttonColumn = matrix.get(buttonRow).get(buttonColumn); // getting the col from the "grid"
				if(matrixbuttonColumn.getPlayer() == buttonPlayer) {
					buttonRow--;
					buttonColumn--;
					counterDiagonal2++;
					winnerStack(matrixbuttonColumn);
					System.out.print("DIAGONAL count--: "+counterDiagonal2 + " row: " + button.getRow() + "column: " + button.getColumn() + "\n");	
					if (counterDiagonal2 == 4) {
						isWinner = true;
						return true;
					} 
				}
			} else {
				winnerMoves.clear();
				break;
			}
		}
		if (isWinner == false) {
			winnerMoves.clear();
		}
		return isWinner;
	}	
	
	static boolean checkWinner(Vbutton button) {
		boolean result = false;
		if (checkHorizontal(button)) {
			winnerButton = button.getPlayer();
			result = true;
			System.out.println("Horizontal WINNER is " + button.getPlayer());
		} else if(checkVertical(button)) {
			winnerButton = button.getPlayer();
			result = true;
			System.out.println("Vertical WINNER is " + button.getPlayer());
		} else if(checkDiagonal1(button)) {
			winnerButton = button.getPlayer();
			result = true;
			System.out.println("DIAGONAL WINNER is " + button.getPlayer());
		} else if(checkDiagonal2(button)) {
			winnerButton = button.getPlayer();
			result = true;
			System.out.println("DIAGONAL WINNER is " + button.getPlayer());
		}
		return result;
	}
	
	
	
	static int returnWinner(Vbutton button) {
		if(checkWinner(button)) {
			winnerButton = button.getPlayer();
		}
		return winnerButton;
		
	}

	
	public static int makeMove(Vbutton button) {
		int result = 0;
		if (isValidMove(button)){
			if (!button.getPlayerTurn()) {
				playerTurns++;
				button.setPlayerTurn(true);
				if (playerTurns % 2 == 0) {
					button.setPlayer(1);
					setPieceInBoard(button);
					setInMainStack(button);
					checkWinner(button);
					//player1Stack(button.getRow(), button.getColumn());
					int numberOfRow = button.getRow()-1;
					if(numberOfRow >= 0) {
						matrix.get(numberOfRow).get(button.getColumn()).setIsValid(true);
					} 
					result = 1;
				} else {
					button.setPlayer(2);
					setPieceInBoard(button);
					setInMainStack(button);
					checkWinner(button);
					//player2Stack(button.getRow(), button.getColumn());
					int numberOfRow = button.getRow()-1;
					if(numberOfRow >= 0) {
						matrix.get(numberOfRow).get(button.getColumn()).setIsValid(true); 
					} 
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

	
	// don't need these two functions anymore
	
	// stack that stores first player's move
//	public static void player1Stack(int row, int column) {
//		player1Move = new Coordinate(row, column);
//		movesPlayer1.push(player1Move);
//		System.out.println("player1move coordinate: " + player1Move);
//	}
		
	
	// stack that stores second player's move
//	public static void player2Stack(int row, int column) {
//		player2Move = new Coordinate(row, column);
//		movesPlayer2.push(player2Move);
//	}
	
		
	public static boolean isValidMove(Vbutton button) {
		if(matrix.get(button.getRow()).get(button.getColumn()).getIsValid()){
			return true;
		} else {
			return false;
		}		
	}
	
//	public static Coordinate winnerResult() {
//		Coordinate popedMove = null;
//		if (moves.isEmpty()) {
//			throw new NullPointerException("No more items left to reverse!");
//		} else {
//			popedMove = moves.pop();
//		}
//		System.out.println("Winner coordinate: " + playerMoveForWinner);
//
//		return popedMove;
//}
	
	public static Coordinate reverseMove() {
		Coordinate popedMove = null;
		if (moves.isEmpty()) {
			throw new NullPointerException("No more items left to reverse!");
		} else {
			popedMove = moves.pop();
			System.out.println(popedMove.x + ", " + popedMove.y);
			Vbutton buttonToReverse = matrix.get(popedMove.x).get(popedMove.y);
			// is the vertical axis, y is horizontal axis
			if (popedMove.x >= 1) {
				Vbutton buttonAboveRev = matrix.get((popedMove.x) -1).get(popedMove.y);
				buttonAboveRev.setIsValid(false);
			}
			buttonToReverse.setIsValid(true);
			playerTurns--;
		}
		return popedMove;
	}
	
//	public static Vbutton getPrevMove() {
//		Coordinate prevInStack = null;
//		if (moves.isEmpty()) {
//			throw new NullPointerException("No more items left to reverse!");
//		} else {
//			prevInStack = moves.peek();
//			prevButton = matrix.get(prevInStack.x).get(prevInStack.y);
//		}
//		return prevButton;
//	}
	

}
