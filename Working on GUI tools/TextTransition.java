import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.animation.PathTransition;
import javafx.util.Duration;

public class TextTransition extends Application{
	public static void main(String[] args){
		launch(args);
	}
	public void start(Stage ps) {
		Pane pane = new Pane();
		Scene scene = new Scene(pane,1000,500);
		Text text = new Text("COSC1047 20W");
		text.setStyle("-fx-font-weight: bold;");
		text.setStyle("-fx-font-size: 30;");
		text.setStrokeWidth(2);
		text.setStroke(new Color(Math.random(),Math.random(),Math.random(),1.0));
		
		
		Line pline = new Line(0,250,1000,250);
		
		PathTransition path = new PathTransition();
		path.setNode(text);
		path.setPath(pline);
		path.setDuration(Duration.seconds(5));
		path.setCycleCount(PathTransition.INDEFINITE);
		pane.getChildren().addAll(text);
		path.play();
		
		scene.setOnMousePressed(e ->{
			path.pause();
		});
		
		scene.setOnMouseReleased(e ->{
			path.play();
			text.setStroke(new Color(Math.random(),Math.random(),Math.random(),1.0));
			if(text.getText()=="COSC1047 20W") {
				text.setText("Patel Hemesh");
			}else text.setText("COSC1047 20W");
		});
		
		ps.setScene(scene);
		ps.show();
	}
}
