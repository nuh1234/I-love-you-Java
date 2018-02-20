import javafx.application.Application;
import javafx.geometry.Pos;
//Nuh Mohamud Unfinished, coudln't center the circles despite using stackpane

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
public class FinalP_6 extends Application {
	@Override 
	public void start(Stage primaryStage) {
		VBox vbox = new VBox();
		HBox hbox = new HBox();
		Circle w1 = new Circle();
		Circle w2 = new Circle();
		w1.setRadius(100);
		w1.setStroke(Color.BLACK);
		w1.setFill(null);
		w2.setRadius(100);
		w2.setStroke(Color.BLACK);
		w2.setFill(null);
		Circle g1 = newGreyCircle();
		Circle g2 = newGreyCircle();
		Circle g3 = newGreyCircle();
		vbox.getChildren().addAll(g1,g2,g3);
		hbox.getChildren().addAll(w1, vbox, w2);
		StackPane pane = new StackPane();
		pane.getChildren().add(hbox);
		StackPane.setAlignment(vbox, Pos.CENTER);
		StackPane.setAlignment(hbox, Pos.CENTER);
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setTitle("GreyBoxes");
		primaryStage.setScene(scene); 
		primaryStage.show();
	}
	
	public Circle newGreyCircle(){
		Circle c = new Circle();
		c.setRadius(100);
		c.setStroke(Color.BLACK);
		c.setFill(Color.GRAY);
		return c;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
