import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class StopSign extends Application{
	Polygon poly;
	Pane pane;
	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage ps) {
		pane = new Pane();
		Scene scene = new Scene(pane, 500, 500);
		ps.setScene(scene);
		
		//Making polygon and giving properties
		poly = new Polygon();
		poly.getPoints().addAll(new Double[] {
			150.0,50.0,350.0,50.0,450.0,150.0,450.0,350.0,350.0,450.0,150.0,450.0,50.0,350.0,50.0,150.0
		});
		poly.setFill(Color.RED);
		poly.setStroke(Color.BLACK);
		poly.setStrokeWidth(10);
		
		
		//The STOP text
		Text text = new Text(125, 275,"STOP");
		text.setStyle("-fx-font-size: 100px");
		text.setStroke(Color.BLACK);
		
		
		//Adding a listener to height and width property of the pane to handle events
		pane.widthProperty().addListener(e ->{
			
			
			//Clearing the current co-ordinates and giving co-ordinates relative to the Stage to resize the polygon	
			poly.getPoints().clear();
				poly.getPoints().addAll(new Double[] {
				ps.getWidth()*0.33,100.0,ps.getWidth()*0.66,100.0,ps.getWidth()-100,ps.getHeight()*0.33,
				ps.getWidth()-100,ps.getHeight()*0.66,ps.getWidth()*0.66,ps.getHeight()-100,
				ps.getWidth()*0.33,ps.getHeight()-100,
				100.0,ps.getHeight()*0.66,100.0,ps.getHeight()*0.33
			}); 
				text.setY(ps.getHeight()*0.5);
				text.setX(ps.getWidth()*0.25);
				double size = ps.getWidth()/5.0;
				text.setStyle("-fx-font-size: "+size);
		});
		pane.heightProperty().addListener(e ->{
			
			
			//Clearing the current co-ordinates and giving co-ordinates relative to the Stage to resize the polygon
			poly.getPoints().clear();
			poly.getPoints().addAll(new Double[] {
			ps.getWidth()*0.33,100.0,ps.getWidth()*0.66,100.0,ps.getWidth()-100,ps.getHeight()*0.33,
			ps.getWidth()-100,ps.getHeight()*0.66,ps.getWidth()*0.66,ps.getHeight()-100,
			ps.getWidth()*0.33,ps.getHeight()-100,
			100.0,ps.getHeight()*0.66,100.0,ps.getHeight()*0.33
		}); 
			
		text.setY(ps.getHeight()*0.5);
		text.setX(ps.getWidth()*0.33);
	});
		
		pane.getChildren().addAll(poly,text);
		ps.show();
	}
}
