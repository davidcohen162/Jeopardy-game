
import java.io.IOException;

import Game.GameInRandomCategory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class ChoicesBox  {  
	
	public static void show(String message, String title) throws IOException     { 
		
		//Creating an object of imported question class
		Stage stage = new Stage();   //Setting the stage   
		stage.initModality(Modality.APPLICATION_MODAL);        
		stage.setTitle(title);   //The title parameter     
		stage.setMinWidth(650);//The minimum width
		Label qlbl = new Label();//The question label
		Label slbl=new Label();
		int questionsToAsk=10;
		GameInRandomCategory gameInRandomCategory = new GameInRandomCategory(questionsToAsk);
        gameInRandomCategory.setUpQuestions();
		ComboBox<String> cbox=new ComboBox<String>();//Setting the combo box
		cbox.setValue(cbox.getValue());
		Button btnOK = new Button("OK");      //Creating an OK button  
		btnOK.setMinWidth(75);        
		btnOK.setOnAction(e -> //Setting the OK button to continue the game
				stage.close());
		 Button btnStop=new Button("Stop");//Adding a stop button
		 btnStop.setMinWidth(75);
		 btnStop.setOnAction(new EventHandler<ActionEvent>() {//Assigning actions to stop button
			    public void handle(ActionEvent e) {
			    	MessageBox.show("Game Over"+"\nScore is"+ "\t\tScore: " + gameInRandomCategory.getScore()
                    + " out of: " + gameInRandomCategory.getMaxScore(), "Game Over");
			        System.exit(0);
			    }
			});

		for(int i=0;i<questionsToAsk;i++){//Setting the question text
			qlbl.setText("Question: " + (i + 1) + " out of: " + gameInRandomCategory.getAmountOfQuestionsInGame() +":"+gameInRandomCategory.getQuestionString(i)
                   );
			slbl.setText( "\t\tScore: " + gameInRandomCategory.getScore()
                    + " out of: " + gameInRandomCategory.getMaxScore());
			cbox.setPromptText(gameInRandomCategory.getMultipleChoiceAnswers(i).get(0));

            
		 		for (int j = 0; j < gameInRandomCategory.getMultipleChoiceAnswers(i).size(); j++) {
		 			
			 		cbox.getItems().add(gameInRandomCategory.getMultipleChoiceAnswers(i).get(j));//Adding clues to combobox
		
		 		}
		 		
		 		String input=cbox.getValue();
		 		int choiceIndex=0;
		 		for(int h=0;h<gameInRandomCategory.getMultipleChoiceAnswers(i).size();h++){
		 			if((gameInRandomCategory.getMultipleChoiceAnswers(i).get(h).equals(input))){
		 				choiceIndex=h;
		 				break;
		 			}
		 		}
		 		gameInRandomCategory.setPlayersAnswer(i, gameInRandomCategory.getMultipleChoiceAnswers(i).get(choiceIndex));
		 		
		 		
		    GridPane pane = new GridPane();  //Pane to place the cbox in 
		    pane.setVgap(10);
	        pane.setHgap(10);
	        pane.add(qlbl, 0, 1);//Question text and score
	        pane.add(slbl, 1, 1);
	        pane.add(cbox,0,2); //Adding combobox to pane
	        pane.add(btnOK,1, 2);//Adding the OK button
	        pane.add(btnStop, 2, 2);
			pane.setAlignment(Pos.CENTER); //Setting combobox in center
			pane.setPadding(new Insets(10,10,10,10));
		    Scene scene = new Scene(pane);     //Adding pane to scene    
			stage.setScene(scene);       //Adding scene to stage 	
			stage.showAndWait();//Showing in window
			
			if (gameInRandomCategory.aQuestionWasAnsweredCorrectly(i)) {
	 			
                MessageBox.show("Excelsior!", ""+(i+1)+" out of " + gameInRandomCategory.getAmountOfQuestionsInGame());
            } else {
            	MessageBox.show("Drink Coke, play again :; ", ""+(i+1)+" out of " + gameInRandomCategory.getAmountOfQuestionsInGame());
            }
			cbox.getItems().clear(); } //Clearing the combo box array
	


}}
