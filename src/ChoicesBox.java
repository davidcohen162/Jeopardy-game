import Questions.Question;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class ChoicesBox  {    
	public static void show(String message, String title)     { 
		Question q = new Question(null);//Creating an object of imported question class
		Stage stage = new Stage();   //Setting the stage   
		stage.initModality(Modality.APPLICATION_MODAL);        
		stage.setTitle(title);   //The title parameter     
		stage.setMinWidth(250);//The minimum width
		ComboBox cbox=new ComboBox();//Setting the combo box
		cbox.setVisibleRowCount(4);//Setting the visible limit to 4
		cbox.getItems().addAll(q.getCLUE());//Adding clues to combobox
		cbox.setValue(q.getCLUE());//Specify default value
		
		    VBox pane = new VBox(20);  //Pane to place the cbox in    
			pane.getChildren().addAll(cbox); //Adding combobox to pane       
			pane.setAlignment(Pos.CENTER); //Setting combobox in center
		    Scene scene = new Scene(pane);     //Adding pane to scene    
			stage.setScene(scene);       //Adding scene to stage 	
			stage.showAndWait();     } //Showing in window
	


}
