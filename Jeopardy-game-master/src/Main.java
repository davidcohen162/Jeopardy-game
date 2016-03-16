
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class Main extends Application {    
			
	Button btn;//The center select button
			

	public static void main(String[] args) {
		launch(args);
	}

		@Override public void start(Stage primaryStage) throws IOException    {
			
		// Create the button       
		btn = new Button(); 
		btn.setFont(Font.font(20));
		btn.setText("Start!");        
		btn.setOnAction(e -> buttonClick());//Listening for a click on the start
        	// Add the labels and button to a layout pane        
		BorderPane pane = new BorderPane();
		
		
		pane.setCenter(btn);  
		
		// Add the layout pane to a scene        
		Scene scene2 = new Scene(pane);//The numbers set the size
        // Finalize and show the stage        
		primaryStage.setMinWidth(650);
		primaryStage.setScene(scene2);        
		primaryStage.setTitle("The Jeopardy game");        
		primaryStage.show();   
}        //The clicking method to lead to the choice combo box, runs in a loop
		public void buttonClick()    { 
			
				if (btn.getText() == "Start!")        {  
					//Showing the combo box
					try {
						ChoicesBox.show("Choose an answer","Choices") ;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
				}}
				else  {          
					btn.setText("Start!"); 
					}
				
				}
		}        
		

