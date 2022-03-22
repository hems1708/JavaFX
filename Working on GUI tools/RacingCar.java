import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.scene.control.Button;

public class RacingCar extends Application{
	Boolean play = true;
	int dur = 10;
	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage ps) {
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 1000, 600);
		
		
		//All the Shapes needed for the car
		Polygon poly = new Polygon();
		poly.getPoints().addAll(new Double[]{
			0.0,475.0,50.0,425.0,75.0,375.0,175.0,375.0,200.0,425.0,300.0,425.0,
			375.0,475.0
		});
		poly.setFill(Color.AQUA);
		
		Polygon window = new Polygon();
		window.getPoints().addAll(new Double[] {
				25.0,425.0,60.0,375.0,150.0,375.0,170.0,425.0
		});
		window.setStroke(Color.BLACK);
		window.setFill(Color.WHITE);
		
		Circle tire1 = new Circle(75,475,40);
		Circle tire2 = new Circle(275,475,40);
		Circle in1 = new Circle(75,475,30);
		in1.setFill(Color.WHITE);
		Circle in2 = new Circle(275,475,30);
		in2.setFill(Color.WHITE);
		
		
		//All the transition properties
		Line line1 = new Line(0,500,1000,500); 
		PathTransition body = new PathTransition();
		body.setPath(line1);
		body.setNode(poly);
		body.setDuration(Duration.seconds(10));
		body.setCycleCount(PathTransition.INDEFINITE);
		pane.getChildren().add(poly);
		body.play();
		
		Line wline = new Line(-70,480,930,480);
		PathTransition win = new PathTransition();
		win.setNode(window);
		win.setPath(wline);
		win.setDuration(Duration.seconds(10));
		win.setCycleCount(PathTransition.INDEFINITE);
		win.play();
		
		Line pt1 = new Line(75,570,1075,570);
		PathTransition t1 = new PathTransition();
		t1.setNode(tire1);
		t1.setPath(pt1);
		t1.setDuration(Duration.seconds(10));
		t1.setCycleCount(PathTransition.INDEFINITE);
		t1.play();
		PathTransition it1 = new PathTransition();
		it1.setNode(in1);
		it1.setPath(pt1);
		it1.setDuration(Duration.seconds(10));
		it1.setCycleCount(PathTransition.INDEFINITE);
		it1.play();
		
		Line pt2 = new Line(-100,570,900,570);
		PathTransition t2 = new PathTransition();
		t2.setNode(tire2);
		t2.setPath(pt2);
		t2.setDuration(Duration.seconds(10));
		t2.setCycleCount(PathTransition.INDEFINITE);
		t2.play();
		PathTransition it2 = new PathTransition();
		it2.setNode(in2);
		it2.setPath(pt2);
		it2.setDuration(Duration.seconds(10));
		it2.setCycleCount(PathTransition.INDEFINITE);
		it2.play();
		
		//Play/Pause Button
		Button pause = new Button("Play/Pause");
		pause.setLayoutX(350);
		pause.setLayoutY(100);
		pause.setOnMouseClicked(e ->{
			if(play == true) {
				win.pause();
				body.pause();
				t1.pause();
				it1.pause();
				t2.pause();
				it2.pause();
				play = false;
				pane.setStyle("-fx-background-color: GREY");
			}else {
				win.play();
				body.play();
				t1.play();
				it1.play();
				t2.play();
				it2.play();
				play = true;
				pane.setStyle("-fx-background-color: WHITE");
			}
		});
		
		
		//Speed change buttons
		Button increase = new Button("Speed UP");
		increase.setLayoutX(700);
		increase.setLayoutY(200);
		increase.setOnMouseClicked(e ->{
			win.setRate(win.getCurrentRate()+1);
			body.setRate(body.getCurrentRate()+1);
			t1.setRate(t1.getCurrentRate()+1);
			it1.setRate(it1.getCurrentRate()+1);
			t2.setRate(t2.getCurrentRate()+1);
			it2.setRate(it2.getCurrentRate()+1);
			poly.setFill(new Color(Math.random(),Math.random(),Math.random(),1.0));
		});
		Button decrease = new Button("Speed DOWN");
		
		decrease.setLayoutX(700);
		decrease.setLayoutY(300);
		decrease.setOnMouseClicked(e ->{
			win.setRate(win.getCurrentRate()-1);
			body.setRate(body.getCurrentRate()-1);
			t1.setRate(t1.getCurrentRate()-1);
			it1.setRate(it1.getCurrentRate()-1);
			t2.setRate(t2.getCurrentRate()-1);
			it2.setRate(it2.getCurrentRate()-1);
			poly.setFill(new Color(Math.random(),Math.random(),Math.random(),1.0));
		});
		
		pane.getChildren().addAll(tire1,tire2,in1,in2,pause,increase,decrease,window);
		ps.setScene(scene);
		ps.show();
		
	}
}
