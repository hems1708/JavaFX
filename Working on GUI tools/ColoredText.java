import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.*;

public class ColoredText extends Application{
	
	double redc = 0;
	double bluec = 0;
	double greenc = 0;
	double opacityv = 1;
	
	ScrollBar red;
	ScrollBar green;
	ScrollBar blue;
	ScrollBar opacity;
	Text text;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage ps) throws Exception{
		Pane pane = new Pane();
		Scene scene = new Scene(pane,500,500);
		
		//All the scrollbar nodes for the controls
		red = new ScrollBar();
		red.setMax(1);
		red.setMin(0);
		red.setMinHeight(30);
		red.setMinWidth(200);
		
		blue = new ScrollBar();
		blue.setMax(1);
		blue.setMin(0);
		blue.setMinHeight(30);
		blue.setMinWidth(200);
		
		green = new ScrollBar();
		green.setMax(1);
		green.setMin(0);
		green.setMinHeight(30);
		green.setMinWidth(200);
		
		opacity = new ScrollBar();
		opacity.setValue(1);
		opacity.setMax(1);
		opacity.setMin(0);
		opacity.setMinHeight(30);
		opacity.setMinWidth(200);
		
		//Creating a GridPane and adding everything to it to set the layout on the scene
		GridPane prop = new GridPane();
		prop.add(red, 1, 0);
		prop.add(green, 1, 1);
		prop.add(blue, 1, 2);
		prop.add(opacity, 1, 3);
		
		prop.setVgap(20);
		
		prop.setLayoutX(125);
		prop.setLayoutY(300);
		
		text = new Text("Show Color");
		text.setFill(new Color(redc, greenc, bluec, opacityv));
		
		text.setLayoutX(65);
		text.setLayoutY(200);
		text.setStyle("-fx-font-size: 75px;"+"-fx-font-weight: bold;");
		
		Text textRed = new Text("Red: ");
		Text textGreen = new Text("Green: ");
		Text textBlue = new Text("Blue: ");
		Text textOpacity = new Text("Opacity: ");
		prop.add(textRed, 0, 0);
		prop.add(textGreen, 0, 1);
		prop.add(textBlue, 0, 2);
		prop.add(textOpacity, 0, 3);
		
		// Adding listener and the method for handling events to the TextField
		red.valueProperty().addListener(e->{
			redc = red.getValue();
			text.setFill(new Color(redc, greenc, bluec, opacityv));
		});
		blue.valueProperty().addListener(e->{
			bluec = blue.getValue();
			text.setFill(new Color(redc, greenc, bluec, opacityv));
		});
		green.valueProperty().addListener(e->{
			greenc = green.getValue();
			text.setFill(new Color(redc, greenc, bluec, opacityv));
		});
		opacity.valueProperty().addListener(e->{
				opacityv = opacity.getValue();
				text.setFill(new Color(redc, greenc, bluec, opacityv));
		});
		
		pane.getChildren().add(prop);
		pane.getChildren().add(text);
		
		ps.setScene(scene);
		ps.show();
	}
}	
