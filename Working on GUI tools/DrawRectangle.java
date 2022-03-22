import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.input.*;
import javafx.event.ActionEvent;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;

public class DrawRectangle extends Application{
	Rectangle rec1;Rectangle rec2;
	
	TextField x1;TextField y1;
	TextField width1;TextField height1;
	
	TextField x2;TextField y2;
	TextField width2;TextField height2;

	Pane pane;
	GridPane gpane;
	
	double x1value;double y1value;
	double h1value;double w1value;
	
	double x2value;double y2value;
	double h2value;double w2value;
	
	String ans;
	Text text;
	
	Button button;
	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage ps){
		pane = new Pane();
		gpane = new GridPane(); 
		Scene scene = new Scene(pane,600,600);
		
		
		// All the TextFields needed
		x1 = new TextField("100");y1 = new TextField("100");
		width1 = new TextField("300");height1 = new TextField("150");
		
		x2 = new TextField("200");y2 = new TextField("250");
		width2 = new TextField("200");height2 = new TextField("100");
		
		//Adding all the text field to a VBox
		VBox rec1Value = new VBox();
		rec1Value.getChildren().addAll(x1,y1,width1,height1);
		
		VBox rec2Value = new VBox();
		rec2Value.getChildren().addAll(x2,y2,width2,height2);
		
		VBox rec1Label = getLabels();
		VBox rec2Label = getLabels();
		
		
		//Adding all the VBoxes to the GridPane for the final output
		gpane.add(rec1Label, 0, 0);
		gpane.add(rec1Value, 1, 0);
		gpane.add(rec2Label, 2, 0);
		gpane.add(rec2Value, 3, 0);
		gpane.setHgap(20);
		
		gpane.setLayoutX(25);
		gpane.setLayoutY(450);
		gpane.setStyle("-fx-border: 4px ;"+"-fx-border-color: black;");
		gpane.setPadding(new Insets(10,10,10,10));
		
		
		//The draw button for drawing the rectangles
		button = new Button("Draw");
		button.setOnMouseClicked(e->{
			drawRectangles();
		});
		button.setLayoutX(200);
		button.setLayoutY(400);
		button.setMinWidth(200);
		
		// Initialising the rectangles with initial values
		rec1 = new Rectangle(x1value-(w1value/2),y1value-(h1value/2),w1value,h1value);
		rec2 = new Rectangle(x2value-(w2value/2),y2value-(h2value/2),w2value,h2value);
		rec1.setFill(Color.TRANSPARENT);rec1.setStroke(Color.BLACK);
		rec2.setFill(Color.TRANSPARENT);rec2.setStroke(Color.BLACK);
		
		// Checking if they intersect and giving appropriate text output
		if(doesIntersect()) {
			ans = "Yes";
		}else ans = "No";
		text = new Text(150,50,"Two rectangles Intersect? "+ans);
		text.setStyle("-fx-font-size: 20px;");
		
		pane.getChildren().addAll(text,rec1,rec2,gpane,button);
		
		// Setting up the dragging method when mouse is clicked and moved
		rec1.setOnMouseDragged(e->{
			rec1.setOnMouseMoved(new MouseMoved());
		});
		rec2.setOnMouseDragged(e->{
			rec2.setOnMouseMoved(new MouseMoved());
		});
		
		ps.setScene(scene);
		ps.show();
	}
	
	// The method for drawing the rectangles
	public void drawRectangles() {
		pane.getChildren().removeAll(rec1,rec2,text);
		
		x1value = Double.parseDouble(x1.getText());y1value = Double.parseDouble(y1.getText());
		h1value = Double.parseDouble(height1.getText());w1value = Double.parseDouble(width1.getText());
		
		x2value = Double.parseDouble(x2.getText());y2value = Double.parseDouble(y2.getText());
		h2value = Double.parseDouble(height2.getText());w2value = Double.parseDouble(width2.getText());
		
		rec1.setX(x1value-(w1value/2));rec1.setY(y1value-(h1value/2));
		rec1.setWidth(w1value);rec1.setHeight(h1value);
		
		rec2.setX(x2value-(w2value/2));rec2.setY(y2value-(h2value/2));
		rec2.setWidth(w2value);rec2.setHeight(h2value);
		
		if(doesIntersect()) {
			ans = "Yes";
		}else ans = "No";
		text.setText("Two rectangles Intersect? "+ans);
		
		pane.getChildren().addAll(rec1,rec2,text);
		
	}
	
	// The method that returns the VBox for labels
	public VBox getLabels() {
		Text tx1 = new Text("X: ");
		Text ty1 = new Text("Y: ");
		Text tw1 = new Text("Width: ");
		Text th1 = new Text("Height: ");
		
		VBox rec1Label = new VBox(13);
		rec1Label.getChildren().addAll(tx1,ty1,tw1,th1);
		
		return rec1Label;
	}
	
	// The method for verification of intersection
	public boolean doesIntersect() {
		boolean indicator = true;
		if(rec1.getX()+rec1.getWidth()<rec2.getX()||rec1.getX()>rec2.getX()+rec2.getWidth()||
				rec1.getY()+rec1.getHeight()<rec2.getY()||rec1.getY()>rec2.getY()+rec2.getHeight()) {
			indicator = false;
		}
		return indicator;
	}
	
	// The class for handling the occuring MouseEvents
	class MouseMoved implements EventHandler<MouseEvent>{
		public void handle(MouseEvent e) {
			if(e.getSource()==rec1) {
				x1.setText(e.getSceneX()+"");
				y1.setText(e.getSceneY()+"");
				drawRectangles();
			}else if(e.getSource()==rec2) {
				x2.setText(e.getSceneX()+"");
				y2.setText(e.getSceneY()+"");
				drawRectangles();
			}
		}
	}
}
