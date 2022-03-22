import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;

public class HangMan extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage ps) {
		Pane pane = new Pane();
		
		Scene scene = new Scene(pane,1000,500);
		scene.setFill(Color.ALICEBLUE);
		
		//all the rectangle nodes for the pillar and bases
		Rectangle rec = new Rectangle(100,50,50,400);
		rec.setFill(Color.RED);
		Rectangle rec1 = new Rectangle(0,450,250,50);
		rec1.setFill(Color.RED);
		pane.getChildren().add(rec);
		pane.getChildren().add(rec1);
		Rectangle pil2 = new Rectangle(850,50,50,400);
		pil2.setFill(Color.RED);
		pane.getChildren().add(pil2);
		Rectangle base2 = new Rectangle(750,450,250,50);
		base2.setFill(Color.RED);
		pane.getChildren().add(base2);
		
		//making lines for the pattern on the pillars and adding them to the pane
		for(int i = 852; i<900;i+=10) {
			Line line = new Line(i,50,i,450);
			line.setStroke(Color.TURQUOISE);
			line.setStrokeWidth(4);
			pane.getChildren().add(line);
		}
		for(int i = 752; i<1000;i+=10) {
			Line line = new Line(i,450,i,500);
			line.setStroke(Color.TURQUOISE);
			line.setStrokeWidth(4);
			pane.getChildren().add(line);
		}
		for(int i = 102; i<150;i+=10){
			Line line = new Line(i,50,i,450);
			line.setStrokeWidth(4);
			line.setStroke(Color.TURQUOISE);
			pane.getChildren().add(line);
		}
		
		for(int i = 2; i<250;i+=10) {
			Line line = new Line(i,450,i,500);
			line.setStroke(Color.TURQUOISE);
			line.setStrokeWidth(4);
			pane.getChildren().add(line);
		}
		
		
		int y = 50;
		for(int x = 150; x<400;x+=8) {
			Rectangle rectangle = new Rectangle(x,y,10,8);
			rectangle.setFill(Color.ALICEBLUE);
			rectangle.setStroke(Color.DARKSLATEGREY);
			pane.getChildren().add(rectangle);
			y+=4;
		}
		
		int y2 = 50;
		for(int x2 = 850; x2>600;x2-=8) {
			Rectangle rectangle = new Rectangle(x2,y2,10,8);
			rectangle.setFill(Color.ALICEBLUE);
			rectangle.setStroke(Color.DARKSLATEGREY);
			pane.getChildren().add(rectangle);
			y2+=4;
		}
		
		//making and assembling rectangles into shape of body
		Rectangle hand1 = new Rectangle(406,180,20,50);
		hand1.setFill(Color.PEACHPUFF);
		Rectangle hand2 = new Rectangle(584,180,20,50);
		hand2.setFill(Color.PEACHPUFF);
		Rectangle ar1 = new Rectangle(406,230,50,20);
		ar1.setFill(Color.PEACHPUFF);
		Rectangle ar2 = new Rectangle(554,230,50,20);
		ar2.setFill(Color.PEACHPUFF);
		Rectangle body = new Rectangle(456,230,98,100);
		Rectangle face = new Rectangle(476,150,58,60);
		face.setFill(Color.PEACHPUFF);
		Rectangle leg1 = new Rectangle(466,330,20,70);
		leg1.setFill(Color.DARKBLUE);
		Rectangle leg2 = new Rectangle(526,330,20,70);
		leg2.setFill(Color.DARKBLUE);
		
		//all the nodes for the facial features
		Arc smile = new Arc(505,180,20,20,230,80);
		smile.setFill(Color.RED);
		Circle eye1 = new Circle(490,180,5);
		Circle eye2 = new Circle(520,180,5);
		Rectangle hair = new Rectangle(476,150,58,15);
		
		//all the nodes added together to make the final image
		pane.getChildren().add(hand1);
		pane.getChildren().add(hand2);
		pane.getChildren().add(ar1);
		pane.getChildren().add(ar2);
		pane.getChildren().add(body);
		pane.getChildren().add(face);
		pane.getChildren().add(leg1);
		pane.getChildren().add(leg2);
		pane.getChildren().add(smile);
		pane.getChildren().add(eye1);
		pane.getChildren().add(eye2);
		pane.getChildren().add(hair);
		
		//pattern on the shirt of the hang-man
		for(int i = 461;i<554;i+=10) {
			Line line = new Line(i,230,i,330);
			line.setStrokeWidth(10);
			line.setStroke(new Color((Math.random()*256)/255.0,(Math.random()*256)/255.0,(Math.random()*256)/255.0,0.9));
			pane.getChildren().add(line);
		}
		
		ps.setScene(scene);
		ps.setTitle("The Hang-Man");
		ps.show();
	}
}
