/*Nuh Mohamud
 * 
 * Sevens
------------
Sevens extends Application
+score : int
+currentNum : int
+nums : ArrayList<Integer>
+savedGame : File
+loadGame : Load
+scoreLabel : Label
+currentNumberLabel : Label
+nextNumsLabel : Label
-------------------------------------
+main(args: String[])
+start(primaryStage : Stage)
+operatorPressed(s : String) : void
+setLabels() : void
+loadButtonPressed() : void
+setButtons(s : String, n : double) : Button

//class
Rand
----------------
-n : Random
-nums : ArrayList<Integer>
------------------
+Rand()
+newRand(): int
+newGame(): ArrayList<Integer> 
+getList(): ArrayList<Integer>

//class
SaveGame
--------------------
-savedGames: File
---------------------
+SaveGame(fileName: String, savedGames: File)
+saved(score: int, currentNumber: int, currentList: ArrayList<Integer>) : boolean
+getFile(): File

//class
Load
---------------
-fileName: String
-score: int
-currentNum: int
-numbers: ArrayList<Integer>
-----------------------
+Load(savedGames : File)
+Loaded() : Boolean
+getScore: int
+getCurrentNum: int
+getList: ArrayList<Integer>
 * 
 */

import java.util.*;
import java.io.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Sevens extends Application{
	public int score = 0;
	public int currentNum = 2;
	public Rand r = new Rand();
	public ArrayList<Integer> nums = r.newGame();
	public File savedGame = new File("savedGame.txt");//This File Must Be included to run
	public SaveGame save = new SaveGame(savedGame);
	public Load loadGame = new Load(save.getFile());
	public Label scoreLabel = new Label("Score: 0");
	public Label currentNumberLabel = new Label("2");
	//Turns the array into a nice label with only the numbers
	public Label nextNumsLabel = new Label(nums.toString().substring(1, nums.toString().length()-1));

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		//Initializing objects
		StackPane pane = new StackPane();
		pane.setPrefSize(500, 500);
		Label welcome = new Label("Hello");
		Button newGame = new Button("New Game");
		Button loadGame = new Button("Load Game");
		Button quit = new Button("Save & Quit");
		HBox box = new HBox();
		//Image file, Must Be included to run
		Image gif = new Image("loading.gif");
		ImageView imv = new ImageView(gif);
		imv.opacityProperty().setValue(0.9);
		imv.setFitWidth(400);
		imv.setFitHeight(200);
		//List of numbers Label
		nextNumsLabel.setFont(Font.font("Arial", 22));
		nextNumsLabel.setPrefSize(100, 40);
		nextNumsLabel.setTextFill(Color.CORNFLOWERBLUE);
		//Operator Buttons
		Button divide = setButtons("/", 55);
		Button multiply = setButtons("x", 40);
		Button add = setButtons("+", 55);
		Button sub = setButtons("-", 75);
		//Score Label
		scoreLabel.setFont(Font.font("Arial", 15));
		scoreLabel.relocate(210, 30);
		scoreLabel.setTextFill(Color.WHITE);
		//Giant number label
		currentNumberLabel.setFont(Font.font("Arial", 80));
		currentNumberLabel.setTextFill(Color.CRIMSON);
		//quit Button
		quit.setFont(Font.font("Arial", 15));
		quit.setPrefSize(109, 30);
		quit.setTextFill(Color.CRIMSON);
		quit.setBackground(null);
		//Welcome Font
		welcome.setTextFill(Color.CRIMSON);
		welcome.setFont(Font.font("Arial", 25));
		//Main New Game Button
		newGame.setFont(Font.font("Arial", 25));
		newGame.setTextFill(Color.PALETURQUOISE);
		newGame.setBackground(null);
		newGame.setOnAction(new EventHandler <ActionEvent>(){
			@Override
			public void handle(ActionEvent pressed) {
				pane.getChildren().removeAll(box, welcome, imv);
				pane.getChildren().addAll(currentNumberLabel, scoreLabel, nextNumsLabel, quit, add, sub, divide, multiply);
				StackPane.setAlignment(currentNumberLabel,Pos.CENTER);
				StackPane.setAlignment(scoreLabel, Pos.TOP_CENTER);
				StackPane.setAlignment(quit, Pos.BOTTOM_LEFT);
				StackPane.setAlignment(add, Pos.TOP_CENTER);
				StackPane.setAlignment(sub, Pos.BOTTOM_CENTER);
				StackPane.setAlignment(divide, Pos.CENTER_RIGHT);
				StackPane.setAlignment(multiply, Pos.CENTER_LEFT);
				StackPane.setAlignment(nextNumsLabel, Pos.TOP_RIGHT);
			}
		});
		//Main Load Button
		loadGame.setFont(Font.font("Arial", 25));
		loadGame.setTextFill(Color.PALETURQUOISE);
		loadGame.setBackground(null);
		loadGame.setOnAction(new EventHandler <ActionEvent>(){
			@Override
			public void handle(ActionEvent pressed2) {
				pane.getChildren().removeAll(box, welcome, imv);
				//loads game and updates labels
				loadButtonPressed();
				pane.getChildren().addAll(currentNumberLabel, scoreLabel, nextNumsLabel, quit, add, sub, divide, multiply);
				StackPane.setAlignment(currentNumberLabel,Pos.CENTER);
				StackPane.setAlignment(scoreLabel, Pos.TOP_CENTER);
				StackPane.setAlignment(quit, Pos.BOTTOM_LEFT);
				StackPane.setAlignment(add, Pos.TOP_CENTER);
				StackPane.setAlignment(sub, Pos.BOTTOM_CENTER);
				StackPane.setAlignment(divide, Pos.CENTER_RIGHT);
				StackPane.setAlignment(multiply, Pos.CENTER_LEFT);
				StackPane.setAlignment(nextNumsLabel, Pos.TOP_RIGHT);
			}
		});
		//Quit Button
		quit.setOnAction(new EventHandler <ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				save.saved(score, currentNum, nums);
				System.exit(0);

			}

		});
		//Operator Events
		divide.setOnAction(new EventHandler <ActionEvent>(){
			@Override
			public void handle(ActionEvent pressed){
				operatorPressed("/");
			}
		});
		multiply.setOnAction(new EventHandler <ActionEvent>(){
			@Override
			public void handle(ActionEvent pressed){
				operatorPressed("*");
			}
		});
		add.setOnAction(new EventHandler <ActionEvent>(){
			@Override
			public void handle(ActionEvent pressed){
				operatorPressed("+");
			}
		});
		sub.setOnAction(new EventHandler <ActionEvent>(){
			@Override
			public void handle(ActionEvent pressed){
				operatorPressed("-");
			}
		});

		//Scene Alignment and Positioning
		box.setAlignment(Pos.CENTER);
		box.setSpacing(30);
		box.getChildren().addAll(newGame, loadGame);
		StackPane.setAlignment(box, Pos.CENTER);
		StackPane.setAlignment(welcome, Pos.TOP_CENTER);
		StackPane.setAlignment(imv, Pos.BOTTOM_CENTER);
		pane.getChildren().addAll(box, welcome, imv);
		pane.setBackground(null);
		Scene scene = new Scene(pane, 100, 50, Color.BLACK);
		primaryStage.opacityProperty().setValue(0.85);
		primaryStage.setTitle("Sevens");
		primaryStage.setScene(scene);
		primaryStage.setX(400);
		primaryStage.setY(100);
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);
		primaryStage.show(); 
	}

	public void operatorPressed(String s){
		switch (s){
		case "*":
			this.currentNum *= this.nums.get(0);
			this.nums.remove(0);
			this.nums.add(r.newRand());
			score = (this.currentNum == 7) ? score += 1 : score; //If the currentNum is seven the score will rise by 1
			setLabels();
			break;
		case "+":
			this.currentNum += this.nums.get(0);
			this.nums.remove(0);
			this.nums.add(r.newRand());
			score = (this.currentNum == 7) ? score+=1 : score; 
			setLabels();
			break;
		case "/":
			this.currentNum /= this.nums.get(0);
			this.nums.remove(0);
			this.nums.add(r.newRand());
			score = (this.currentNum == 7) ? score+=1 : score; 
			setLabels();
			break;
		case "-":
			this.currentNum -= this.nums.get(0);
			this.nums.remove(0);
			this.nums.add(r.newRand());
			score = (this.currentNum == 7) ? score+=1 : score; 
			setLabels();
			break;
		default:
			System.out.println(":/");
		}
	}

	public void setLabels(){
		currentNumberLabel.setText(currentNum+"");
		scoreLabel.setText("Score: " + score);
		nextNumsLabel.setText(nums.toString().substring(1, nums.toString().length()-1));
	}
	public void loadButtonPressed() {
		if(loadGame.loaded()){
			this.score = loadGame.getScore();
			this.currentNum = loadGame.getCurrentNum();
			this.nums = loadGame.getNums();
			setLabels();
		}
	}
	//This function returns a new button with specified options 
	public Button setButtons(String s, double n){
		Button b = new Button(s);
		Font f = new Font("Arial", n);
		b.setFont(f);
		b.setBackground(null);
		b.setTextFill(Color.WHITE);
		return b;
	}
}


