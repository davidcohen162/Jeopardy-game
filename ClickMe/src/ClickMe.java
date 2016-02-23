import javafx.application.*; 
import javafx.stage.*; 
import javafx.scene.*; 
import javafx.scene.layout.*; 
import javafx.scene.control.*;
public class ClickMe extends Application {    
	public static void main(String[] args)    {        
		launch(args);    
		}
			Label clbl;//The category label
			Label qlbl;//The question label
			Label plbl;//The player name label
			Label mlbl;//The money amount label;
			Button btn;        
		@Override public void start(Stage primaryStage)    {
			//Create the labels
			clbl=new Label();//The category label
			qlbl=new Label();//The question label
			plbl=new Label();//The player name label
			mlbl=new Label();//The money amount label;
			clbl.setText("Category ?");//Displays category
			qlbl.setText("Question 1");//Displays the question number
			plbl.setText("Anyone");//Displays player name
			mlbl.setText("$"+89000);//Displays money amount
		//Create combo box for answers
		ObservableList<String> options = 
		FXCollections.observableArrayList(
				        "1",
				        "2",
				        "3"
				    );

		ComboBox ans=new ComboBox();
		ans.setItems(options);
		
		// Create the button       
		btn = new Button();        
		btn.setText("Click me please!");        
		btn.setOnAction(e -> buttonClick());
        	// Add the labels and button to a layout pane        
		BorderPane pane = new BorderPane();
		pane.setRight(clbl);
		pane.setLeft(qlbl);
		pane.setTop(plbl);
		pane.setCenter(btn);  
		pane.setBottom(mlbl);
		// Add the layout pane to a scene        
		Scene scene = new Scene(pane, 400, 250);//The numbers set the size
        	// Finalize and show the stage        
		primaryStage.setScene(scene);        
		primaryStage.setTitle("The Jeopardy game");        
		primaryStage.show();    }        
		public void buttonClick()    {        
		if (btn.getText() == "Click me please!")        {         
		btn.setText("You clicked me!");        }        
		else        {          
		btn.setText("Click me please!"); 
		}
	}
}