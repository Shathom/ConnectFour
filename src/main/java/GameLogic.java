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
	//public static Stack<Coordinate> movesPlayer1 = new Stack<Coordinate>();
	//public static Stack<Coordinate> movesPlayer2 = new Stack<Coordinate>();
	public static Vbutton button, prevButton;
	public static int playerTurns = 1;
	
	
	static ArrayList<ArrayList<Vbutton>> matrix = new ArrayList<ArrayList<Vbutton>>();
	
	public static Coordinate move;
	
	public static void makeBoard() {
		matrix = new ArrayList<ArrayList<Vbutton>>();
		for(int row = 0; row < 6; row++) {
			ArrayList<Vbutton> matrixRow = new ArrayList<Vbutton>();
			for(int col = 0; col < 7; col++) {
				button = new Vbutton(row, col, 0, false, false);
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
		Vbutton checking = matrix.get(button.getRow()).get(button.getColumn());
		checking.setRow(button.getRow());
		checking.setColumn(button.getColumn());
		checking.setPlayer(button.getPlayer());
		checking.setIsValid(button.getIsValid());
		checking.setPlayerTurn(button.getPlayerTurn());
	}
	
	static boolean checkHorizontal(Vbutton button) {
		
//		for(int i = 0; i < matrix.size(); i++) {
//			for(int j  = 0; j < matrix.get(i).size(); j++)
//				System.out.print(matrix.get(i).get(j).getPlayer() + " ");
//				System.out.println();			
//		}		
		int counter = 0;
		boolean isWinner = false;
//		System.out.println("the size of the row: " + matrix.size());
//		System.out.println("the size of the column(clicked): " + button.getColumn());
//		System.out.println(button.getPlayer());
		int buttonPlayer = button.getPlayer();
		
		
//		if(button.getPlayer() ==1) {
//		for(int row = 0; row < matrix.size(); row++) {

			for(int col = 0; col < 7; col++) {
				Vbutton matrixbutton = matrix.get(button.getRow()).get(col);
//				System.out.println("player: " + matrix.get(button.getRow()).get(col).getPlayer());
				if(matrixbutton.getPlayer() == buttonPlayer) {
					counter++;
				    System.out.print("horizontal count: "+counter+ "\n");
				    		//" row: " + button.getRow() + "column: " + button.getColumn() + "\n");

				} else {
					counter = 0;
				}
				if(counter == 4) {
					isWinner = true;
				} 
			}
				
//				System.out.println("the size of column: " + matrix.get(row).size());

//				if (button.getPlayer() == 1) {
//					if (button.getRow() <= matrix.get(row).size()) {
				
//					if(matrix.get(button.getRow()).get(button.getColumn()).getPlayerTurn()) {
					//***** / we need to check whether the +1 button is pressed or not // *****
//						if((button.getColumn()+1) - button.getColumn() == 1) {
//							counter++;
//							if (counter == 4) {
//					    	isWinner = true;
//							}
//						} else {
//							counter = 0;
//						}
//					}
//					}
//					System.out.println("horizontal winner" + row + " " + bt);
//				    System.out.print("horizontal count++: "+counter + " row: " + button.getRow() + "column: " + button.getColumn() + "\n");
//				}
//			}
//		}
		
////		for(int row = 0; row < matrix.size(); row++) {
//			for(int bt = button.getColumn(); bt >= 0; bt--) {
////				if (button.getPlayer() == matrix.get(row).get(bt).getPlayer()) {
//				if (button.getPlayer() == 2) {
//					if (button.getRow() - (button.getRow() - 1) == 1) {
//						if (counter == 4) {
//					    	isWinner = true;
//					    }
//					    counter++;
//					} else {
//						counter = 0;
//					}
////					System.out.println("horizontal winner" + row + " " + bt);
//				    System.out.print("horizontal count--: "+counter + " row: " + button.getRow() + "column: " + button.getColumn() + "\n");
//				}
//			}
//		}
////		}
		
		return isWinner;
	}
	
	static boolean checkVertical(Vbutton button) {
		int counter = 0;
		boolean isWinner = false;
		int buttonPlayer = button.getPlayer();

		for (int row = 0; row < matrix.size(); row++) {
			Vbutton matrixbutton = matrix.get(row).get(button.getColumn());
			if(matrixbutton.getPlayer() == buttonPlayer) {
				counter++;
			    System.out.print("vertical count++: "+counter + "\n");

			} else {
				counter = 0;
			}
			
			if(counter == 4) {
				isWinner = true;
			}			
		}		
		
		return isWinner;
	}
	
	
	static boolean checkDiagonal1(Vbutton button) {
		int counter = 0;
		boolean isWinner = false;
		int buttonPlayer = button.getPlayer();
//		for(int row = buttonRow+1; row < 6; row++) {
//				for(int col = buttonColum-1; col >= 0; col--) {
		int buttonRow = button.getRow()+1;
		int buttonColum = button.getColumn()-1;
//		System.out.println("buttonRow: " + buttonRow);
//		System.out.println("buttonCol: " + buttonColum);
		for(int i = 0; i < 4; i++) {
//			if(button.getRow() == 5 && button.getRow() == 4 && button.getRow() == 3) {
//				break;
//			}
//			if(button.getColumn() ==0 && button.getColumn() == 1 && button.getColumn() == 2) {
//				break;
//			}
			
			if(buttonRow < 5 && buttonColum > 0) {
			Vbutton matrixbuttonColumn = matrix.get(buttonRow).get(buttonColum); // getting the col from the "grid"
//			if(button.getRow() == 5 && button.getRow() == 4 && button.getRow() == 3) {
//				break;
//			}
//			if(button.getColumn() ==0 && button.getColumn() == 1 && button.getColumn() == 2) {
//				break;
//			}
			if(matrixbuttonColumn.getPlayer() == buttonPlayer) {
				buttonRow++;
				buttonColum--;
				counter++;
				System.out.print("DIAGONAL count--: "+counter + " row: " + button.getRow() + "column: " + button.getColumn() + "\n");	

				if (counter == 4) {
					isWinner = true;
//					System.out.println("DIAGONAL" + butto + " " + col);
					return true;
				} 
			}
			}
			else {
				break;
			}
//					
					
	}
		buttonRow = button.getRow();
		buttonColum = button.getColumn();
		buttonRow = button.getRow()-1;
		buttonColum = button.getColumn()+1;
		for(int i = 0; i < 4; i++) {
			
//			Vbutton matrixbuttonColumn = matrix.get(buttonRow).get(buttonColum); // getting the col from the "grid"
//					if(matrixbuttonColumn.getPlayer() == buttonPlayer) {
//						buttonRow++;
//						buttonColum--;
//						counter++;
//							if (counter == 4) {
//								isWinner = true;
//								return true;
//							} 
//					}
//					else {
//						break;
//					}
////					System.out.println("DIAGONAL" + butto + " " + col);
//					System.out.print("DIAGONAL count--: "+counter + " row: " + button.getRow() + "column: " + button.getColumn() + "\n");	

	}
		
//		for(int row = buttonRow-1; row >= 0; row--) {
//			if(buttonRow == 0) {
//				System.out.println("row is 0");
//				return false;
//			}
//
//				for(int col = buttonColum+1; col < 7; col++) {
//					Vbutton matrixbuttonColumn = matrix.get(row).get(col); // getting the col from the "grid"
//					if(matrixbuttonColumn.getPlayer() == buttonPlayer) {
//						counter++;
//							if (counter == 4) {
//								isWinner = true;
//							} 
//					System.out.println("DIAGONAL" + row + " " + col);
//					System.out.print("DIAGONAL count--: "+counter + " row: " + button.getRow() + "column: " + button.getColumn() + "\n");
//					
//					} else {
//						break;
//					}
//				}
//			
//		}
		
		return isWinner;

	}
	static boolean checkDiagonal2(Vbutton button) {
		
	 return false;
	}

			
	
	
	
	static boolean checkWinner(Vbutton button) {
		boolean result = false;
//		if (checkHorizontal(button) && checkVertical(button) /* &&  diagonal */) {
//			result = true;
//			System.out.println("winner is " + button.getPlayer());
//		}
		
		if (checkHorizontal(button)) {
			result = true;
			System.out.println("Horizontal WINNER is " + button.getPlayer());
		}
		else if(checkVertical(button)) {
			result = true;
			System.out.println("Vertical WINNER is " + button.getPlayer());
		} else if(checkDiagonal1(button)) {
			result = true;
			System.out.println("DIAGONAL WINNER is " + button.getPlayer());
		} else if(checkDiagonal2(button)) {
			result = true;
			System.out.println("DIAGONAL WINNER is " + button.getPlayer());
		}
		return result;
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
