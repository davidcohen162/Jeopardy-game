import javafx.application.*; 
import Questions.*;

import javafx.stage.*; 
import javafx.scene.*; 
import javafx.scene.layout.*; 
import javafx.scene.control.*;
public class Main extends Application {    
	public static void main(String[] args)    {        
		launch(args);    
		}
			Label clbl;//The category label
			Label qlbl;//The question label
			Label plbl;//The player name label
			Label mlbl;//The money amount label;
			Button btn;//The center select button  
			Category c=new Category();
			Question q=new Question(null);
		@Override public void start(Stage primaryStage)    {
			//Create the labels
			clbl=new Label();//The category label
			qlbl=new Label();//The question label
			plbl=new Label();//The player name label
			mlbl=new Label();//The money amount label;
			
			
			clbl.setText("ID:"+c.getId()+"Title:"+c.getTitle());//Displays category
			qlbl.setText("Question 1 :"+q+ " Clue: " + q.getCLUE());//Displays the question number, question, and clue
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
		Scene scene2 = new Scene(pane, 400, 250);//The numbers set the size
        // Finalize and show the stage        
		primaryStage.setScene(scene2);        
		primaryStage.setTitle("The Jeopardy game");        
		primaryStage.show();   
}        //The clicking method to lead to the choice combo box, runs in a loop
		public void buttonClick()    { 
			for(int i=0;i<100;i++){
				if (btn.getText() == "Select!")        {  
					
					ChoicesBox.show("Choose an answer", "Choices");//Showing the combo box
					if(q.isAnsweredCorrectly()){
						buttonClick();
						}
						else {
							System.exit(0);
						}
					}
				else  {          
					btn.setText("Select!"); 
					}
				}
		}        
		
	}
