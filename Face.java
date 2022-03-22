import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class Face extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage ps) {
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 1000, 700);
		scene.setFill(Color.CRIMSON);
		
		Ellipse el = new Ellipse(500,200,100,140);
		el.setFill(Color.RED);
		el.setStroke(Color.BLACK);
		
		Arc smile = new Arc(500,200,80,70,240,60);
		
		Arc out = new Arc(480,200,80,100,120,70);
		out.setFill(Color.BLACK);
		out.setType(ArcType.ROUND);
		
		Arc arc = new Arc(480,200,60,80,150,30);
		arc.setType(ArcType.ROUND);
		arc.setFill(Color.WHITE);
		arc.setStroke(Color.BLACK);
		
		Arc out1 = new Arc(520,200,80,100,350,70);
		out1.setFill(Color.BLACK);
		out1.setType(ArcType.ROUND);
		
		Arc arc1 = new Arc(520,200,60,80,0,30);
		arc1.setType(ArcType.ROUND);
		arc1.setStroke(Color.BLACK);
		arc1.setFill(Color.WHITE);
		
		Rectangle rec = new Rectangle(480, 320, 40, 40);
		rec.setStroke(Color.BLACK);
		rec.setFill(Color.BLACK);
		
		Rectangle rec1 = new Rectangle(450, 360, 100, 100);
		rec1.setStroke(Color.BLACK);
		rec1.setFill(Color.RED);
		
		Rectangle rec2 = new Rectangle(460, 460, 30, 70);
		rec2.setStroke(Color.BLACK);
		rec2.setFill(Color.RED);
		Rectangle foot = new Rectangle(460,510,30,20);
		foot.setFill(Color.BLACK);
		foot.setStroke(Color.BLACK);
		
		Rectangle rec3 = new Rectangle(510, 460, 30, 70);
		rec3.setStroke(Color.BLACK);
		rec3.setFill(Color.RED);
		Rectangle foot1 = new Rectangle(510,510,30,20);
		foot1.setFill(Color.BLACK);
		foot1.setStroke(Color.BLACK);
		
		Rectangle rec4 = new Rectangle(370,360,80,25);
		rec4.setFill(Color.RED);
		rec4.setStroke(Color.BLACK);
		Rectangle hand = new Rectangle(370,360,20,25);
		hand.setFill(Color.BLACK);
		hand.setStroke(Color.BLACK);
		
		Rectangle spart = new Rectangle(350,350,20,45);
		spart.setFill(Color.DARKSLATEGREY);
		spart.setStroke(Color.BLACK);
		pane.getChildren().add(spart);
		
		Polyline sword = new Polyline();
		sword.getPoints().addAll(new Double[] {
			350.0,360.0,200.0,360.0,250.0,400.0,350.0,380.0
		});
		sword.setFill(Color.SILVER);
		sword.setStroke(Color.BLACK);
		sword.setStrokeWidth(3);
		pane.getChildren().add(sword);
		
		Line sline = new Line(250,375,350,375);
		pane.getChildren().add(sline);
		sline.setStrokeWidth(3);
		
		Rectangle rec5 = new Rectangle(550,360,80,25);
		rec5.setStroke(Color.BLACK);
		rec5.setFill(Color.RED);
		Rectangle hand1 = new Rectangle(610,360,20,25);
		hand1.setFill(Color.BLACK);
		hand1.setStroke(Color.BLACK);
		
		Rectangle belt = new Rectangle(450,440,100,20);
		
		Text text = new Text(375,600,"DEADPOOL");
		text.setStyle("-fx-font: 50 Halvetic");
		
		pane.getChildren().add(rec);
		pane.getChildren().add(el);
		pane.getChildren().add(smile);
		pane.getChildren().add(out1);
		pane.getChildren().add(out);
		pane.getChildren().add(arc);
		pane.getChildren().add(arc1);
		pane.getChildren().add(rec1);
		pane.getChildren().add(belt);
		pane.getChildren().add(rec2);
		pane.getChildren().add(rec3);
		pane.getChildren().add(rec4);
		pane.getChildren().add(rec5);
		pane.getChildren().add(hand);
		pane.getChildren().add(hand1);
		pane.getChildren().add(foot1);
		pane.getChildren().add(foot);
		pane.getChildren().add(text);
		
		ps.setTitle("Deadpool Face");
		
		ps.setScene(scene);
		
		ps.show();
	}
}