class Rand{
	private Random n;
	private ArrayList<Integer> numList;
	public Rand(){
		this.n = new Random();
		this.numList = new ArrayList<Integer>();
	}
	public int newRand(){
		return n.nextInt(9) + 1;
	}
	public ArrayList<Integer> newGame(){ //generates a new game with four random numbers in the list
		this.numList = new ArrayList<Integer>(Arrays.asList(newRand(),newRand(), newRand(), newRand()));
		return this.numList;
	}
	public ArrayList<Integer> getList(){
		return this.numList;
	}
}


class SaveGame{
	private File savedGame;

	public SaveGame(File savedGame){
		this.savedGame = savedGame;
	}

	public boolean saved(int score, int currentNum, ArrayList<Integer> currentList){ //true if the game  saved successfully 
		PrintWriter write; 
		try{
			//OverWrites File
			//Saves game in a reliable pattern
			write = new PrintWriter(savedGame);
			write.print(score + " " + currentNum + " ");
			write.print(currentList.get(0) + " " + currentList.get(1) +" "+ currentList.get(2) + " " + currentList.get(3));
			write.close();
			return true;
		}catch(IOException e){
			System.out.println("Could Not Save" + e.getMessage());
			return false;
		}
	}

	public File getFile(){
		return savedGame; 
	}
}
class Load{
	private File savedGames;
	private int score;
	private int currentNum;
	private ArrayList<Integer> numbers = new ArrayList<Integer>();

	public Load(File savedGames){
		this.savedGames = savedGames;
	}

	public boolean loaded(){
		boolean scoreSaved = false;
		boolean currentNumSaved = false;
		Scanner read;
		try{
			read = new Scanner(savedGames);
			while(!scoreSaved && !currentNumSaved){
				this.score = read.nextInt();
				scoreSaved = true;
				this.currentNum = read.nextInt();
				currentNumSaved = true;
			}
			while(read.hasNextInt()){
				this.numbers.add(read.nextInt());
			}
			read.close();
			return true;
		}catch(Exception e){
			System.out.println("No saved Game, Program will just start a new game");
			return false;
		}
	}

	//getter methods
	public int getScore(){
		return this.score;
	}
	public int getCurrentNum(){
		return this.currentNum;
	}
	public ArrayList<Integer> getNums(){
		return this.numbers;
	}
}



















