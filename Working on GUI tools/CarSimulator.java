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

public class CarSimulator extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage ps) {
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 1000, 500);
		
		Group car1 = getCar();
		PathTransition path1 = getTransition(car1, 150);
		path1.play();
		Group car2 = getCar();
		PathTransition path2 = getTransition(car2, 250);
		path2.play();
		Group car3 = getCar();
		PathTransition path3 = getTransition(car3, 350);
		path3.play();
		Group car4 = getCar();
		PathTransition path4 = getTransition(car4, 450);
		path4.play();
		
		Text text1 = new Text("Car 1:");
		Text text2 = new Text("Car 2:");
		Text text3 = new Text("Car 3:");
		Text text4 = new Text("Car 4:");
		TextField field1 = new TextField("1");
		TextField field2 = new TextField("1");
		TextField field3 = new TextField("1");
		TextField field4 = new TextField("1");
		
		HBox nav = new HBox();
		nav.getChildren().addAll(text1,field1,text2,field2,text3,field3,text4,field4);
		
		field1.setOnKeyReleased(e -> {
			if(field1.getText()!="" && path1.getRate()<101) {
				double rate = Double.parseDouble(field1.getText());
				path1.setRate(rate);
			}
		});
		field2.setOnKeyReleased(e -> {
			if(field2.getText()!="" && path2.getRate()<101) {
				double rate = Double.parseDouble(field2.getText());
				path2.setRate(rate);
			}
		});
		field3.setOnKeyReleased(e -> {
			if(field3.getText()!="" && path3.getRate()<101) {
				double rate = Double.parseDouble(field3.getText());
				path3.setRate(rate);
			}
		});
		field4.setOnKeyReleased(e -> {
			if(field4.getText()!="" && path4.getRate()<101) {
				double rate = Double.parseDouble(field4.getText());
				path4.setRate(rate);
			}
		});
		
		for(int i =100;i<500;i+=100) {
			Line line = new Line(0,i,1000,i);
			pane.getChildren().add(line);
		}
		
		pane.getChildren().addAll(nav,car1,car2,car3,car4);
		
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
