// * Project02 *//
// ****************************************************************************/
// University of Illinois at Chicago
// Class: CS 342, FALL 2021
// Author: Haeun Kim, UIC
// Author: Sharon Thomeh
// UIN number: 657655430
// Connect Four JavaFX GUI
// Implement the classic game of Connect Four. This is a simple game to
// understand and play which should allow you to focus on learning GUI
// developmenet in JavaFx and trying your hand at event driven programming.
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class JavaFXTemplate extends Application {

	private Button b1, sceneChangeBtn, anotherGameB, exitB;
	private TextField t1;
	private MenuBar menu;
	private EventHandler<ActionEvent> myHandler;
	Stage window;
	private int counter = 0;
	HashMap<String, Scene> sceneMap;
	private Text text;
	private Menu mOne, mTwo, mThree;
	private MenuItem start, exit, reverse, original, tOne, tTwo, how;
	
	
	
	ListView<String> displayPlayer;
	
	static ObservableList<String> observableList = FXCollections.observableArrayList();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Connect 4");
		
		sceneChangeBtn = new Button("START GAME");
		sceneChangeBtn.setStyle("-fx-font-size: 1.5em");
		sceneMap = new HashMap<String, Scene>();
		
								
		sceneMap.put("scene", welcomeScene());
		sceneMap.put("game", gameScreen());
		sceneMap.put("result", ResultScene());

		sceneChangeBtn.setOnAction(e-> primaryStage.setScene(sceneMap.get("game")));
		// testing Result scene( supposed to be happen when a player wins or the game is tie) ****
		original.setOnAction(e->primaryStage.setScene(sceneMap.get("result")));
		sceneMap.get("game").getRoot().setStyle("-fx-font-family: 'serif'");
	//	sceneMap.get("scene").getRoot().setStyle("-fx-font-family: 'serif'");
		//new scene with root node
		primaryStage.setScene(sceneMap.get("scene")); //set the scene in the stage
		//primaryStage.setScene(new Scene(new VBox()));
	
		
		primaryStage.show(); //make visible to the user
	}
	
//	private void closeProgram() {
//		window.close();
//	}


	/*
	 * method to populate a GridPane with buttons and attach a handler to each button
	 */	
	public void addGrid(GridPane grid) {
		for(int x = 0; x<7; x++) {				
			for(int i = 0; i<6; i++) {
				Button b1 = new Button();				
				b1.setPrefWidth(200);
				b1.setOnAction(myHandler);
				b1.setStyle("-fx-font-size: 50;" +"-fx-background-color:yellow;" + "-fx-border-color: black;"+
							"-fx-text-fill:red;");
				grid.add(b1, x, i);				 
			}
		}
	}
	
	public Scene welcomeScene() {
		// 1) your program must start with a welcome screen that is it's own JavaFX scene.
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
		// jkjkljkjkljkl

		
		
		return new Scene(pane, 1000,800);
	}
	
	public Scene gameScreen() {
		// 2. game play screen is its own JavaFX scene. It will consist of:
		/* a) menu bar with three menus: "Game Play", "Themes" and "Options"
		 * 
		 */
		menu = new MenuBar(); //a menu bar takes menus as children
		mTwo = new Menu("Game Play"); 
		mThree = new Menu("Themes");
		mOne = new Menu("Options"); //a menu goes inside a menu bar


		mOne.setStyle("-fx-background-color: white;"+ "fx-opacity: 0.5;"+ "fx-border-width:2.0;");
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
		
		exit.setOnAction(e-> Platform.exit()); 

		
		//event handler is attached to each button in the GridPane
		myHandler = new EventHandler<ActionEvent>() {			
			public void handle(ActionEvent e) {
				System.out.println("button pressed: " + ((Button)e.getSource()).getText());
				Button b1 = (Button)e.getSource();
				b1.setPrefWidth(500);
				if(counter == 0) {
//					displayPlayer.getItems().add("1st player's turn");
//					b1.setText("X");
//					counter = 1;
				} else if (counter == 1){
//					displayPlayer.getItems().add("2nd player's turn");
//					counter = 0;
//					b1.setText("O");
				}				
				b1.setDisable(true);
			}
		};
		displayPlayer = new ListView<String>(observableList);
		GridPane grid = new GridPane();
		grid.setPrefWidth(400);
		grid.setAlignment(Pos.CENTER);
		addGrid(grid);
		HBox root1 = new HBox(grid);
		root1.setAlignment(Pos.CENTER);
		
		displayPlayer.getItems();
		displayPlayer.setStyle("-fx-border-size: 200;" + "-fx-border-color: pink;" + "-fx-font-size:25;" + "-fx-font-family: 'serif'");

		root1.getChildren().add(displayPlayer);
		borderPane.setCenter(root1);	
		
		start.setOnAction(e-> { addGrid(grid); displayPlayer.getItems().clear();
								for(int i = 0; i<3; i++) {
									grid.getChildren().clear();
									} addGrid(grid); counter = 0;});
		
		Scene scene = new Scene(borderPane, 1000, 800);
		scene.getRoot().setStyle("-fx-font-family: 'serif'");
		return scene;
		
	}
	
	public Scene ResultScene() {
		BorderPane borderPane = new BorderPane();
		anotherGameB = new Button("Play Another Game");
		exitB = new Button("Exit Game");
		exitB.setOnAction(e-> Platform.exit()); 
		HBox root = new HBox(anotherGameB, exitB);
		borderPane.setCenter(root);

		
		Scene scene = new Scene(borderPane, 1000, 800);
		scene.getRoot().setStyle("-fx-font-family: 'serif'");
	    return scene;
	}

}
