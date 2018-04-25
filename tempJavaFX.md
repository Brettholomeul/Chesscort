package application;

import javafx.event.*;
import javafx.geometry.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.*;

//Chesscort Main Yeah
//Links
//Best JavaFX tutorial site https://www.tutorialspoint.com/javafx/javafx_layout_panes.htm


public class Main extends Application{
	
	Stage window;
	Scene sceneMainMenu, sceneGame, sceneEditor;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
		window = primaryStage;
		window.setTitle("Chesscort");
		
		
		//try/catch necessary for FileInputStream for images
		try {
			//this block brings in our images for buttons and shit
			FileInputStream inputStream = new FileInputStream("images" + java.io.File.separator + "logo.png");
			Image imageLogo = new Image(new FileInputStream("images" + java.io.File.separator + "logo.png"));
			inputStream = new FileInputStream("images" + java.io.File.separator + "icons" + java.io.File.separator + "undo.png");
			Image imageUndo = new Image(inputStream);
			inputStream = new FileInputStream("images" + java.io.File.separator + "icons" + java.io.File.separator + "menu.png");
			Image imageMenu = new Image(inputStream);
			inputStream = new FileInputStream("images" + java.io.File.separator + "icons" + java.io.File.separator + "return.png");
			Image imageReturn = new Image(inputStream);
			inputStream = null;
			
			/*---------------------------------------------------------
			 *  Designs for main menu screen
			 *---------------------------------------------------------*/
			
			//per javafx we set one pane as the pane that holds all other panes. the mainMenu pane.
			//border panes let us put stuff either in the top, left, right, bottom, or middle area of a window
			BorderPane mainMenu = new BorderPane();
			
			//The Top Panel
			//Contains Chesscort logo
			StackPane paneTopLogo = new StackPane();
			paneTopLogo.getChildren().add(new ImageView(imageLogo));
			mainMenu.setTop(paneTopLogo);
			//Top Panel Ends
			
			//The Bottom Panel
			//Contains menu options
			HBox paneMenuSelections = new HBox();
			paneMenuSelections.setAlignment(Pos.CENTER);
			paneMenuSelections.setSpacing(100);
			Button
				button2PGame = new Button("2PGame"), 
				buttonEditor = new Button("Level Editor"), 
				buttonOptions = new Button("Options"), 
				buttonCredits = new Button("Credits");
			paneMenuSelections.getChildren().addAll(button2PGame, buttonEditor, buttonOptions, buttonCredits);
			mainMenu.setBottom(paneMenuSelections);
			
			//The Center Panel
			//Contains launch game, launch editor, options, and credits screens
			VBox
				paneMidGame = new VBox(), 
				paneMidEditor = new VBox(), 
				paneMidOptions = new VBox(), 
				paneMidCredits = new VBox();
			paneMidGame.setSpacing(100); paneMidGame.setAlignment(Pos.CENTER);
			paneMidEditor.setSpacing(100); paneMidEditor.setAlignment(Pos.CENTER);
			paneMidOptions.setSpacing(100); paneMidOptions.setAlignment(Pos.CENTER);
			paneMidCredits.setSpacing(100); paneMidCredits.setAlignment(Pos.CENTER);
			
			Label
				labelMidGame = new Label("Launch game?"),
				labelMidEditor = new Label("Launch editor?"),
				labelMidOptions = new Label("Currently optional"),
				labelMidCredits = new Label("Did you ever hear the tragedy of Darth Plagueis The Wise? I thought not. It’s not a story the Jedi would tell you. It’s a Sith legend. Darth Plagueis was a Dark Lord of the Sith, so powerful and so wise he could use the Force to influence the midichlorians to create life… He had such a knowledge of the dark side that he could even keep the ones he cared about from dying. The dark side of the Force is a pathway to many abilities some consider to be unnatural. He became so powerful… the only thing he was afraid of was losing his power, which eventually, of course, he did. Unfortunately, he taught his apprentice everything he knew, then his apprentice killed him in his sleep. Ironic. He could save others from death, but not himself. Brett is a java god.");
			Button
				buttonLaunchGame = new Button("Launch Game"),
				buttonLaunchEditor = new Button("Launch Editor");
			
			paneMidGame.getChildren().addAll(buttonLaunchGame, labelMidGame);
			paneMidEditor.getChildren().addAll(buttonLaunchEditor, labelMidEditor);
			paneMidOptions.getChildren().addAll(labelMidOptions);
			paneMidCredits.getChildren().addAll(labelMidCredits);
			//Center Panel Ends
			
			mainMenu.setCenter(paneMidGame);
			
			//lambda expressions solve everything
			button2PGame.setOnAction(e -> mainMenu.setCenter(paneMidGame));
			buttonEditor.setOnAction(e -> mainMenu.setCenter(paneMidEditor));
			buttonOptions.setOnAction(e -> mainMenu.setCenter(paneMidOptions));
			buttonCredits.setOnAction(e -> mainMenu.setCenter(paneMidCredits));
			
			buttonLaunchGame.setOnAction(e -> window.setScene(sceneGame));
			buttonLaunchEditor.setOnAction(e -> window.setScene(sceneEditor));

			sceneMainMenu = new Scene(mainMenu, 800, 800);
			
			/*---------------------------------------------------------
			 *  Designs for game screen
			 *---------------------------------------------------------*/
			
			//The game screen
			BorderPane 
				game = new BorderPane();
			
			//Individual pieces of the screen
			HBox
				paneGameArea = new HBox(),
				paneGameUI = new HBox();
			paneGameArea.setAlignment(Pos.CENTER);
			paneGameUI.setAlignment(Pos.CENTER);
			paneGameUI.setSpacing(650);
			
			//Put pieces in game screen
			game.setCenter(paneGameArea);
			game.setBottom(paneGameUI);
			
			//UI buttons made and added to paneGameUI
			Button
				buttonGameReturn = new Button("", new ImageView(imageReturn)),
				buttonGameUndo = new Button("", new ImageView(imageUndo));
			buttonGameReturn.setOnAction(e -> window.setScene(sceneMainMenu));
			paneGameUI.getChildren().addAll(buttonGameReturn, buttonGameUndo);
			
			sceneGame = new Scene(game, 800, 800);
			
			/*---------------------------------------------------------
			 *  Designs for editor screen
			 *---------------------------------------------------------*/
			
			//The game screen
			BorderPane 
				editor = new BorderPane();
			
			//Individual pieces of the screen
			HBox
				paneEditorArea = new HBox(),
				paneEditorUI = new HBox();
			paneEditorArea.setAlignment(Pos.CENTER);
			paneEditorUI.setAlignment(Pos.CENTER);
			paneEditorUI.setSpacing(300);
			
			//Put pieces in game screen
			editor.setCenter(paneEditorArea);
			editor.setBottom(paneEditorUI);
			
			//UI buttons made and added to paneEditorUI
			Button
				buttonEditorReturn = new Button("", new ImageView(imageReturn)),
				buttonEditorUndo = new Button("", new ImageView(imageUndo)),
				buttonEditorMenu = new Button("", new ImageView(imageMenu));
			buttonEditorReturn.setOnAction(e -> window.setScene(sceneMainMenu));
			paneEditorUI.getChildren().addAll(buttonEditorReturn, buttonEditorMenu, buttonEditorUndo);
			
			sceneEditor = new Scene(editor, 800, 800);
			
			/*---------------------------------------------------------
			 *  Final launch commands
			 *---------------------------------------------------------*/
			
			window.setScene(sceneMainMenu);
			window.show();
			
			
		}catch(Exception e) {
			System.out.println("god damn it joel");
		}
		
	}

}
		
		/* old tutorital stuff for reference
		Button button3 = new Button("Button3");
		Button button4 = new Button("Button4");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		//Name label
		Label nameLabel = new Label("Username:");
		GridPane.setConstraints(nameLabel, 0, 0);
		
		//Name input
		TextField nameInput = new TextField("Bucky");
		GridPane.setConstraints(nameInput, 1, 0);
		
		//Pass label
		Label passLabel = new Label("Password:");
		GridPane.setConstraints(nameLabel, 0, 1);
		
		//Password input
		TextField passInput = new TextField();
		passInput.setPromptText("Password here");
		GridPane.setConstraints(passInput, 1, 1);
		
		Button loginButton = new Button("Log in");
		GridPane.setConstraints(loginButton, 1, 2);
		
		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);
		Scene gridScene = new Scene(grid, 300, 300);

		window.setScene(gridScene);
		window.show();
		*/
		

