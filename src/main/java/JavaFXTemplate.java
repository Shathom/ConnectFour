// * Project02 *//
// JavaFXTemplate.java
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

import java.util.HashMap;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFXTemplate extends Application {


	ListView<String> displayPlayer = new ListView<String>(observableList);
	static ObservableList<String> observableList = FXCollections.observableArrayList();
	HashMap<String, Scene> sceneMap;
	Stage window;
	private GridPane grid = new GridPane();
	private Button sceneChangeBtn, anotherGameB, exitB;
	private GameButton gameButton, prevButton, resultButton;
	private Text text, text1;
	private Menu mOne, mTwo, mThree;
	private MenuBar menu;
	private MenuItem start, exit, reverse, original, tOne, tTwo, how;
	private EventHandler<ActionEvent> buttonHandler, reverseMovehandler, gameSceneEventhandler;
	private int playerTurns = 0;
	private Vbutton buttons;
	Stage primaryStage;
	
	PauseTransition pauseForWinner = new PauseTransition(Duration.seconds(3));
	PauseTransition pauseForTie = new PauseTransition(Duration.seconds(1)); // needs to be 3-5seco - for the sake of time for testing

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Connect 4");
		Image appIcon = new Image("04e3f399f686e98a363c7cb5036ed0ae.png");
		primaryStage.getIcons().add(appIcon);

		sceneChangeBtn = new Button("START GAME");
		sceneChangeBtn.setStyle("-fx-font-size: 1.5em");
		sceneMap = new HashMap<String, Scene>();

		sceneMap.put("scene", welcomeScene());
		sceneMap.put("game", gameScreen());
		sceneMap.put("result", ResultScene());
		sceneMap.put("how", howScene());
		sceneMap.put("tie", tieScene());
		sceneMap.put("themeOne", themeOneScene());
		sceneMap.put("themeTwo", themeTwoScene());
		
		GameLogic.makeBoard();
		
		original.setOnAction(e -> primaryStage.setScene(sceneMap.get("game")));  // original theme
		sceneChangeBtn.setOnAction(e -> primaryStage.setScene(sceneMap.get("game")));
		pauseForWinner.setOnFinished(e-> primaryStage.setScene(sceneMap.get("result")));
		pauseForTie.setOnFinished(e-> primaryStage.setScene(sceneMap.get("tie")));
//		anotherGameB.setOnAction(e->primaryStage.setScene(sceneMap.get("game")));
		tOne.setOnAction(e-> primaryStage.setScene(sceneMap.get("themeOne")));
		tTwo.setOnAction(e-> primaryStage.setScene(sceneMap.get("themeTwo")));
		how.setOnAction((e-> primaryStage.setScene(sceneMap.get("how"))));

		// testing Result scene( supposed to be happen when a player wins or the game is
		// tie) ****
//		original.setOnAction(e -> primaryStage.setScene(sceneMap.get("result")));
		sceneMap.get("game").getRoot().setStyle("-fx-font-family: 'serif'");
		
		
		
		
		
		
		
		gameSceneEventhandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				resultButton = (GameButton)e.getSource(); 
				buttons = new Vbutton(gameButton.row, gameButton.column, gameButton.player, gameButton.isValid, gameButton.playerTurn);
				gameButton.setDisable(true);
//				anotherGameB.setOnAction(e -> primaryStage.setScene(sceneMap.get("game")));  // original theme

				System.out.println("right herere !- pause!!");
			}
		};
		
		
		
		
		
		primaryStage.setScene(sceneMap.get("scene")); // set the scene in the stage

		primaryStage.show(); // make visible to the user
	}



