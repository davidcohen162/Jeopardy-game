import Game.GameInRandomCategory;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class Main extends Application {    
			Label clbl;//The category label
			Label qlbl;//The question label
			Label plbl;//The player name label
			Label mlbl;//The money amount label;
	Button btn;//The center select button
			

	public static void main(String[] args) {
		launch(args);
	}

		@Override public void start(Stage primaryStage) throws IOException    {
			int questionsToAsk=10;
			GameInRandomCategory gameInRandomCategory = new GameInRandomCategory(questionsToAsk);
	        gameInRandomCategory.setUpQuestions();
			//Create the labels
			clbl=new Label();//The category label
			qlbl=new Label();//The question label
			plbl=new Label();//The player name label
			mlbl=new Label();//The money amount label;
			
			
			
			plbl.setText("Anyone");//Displays player name
			mlbl.setText("$"+89000);//Displays money amount
			
	       
	        
		//Create combo box for answers
		

		
		
		// Create the button       
		btn = new Button();        
		btn.setText("Select!");        
		btn.setOnAction(e -> buttonClick());
        	// Add the labels and button to a layout pane        
		BorderPane pane = new BorderPane();
		pane.setRight(clbl);
		pane.setLeft(qlbl);
		pane.setTop(plbl);
		pane.setCenter(btn);  
		pane.setBottom(mlbl);
		// Add the layout pane to a scene        
		Scene scene2 = new Scene(pane);//The numbers set the size
        // Finalize and show the stage        
		primaryStage.setScene(scene2);        
		primaryStage.setTitle("The Jeopardy game");        
		primaryStage.show();   
}        //The clicking method to lead to the choice combo box, runs in a loop
		public void buttonClick()    { 
			for(int i=0;i<100;i++){
				if (btn.getText() == "Select!")        {  
					//Showing the combo box
					try {
						ChoicesBox.show("Choose an answer", "Choices");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else  {          
					btn.setText("Select!"); 
					}
				
				}
		}        
		
	}
