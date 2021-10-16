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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFXTemplate extends Application {


	ListView<String> displayPlayer = new ListView<String>(observableList);
	static ObservableList<String> observableList = FXCollections.observableArrayList();
	HashMap<String, Scene> sceneMap;
	Stage window;
	private GridPane grid = new GridPane();
	private Button sceneChangeBtn, anotherGameB, exitB;
	private GameButton gameButton, prevButton;
	private Text text;
	private Menu mOne, mTwo, mThree;
	private MenuBar menu;
	private MenuItem start, exit, reverse, original, tOne, tTwo, how;
	private EventHandler<ActionEvent> buttonHandler;
	private EventHandler<ActionEvent> reverseMoveHandler;
	private int playerTurns = 1;
	private Vbutton buttons;


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
		GameLogic.makeBoard();

		sceneChangeBtn.setOnAction(e -> primaryStage.setScene(sceneMap.get("game")));
		// testing Result scene( supposed to be happen when a player wins or the game is
		// tie) ****
		original.setOnAction(e -> primaryStage.setScene(sceneMap.get("result")));
		sceneMap.get("game").getRoot().setStyle("-fx-font-family: 'serif'");
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
		for (int col = 0; col < 7; col++) {
			for (int row = 0; row < 6; row++) {
				gameButton = new GameButton(row, col, 0, false, false);
				if (row == 5) {
					gameButton.isValid = true;
				}
				gameButton.setPrefWidth(200);
				gameButton.setPrefHeight(100);
				gameButton.setOnAction(buttonHandler);

				gameButton.setStyle("-fx-font-size: 50;" + "-fx-background-color:yellow;" + "-fx-border-color: black;"
						+ "-fx-text-fill:red;");
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
						gameButton.setDisable(true);
						displayPlayer.getItems().clear();
						gameButton.setStyle("-fx-background-color: Blue");
						displayPlayer.getItems()
							.add("Player " + buttons.getPlayer() + " pressed " + buttons.getRow() + ", " + buttons.getColumn() + ". Valid move.");
					}
					if (result==2) {
						gameButton.setDisable(true);
						gameButton.setStyle("-fx-background-color: Red");
						displayPlayer.getItems().clear();
						displayPlayer.getItems()
							.add("Player " + buttons.getPlayer() + " pressed " + buttons.getRow() + ", " + buttons.getColumn() + ". Valid move.");
					}
					if(result == 3) {
						gameButton.setDisable(false);
						displayPlayer.getItems().clear();
						displayPlayer.getItems().add("Player " + buttons.getPlayer() + " moved to " + buttons.getRow() + ", " + buttons.getColumn()
								+ ". This is NOT a valid move. Player " + buttons.getPlayer() + " pick again.");
					}
//					System.out.println("Result: " + result);
//					
//					if(GameLogic.doNotMakeMove(buttons)) {
//						gameButton.setDisable(false);
//						displayPlayer.getItems().clear();
//						displayPlayer.getItems().add("???Player " + gameButton.player + " moved to " + gameButton.row + ", " + gameButton.column
//								+ ". This is NOT a valid move. Player " + gameButton.player + " pick again.");
//					}
					
//				
//				if(GameLogic.makeMove(buttons)==0) {
//					gameButton.setDisable(false);
//
//					displayPlayer.getItems().clear();
//					displayPlayer.getItems().add("why here? Player " + gameButton.player + " moved to " + gameButton.row + ", " + gameButton.column
//							+ ". This is NOT a valid move. Player " + gameButton.player + " pick again.");				}
				
			}
			
		};
//				if (GameLogic.isValidMove(gameButton.isValid, gameButton.column, gameButton.row)) {
//					if (!gameButton.playerTurn) {
//						playerTurns++;
//						gameButton.playerTurn = true;
//						if (playerTurns % 2 == 0) {
//							gameButton.player = 1;
//							//GameLogic.setInMainStack(gameButton.row, gameButton.column);
//							GameLogic.player1Stack(gameButton.row, gameButton.column);
//							prevButton = enableButton(gameButton.isValid, gameButton.row-1, gameButton.column, grid);
//							prevButton.setDisable(false);
//							gameButton.setStyle("-fx-background-color: Blue");
//						} else {
//							gameButton.player = 2;
//							//GameLogic.setInMainStack(gameButton.row, gameButton.column);
//							GameLogic.player2Stack(gameButton.row, gameButton.column);
//							gameButton.setStyle("-fx-background-color: Red");
//							prevButton = enableButton(gameButton.isValid, gameButton.row-1, gameButton.column, grid);
//							prevButton.setDisable(false);
//						}
//					}
//					gameButton.setDisable(true);
//					displayPlayer.getItems().clear();
//					displayPlayer.getItems()
//							.add("Player " + gameButton.player + " pressed " + gameButton.row + ", " + gameButton.column + ". Valid move.");
//				} else if (!GameLogic.isValidMove(gameButton.isValid, gameButton.column, gameButton.row)) {
//					if (playerTurns % 2 == 0) {
//						gameButton.player = 2;
//					} else {
//						gameButton.player = 1;
//
//					}
//					gameButton.setDisable(false);
//					displayPlayer.getItems().clear();
//					displayPlayer.getItems().add("Player " + gameButton.player + " moved to " + gameButton.row + ", " + gameButton.column
//							+ ". This is NOT a valid move. Player " + gameButton.player + " pick again.");
//				}
				
				

				
		displayPlayer.setMaxHeight(150);
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

		
		reverseMoveHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Coordinate coord = GameLogic.reverseMove();
				GameButton revButton = getButtonByCoordinates(coord.x, coord.y, grid);
				displayPlayer.getItems().clear();
				displayPlayer.getItems().add("Player " + revButton.player + " pressed " 
				+ revButton.row + ", " + revButton.column + ". Valid move.");
				revButton.setStyle("-fx-font-size: 50;" 
					+ "-fx-background-color:yellow;" 
					+ "-fx-border-color: black;"
					+ "-fx-text-fill:red;");
				revButton.setDisable(false);
				
			}
			
		};

		start.setOnAction(e -> {
			displayPlayer.getItems().clear();
			for (int i = 0; i < 3; i++) {
				grid.getChildren().clear();
			}
			fillGrid(grid);
		});


		reverse.setOnAction(reverseMoveHandler);
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
		exitB = new Button("Exit Game");
		exitB.setOnAction(e -> Platform.exit());
		HBox root = new HBox(anotherGameB, exitB);
		borderPane.setCenter(root);

		Scene scene = new Scene(borderPane, 1000, 800);
		scene.getRoot().setStyle("-fx-font-family: 'serif'");
		return scene;
	}

}