//	private void closeProgram() {
//		window.close();
//	}


	/*
	 * method to populate a GridPane with buttons and attach a handler to each
	 * button
	 */
	public void fillGrid(GridPane grid) {
		// try resetting the gridpane or the listview 
		for (int col = 0; col < 7; col++) {
			for (int row = 0; row < 6; row++) {
				gameButton = new GameButton(row, col, 0, false, false);
				gameButton.setMaxWidth(200);
				gameButton.setMaxHeight(200);
				gameButton.setMaxSize(200, 200);
//				gameButton.setText("0");


				if (row == 5) {
					gameButton.isValid = true;
				}

				gameButton.setOnAction(buttonHandler);

				gameButton.setStyle("-fx-font-size: 50;" + "-fx-background-color:yellow;" + "-fx-text-fill:red;");
			

				grid.add(gameButton, col, row);

			}
		}
	}

	public Scene welcomeScene() {
		// 1) your program must start with a welcome screen that is it's own JavaFX
		// scene.
		BorderPane pane = new BorderPane();
		text = new Text();
		text.setStyle("-fx-font-family: 'serif'");
		text.setFont(Font.font(null, null, null, 20));
		StackPane.setAlignment(text, Pos.TOP_CENTER);
		text.setText("Welcome to Connect Four!");
		pane.setPadding(new Insets(70));
		VBox paneCenter = new VBox(10, text, sceneChangeBtn);
		pane.setCenter(paneCenter);
		pane.setStyle("-fx-background-color:yellow;" + "-fx-font-family: 'serif'");
		return new Scene(pane, 1000, 800);
	}

	public Scene gameScreen() {
		// 2. game play screen is its own JavaFX scene. It will consist of:
		/*
		 * a) menu bar with three menus: "Game Play", "Themes" and "Options"
		 * 
		 */
		menu = new MenuBar(); // a menu bar takes menus as children
		mTwo = new Menu("Game Play");
		mThree = new Menu("Themes");
		mOne = new Menu("Options"); // a menu goes inside a menu bar

		mOne.setStyle("-fx-background-color: white;" + "fx-opacity: 0.5;" + "fx-border-width:2.0;");
		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-color: #E6E6FA;");
		VBox root = new VBox(menu);
		borderPane.setTop(root);
		start = new MenuItem("New Game");
		exit = new MenuItem("EXIT");
		reverse = new MenuItem("Reverse Move");
		original = new MenuItem("Original Theme");
		tOne = new MenuItem("Theme ONE");
		tTwo = new MenuItem("Theme TWO");
		how = new MenuItem("How to Play");

		mOne.getItems().add(how);
		mOne.getItems().add(start);
		mOne.getItems().add(exit);

		mTwo.getItems().add(reverse);

		mThree.getItems().add(original);
		mThree.getItems().add(tOne);
		mThree.getItems().add(tTwo);

		menu.getMenus().addAll(mTwo, mThree, mOne);

		exit.setOnAction(e -> Platform.exit());

		buttonHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				gameButton = (GameButton)e.getSource();
				buttons = new Vbutton(gameButton.row, gameButton.column, gameButton.player, gameButton.isValid, gameButton.playerTurn);
				int result = GameLogic.makeMove(buttons);
					
				if(result==1) {
					playerTurns++;
					System.out.println("PlayerTurns:" + playerTurns);
					gameButton.setDisable(true);
					displayPlayer.getItems().clear();
					gameButton.setStyle("-fx-background-color: Blue");
					displayPlayer.getItems()
						.add("Player " + buttons.getPlayer() + " pressed " + buttons.getRow() + ", " + buttons.getColumn() + ". Valid move.");
				
					if(GameLogic.checkWinner(buttons)) {
						gameButton.setStyle("-fx-background-color: NAVY");
//						while(GameLogic.winnerResult());
//						for(int i = 0; i < 4; i++) {
//							
//						}
						pauseForWinner.play();						
					}											
				} else if (result==2) {
					playerTurns++;
					System.out.println("PlayerTurns:" + playerTurns);
					gameButton.setDisable(true);
					gameButton.setStyle("-fx-background-color: Red");
					displayPlayer.getItems().clear();
					displayPlayer.getItems()
						.add("Player " + buttons.getPlayer() + " pressed " + buttons.getRow() + ", " + buttons.getColumn() + ". Valid move.");
					if(GameLogic.checkWinner(buttons)) {
						gameButton.setStyle("-fx-background-color: Pink");
						pauseForWinner.play();
					}	
				} else if(result == 3) {
					gameButton.setDisable(false);
					displayPlayer.getItems().clear();
					displayPlayer.getItems().add("Player " + buttons.getPlayer() + " moved to " + buttons.getRow() + ", " + buttons.getColumn()
							+ ". This is NOT a valid move. Player " + buttons.getPlayer() + " pick again.");
				}
				
				if(playerTurns == 42) {
					pauseForTie.play();
				}
				
			}
		};
		


				
		displayPlayer.setMaxHeight(150);
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setPrefWidth(400);
		grid.setPrefHeight(800);
		grid.setAlignment(Pos.CENTER);
		fillGrid(grid);
		HBox root1 = new HBox(grid);
		root1.setAlignment(Pos.CENTER);
		displayPlayer.setStyle(
				"-fx-border-size: 200;" + "-fx-border-color: pink;" + "-fx-font-size:25;" + "-fx-font-family: 'serif'");

		borderPane.setBottom(displayPlayer);
		borderPane.setCenter(root1);

		
		reverseMovehandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Coordinate coord = GameLogic.reverseMove();
				Vbutton revButton = GameLogic.matrix.get(coord.x).get(coord.y);
				revButton.setIsValid(true);
				GameButton button = getButtonByCoordinates(coord.x, coord.y, grid);
				displayPlayer.getItems().clear();
				displayPlayer.getItems().add("Player " + button.player + " pressed " 
				+ button.row + ", " + button.column + ". Valid move.");
				button.setStyle("-fx-font-size: 50;" 
					+ "-fx-background-color:yellow;" 
					+ "-fx-text-fill:red;");
			    button.setDisable(false);
				
			}
			
		};

		start.setOnAction(e -> {
			displayPlayer.getItems().clear();
			for (int i = 0; i < 3; i++) {
				grid.getChildren().clear();
			}		
			GameLogic.makeBoard();
			GameLogic.playerTurns = 1;
			fillGrid(grid);
		});


		reverse.setOnAction(reverseMovehandler);
		Scene scene = new Scene(borderPane, 1000, 800);
		scene.getRoot().setStyle("-fx-font-family: 'serif'");
		return scene;

	}

	public GameButton getButtonByCoordinates(int row, int column, GridPane grid) {
		GameButton buttonToReverse = null;
		ObservableList<Node> allButtons = grid.getChildren();
		for (Node node: allButtons) {
			if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
				buttonToReverse = (GameButton)node;
				break;
			}
		}
		return buttonToReverse;
	}
	
	public GameButton enableButton(boolean isValid, int row, int column, GridPane grid) {
		GameButton buttonToValid = null;
		ObservableList<Node> allButtons = grid.getChildren();
		for (Node node: allButtons) {
			if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
				buttonToValid = (GameButton)node;
				buttonToValid.isValid = true;
				break;
			}
		}
		return buttonToValid;
	}

	public Scene ResultScene() {
		BorderPane borderPane = new BorderPane();
		anotherGameB = new Button("Play Another Game");
		
		// Need to trigger this to the gameScene() - new start game

//		anotherGameB.setOnAction(e-> ResultScene(sceneMap.get("game")));
		anotherGameB.setOnAction(gameSceneEventhandler);

		
		
		anotherGameB.setMaxWidth(400);
		anotherGameB.setMaxHeight(400);

		exitB = new Button("Exit Game");
		exitB.setMaxWidth(400);
		exitB.setMaxHeight(400);
		exitB.setOnAction(e -> Platform.exit());
		HBox root = new HBox(anotherGameB, exitB);
		borderPane.setCenter(root);

		
		Scene scene = new Scene(borderPane, 1000, 800);
		scene.getRoot().setStyle("-fx-font-family: 'serif'");
		return scene;
	}
	
	private Scene tieScene() {
		BorderPane borderPane = new BorderPane();
		anotherGameB = new Button("Play Another Game");
		
		
		anotherGameB.setOnAction(gameSceneEventhandler);
		
		
		exitB = new Button("Exit Game");
		exitB.setOnAction(e -> Platform.exit());
		HBox root = new HBox(anotherGameB, exitB);
		borderPane.setCenter(root);		
		
		Scene scene = new Scene(borderPane, 1000, 1000);
		scene.getRoot().setStyle("-fx-font-family: 'serif'");		
		return scene;
	}
	
	private Scene howScene() {
		BorderPane borderPane = new BorderPane();
		
		
		anotherGameB = new Button("Play Game");

		anotherGameB.setMaxHeight(500);
		
		// Need to trigger this to the gameScene() - new start game
		anotherGameB.setOnAction(gameSceneEventhandler);
//		anotherGameB.setOnAction(e-> primaryStage.setScene(sceneMap.get("game")));

		
		
		
		
		exitB = new Button("Exit Game");

		exitB.setMaxWidth(500);
		exitB.setMaxHeight(500);
		exitB.setOnAction(e -> Platform.exit());
		
		
		text = new Text();
		text.setStyle("-fx-background-color:PALEVIOLETRED "+"-fx-font-family: 'serif'");
		text.setFont(Font.font(null, null, null, 20));
		StackPane.setAlignment(text, Pos.TOP_CENTER);
		text.setText("Welcome to  Four!\n"
				+ "1. Choose who wants to go first.\n"
			 	+ "2. Players must connect 4 of the same colored in a horizontal,vertical, diagonal to win.\n"
			 	+ "3. Only one player at a time.\n"
			 	+ "4. Only the valid move will be working, if not valid move, the player can try again.\n"
			 	+ "5. Winner will be highlighted and you can start game again if you wish to.\n");
		text.setStyle("-fx-background-color: hotpink ;" + "-fx-font-family: 'serif'");
		text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

		HBox root = new HBox(anotherGameB, exitB);

		borderPane.setCenter(text);
		borderPane.setTop(root);		
		
		Scene scene = new Scene(borderPane, 1000, 800);
		scene.getRoot().setStyle("-fx-background-color: hotpink ;" + "-fx-font-family: 'serif'");		
		return scene;
	}
	
	
	
	
	
	//  Testing purposes - needs to be changed to the gameScene() and the style changes
	private Scene themeTwoScene() {
		BorderPane borderPane = new BorderPane();
		anotherGameB = new Button("Play Another ");
//		anotherGameB.setOnAction(e-> primaryStage.setScene(sceneMap.get("game")));

		exitB = new Button("Exit Game");
		exitB.setOnAction(e -> Platform.exit());
		HBox root = new HBox(anotherGameB, exitB);
		borderPane.setCenter(root);		
		
		Scene scene = new Scene(borderPane, 1000, 800);
		scene.getRoot().setStyle("-fx-font-family: 'serif'");		
		return scene;	
		
	}
	
	//  Testing purposes - needs to be changed to the gameScene() - and the style changes
	private Scene themeOneScene() {
		BorderPane borderPane = new BorderPane();
		anotherGameB = new Button("Play Another Game");
//		anotherGameB.setOnAction(e-> primaryStage.setScene(sceneMap.get("game")));

		exitB = new Button("Exit Game");
		exitB.setOnAction(e -> Platform.exit());
		HBox root = new HBox(anotherGameB, exitB);
		borderPane.setCenter(root);		
		
		Scene scene = new Scene(borderPane, 1000, 800);
		scene.getRoot().setStyle("-fx-font-family: 'serif'");		
		return scene;
		
		
	}
	
	

}
