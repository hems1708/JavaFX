import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class FutureValue extends Application implements EventHandler<ActionEvent>{
	Button calc;
	TextField amountF;
	TextField yearsF;
	TextField rateF;
	TextField answerF;
	
	public static void main(String[] args) {
		launch(args);
	
	}
	
	@Override
	public void start(Stage ps) {
		
		//All the labels and textFields
		Label amount = new Label(" Amount: ");
		Label years = new Label(" Number Of Years: ");
		Label rate = new Label(" Annual Interest Rate: ");
		Label answer = new Label(" Future Value: ");
		
		amountF = new TextField();
		amount.setLabelFor(amountF);
		yearsF = new TextField();
		years.setLabelFor(yearsF);
		rateF = new TextField();
		rate.setLabelFor(rateF);
		answerF = new TextField();
		answer.setLabelFor(answerF);
		
		calc = new Button("Calculate");
		calc.setOnAction(this);
		
		
		//Created and populated a GridPane with labels and TextFields for layout
		GridPane pane = new GridPane();
		pane.setHgap(20);
		pane.setVgap(20);
		pane.add(amount,0,0);
		pane.add(years, 0, 1);
		pane.add(rate, 0, 2);
		pane.add(amountF, 1, 0);
		pane.add(yearsF, 1, 1);
		pane.add(rateF, 1, 2);
		pane.add(answer, 0, 3);
		pane.add(answerF, 1, 3);
		pane.add(calc, 1, 4);
		
		Scene scene = new Scene(pane, 400, 250);
		ps.setTitle("Calculate Future Value");
		ps.setScene(scene);
		ps.show();
		
	}
	
	//The method for handling ActionEvents for the button Calculate
	@Override
	public void handle(ActionEvent e) {
		if(e.getSource()==calc) {
			amountF.getText();
			yearsF.getText();
			rateF.getText();
			double ans = Double.parseDouble(amountF.getText());
			for(int i = 0; i<Integer.parseInt(yearsF.getText());i++){
				ans += Double.parseDouble(rateF.getText())*ans/100.0;
			}
			answerF.setText("$"+(int)(ans*100)/100.0);
		}
	}
	
}
