import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.*;

public class Car extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage ps) {
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 1000, 200);
		
		Group car1 = getCar();
		PathTransition path1 = getTransition(car1, 150);
		path1.play();
		
		Text text1 = new Text("Car 1:");
		TextField field1 = new TextField("1");
		
		HBox nav = new HBox();
		nav.getChildren().addAll(text1,field1);
		
		field1.setOnKeyReleased(e -> {
			if(field1.getText()!="" && path1.getRate()<101) {
				double rate = Double.parseDouble(field1.getText());
				path1.setRate(rate);
			}
		});
		
		pane.getChildren().addAll(nav,car1);
		
		ps.setScene(scene);
		ps.show();
	}
	
	public Group getCar() {
		Polygon carBody = new Polygon();
		carBody.getPoints().addAll(new Double[]{
			0.0,80.0,0.0,50.0,20.0,50.0,30.0,20.0,80.0,20.0,90.0,50.0,150.0,50.0,150.0,80.0
		});
		
		carBody.setFill(new Color(Math.random(),Math.random(),Math.random(),Math.random()));
		carBody.setStroke(Color.BLACK
				);
		
		Circle tire1 = new Circle(35,80,15);
		Circle tire2 = new Circle(100,80,15);
		
		Group car = new Group();
		car.getChildren().addAll(carBody,tire1,tire2);
		
		
		
		return car;
	}
	
	public PathTransition getTransition(Group car,double xCoordinate) {
		Line bodyLine = new Line(0,xCoordinate,1000,xCoordinate);
		PathTransition tcarBody =  new PathTransition();
		tcarBody.setNode(car);
		tcarBody.setDuration(Duration.seconds(10));
		tcarBody.setPath(bodyLine);
		tcarBody.setCycleCount(Transition.INDEFINITE);
		
		return tcarBody;
	}
	
	class SetSpeed implements EventHandler<KeyEvent>{
		public void handle(KeyEvent e) {
			
		}
	}
	
}
