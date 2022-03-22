import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;

public class FourFans extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage ps) {
		
		Pane gpane = new Pane();
		
		for(int a = 0;a<2;a++) {
			//this loop makes the two circles for a given row
				for(int i = 0;i<2;i++) {
					Circle circle = new Circle(100,100,100);
					circle.setFill(Color.WHITE);
					circle.setStroke(Color.BLACK);
					gpane.getChildren().add(circle);
					
					//changes center for the next circle in the same row
					circle.setCenterX(100+(2*100*i));
					
					//shifts the centers of circles to the row bellow
					if(a==1) {
						circle.setCenterY(300);
					}	
					
					//generating integers for Color class to make different colors
					double rand1 = (int)(Math.random()*256);
					double rand2 = (int)(Math.random()*256);
					double rand3 = (int)(Math.random()*256);
					
					//runs the loop four times generating 4 ROUND type arcs
					for(int k = 0;k<4;k++) {
						Arc arc = new Arc();
						arc.setCenterX(100);
						
						//changes center for the second circle in the same row
						if(i==1) {
							arc.setCenterX(300);
						}
						arc.setCenterY(100);
						
						//shifts center to the row bellow
						if(a==1) {
							arc.setCenterY(300);
						}	
						arc.setRadiusX(80);
						arc.setRadiusY(80);
						arc.setStartAngle(k*90);
						arc.setLength(45);
						arc.setFill(new Color(rand1/255.0,rand2/255.0,rand3/255.0,0.9));
						arc.setStroke(Color.BLACK);
						arc.setType(ArcType.ROUND);
						gpane.getChildren().add(arc);
					}
				}
		}
			Scene scene = new Scene(gpane);
			
			ps.setScene(scene);
			ps.setTitle("Four Fans");
			
			ps.show();
	}

}
