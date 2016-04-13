import Game.GameInRandomCategory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ChoicesBox {

	public static void show(String message, String title) throws IOException {
		
		//Creating an object of imported question class
		Stage stage = new Stage();   //Setting the stage   
		stage.initModality(Modality.APPLICATION_MODAL);        
		stage.setTitle(title);   //The title parameter     
		stage.setMinWidth(650);//The minimum width
		Label qLbl = new Label();//The question label
		Label sLbl = new Label();//The score label
		int questionsToAsk = 10;
		GameInRandomCategory gameInRandomCategory = new GameInRandomCategory(questionsToAsk);
		gameInRandomCategory.setUpQuestions();//The radio buttons
		RadioButton rb1 = new RadioButton();
		RadioButton rb2 = new RadioButton();
		RadioButton rb3 = new RadioButton();
		RadioButton rb4 = new RadioButton();
		rb1.setFont(Font.font("Verdana", 14));
		rb2.setFont(Font.font("Verdana", 14));
		rb3.setFont(Font.font("Verdana", 14));
		rb4.setFont(Font.font("Verdana", 14));

		Button btnOK = new Button("OK");      //Creating an OK button  
		btnOK.setMinWidth(75);
		btnOK.setFont(Font.font("Verdana", 14));
		Button btnStop = new Button("Quit Game");//Adding a stop button
		btnStop.setMinWidth(75);
		btnStop.setFont(Font.font("Verdana", 14));
		btnStop.setOnAction(new EventHandler<ActionEvent>() {//Assigning actions to stop button
			public void handle(ActionEvent e) {
				MessageBox.show("Game Over" + "" + "\t\tScore: " + gameInRandomCategory.getScore()
						+ " out of: " + gameInRandomCategory.getMaxScore(), "Game Over");
				System.exit(0);
			}
		});

		for (int i = 0; i < questionsToAsk; i++) {//Setting the question text and font
			qLbl.setFont(Font.font("Verdana", 14));
			qLbl.setText("Question: " + (i + 1) + " out of: " + gameInRandomCategory.getAmountOfQuestionsInGame() + ":" + gameInRandomCategory.getQuestionString(i)
			);
			//Setting the score text and font
			sLbl.setFont(Font.font("Verdana", 14));
			sLbl.setText("\t\tScore: " + gameInRandomCategory.getScore()
					+ " out of: " + gameInRandomCategory.getMaxScore());

			final ToggleGroup group = new ToggleGroup();

			rb1.setText(gameInRandomCategory.getMultipleChoiceAnswers(i).get(0));//Adding clues to combobox
			rb2.setText(gameInRandomCategory.getMultipleChoiceAnswers(i).get(1));//Adding clues to combobox
			rb3.setText(gameInRandomCategory.getMultipleChoiceAnswers(i).get(2));//Adding clues to combobox
			rb4.setText(gameInRandomCategory.getMultipleChoiceAnswers(i).get(3));//Adding clues to combobox
			rb1.setToggleGroup(group);
			rb2.setToggleGroup(group);
			rb3.setToggleGroup(group);
			rb4.setToggleGroup(group);
			rb1.setSelected(true);


			int question = i;

			btnOK.setOnAction(new EventHandler<ActionEvent>() {
								  //Setting the OK button to continue the game and get user input
								  //The OK button must be pressed or first choice in the box will be auto selected
								  public void handle(ActionEvent e) {
									  String selected = "";
									  if (rb1.isSelected()) {
										  selected = rb1.getText();
									  } else if (rb2.isSelected()) {
										  selected = rb2.getText();
									  } else if (rb3.isSelected()) {
										  selected = rb3.getText();
									  } else if (rb4.isSelected()) {
										  selected = rb4.getText();
									  }
									  gameInRandomCategory.setPlayersAnswer(question, selected);
									  if (question == 9) {
										  MessageBox.show("Final score is: " + "\t\tScore: " + gameInRandomCategory.getScore()
												  + " out of: " + gameInRandomCategory.getMaxScore(), "Final Score");
									  }
									  stage.close();
								  }

							  }
			);


			GridPane pane = new GridPane();  //Pane to place the radio buttons in
			pane.setVgap(10);
			pane.setHgap(10);
			pane.add(qLbl, 0, 1);//Question text and score
			pane.add(sLbl, 2, 1);
			pane.add(rb1, 0, 2); //Adding radio buttons to pane
			pane.add(rb2, 0, 3);
			pane.add(rb3, 0, 4);
			pane.add(rb4, 0, 5);
			pane.add(btnOK, 1, 5);//Adding the OK button
			pane.add(btnStop, 2, 5);
			pane.setAlignment(Pos.CENTER); //Setting radio buttons in center
			pane.setPadding(new Insets(10, 10, 10, 10));//Setting window chrome around contents
			Scene scene = new Scene(pane);     //Adding pane to scene
			stage.setScene(scene);       //Adding scene to stage 

			stage.showAndWait();//Showing in window

			if (gameInRandomCategory.aQuestionWasAnsweredCorrectly(i)) {
				MessageBox.show("Excelsior!", "" + (i + 1) + " out of " + gameInRandomCategory.getAmountOfQuestionsInGame());
			} else {
				MessageBox.show("Drink Coke, play again :; ", "" + (i + 1) + " out of " + gameInRandomCategory.getAmountOfQuestionsInGame());
			}
		}


	}
}
