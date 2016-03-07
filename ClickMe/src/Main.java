import javafx.application.*; 
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
}        //The clicking method to lead to the choice combo box
		public void buttonClick()    {        
		if (btn.getText() == "Select!")        {         
			MessageBox.show("Choose an answer", "Choices");//Showing the combo box
			}        
		else        {          
		btn.setText("Select!"); 
		}
	}
}