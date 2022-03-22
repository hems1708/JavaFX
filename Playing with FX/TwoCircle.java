import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class TwoCircle extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage ps) {
		Pane pane = new Pane();
		
		Scene scene = new Scene(pane, 500, 500);
		
		int randomX = (int)(Math.random()*501);
		int randomY = (int)(Math.random()*501);
		
		Circle circle = new Circle(randomX,randomY,15);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
			
		int randX = (int)(Math.random()*501);
		int randY = (int)(Math.random()*501);
		
		Circle circle1 = new Circle(randX, randY, 15);
		circle1.setFill(Color.WHITE);
		circle1.setStroke(Color.BLACK);
		
		Line line = new Line(randomX,randomY,randX,randY);
		
		double textX = (randomX+randX)/2.0;
		double textY = (randomY+randY)/2.0;
		
		String distance = (int)(Math.sqrt(Math.pow(randomX-randX,2)+Math.pow(randomY-randY,2))*1000)/1000.0+"";
		
		Text text = new Text(textX,textY,distance);
		
		pane.getChildren().add(circle);
		pane.getChildren().add(circle1);
		pane.getChildren().add(line);
		pane.getChildren().add(text);

		ps.setTitle("Two Circles");
		
		ps.setScene(scene);
		
		ps.show();
	}

}
