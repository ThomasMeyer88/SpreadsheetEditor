package application;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class GridHelper {

	public static void deleteHBox(GridPane grid, HBox btn) {
		  grid.getChildren().remove(grid.getChildren().indexOf(btn));
	}
	
	public static void createHBox(GridPane grid, Label label, TextField tf, int col, int row) {
		HBox hb = new HBox();
		hb.getChildren().addAll(label, tf);
		hb.setSpacing(10);	
		grid.add(hb, col, row);
	}
	
	public static ArrayList<TextField> getTextFields(GridPane grid) {
		 ArrayList<TextField> textFields = new ArrayList<TextField>();
 		 ObservableList<Node> fields = grid.getChildren();
 		 fields.forEach(node -> {
 			 try {
 				 HBox hb = (HBox) node;
 				 hb.getChildren().forEach(x -> {
 					 try {
 						 TextField tf = (TextField) x;
 						 textFields.add(tf);
 					 } catch (Exception e) {
 						  
 					 }
 				 });
 			  } catch (Exception e) {
 				  
 			  }
 		 });
 		return textFields;
	}
	
	public static ArrayList<String> getTextData(GridPane grid) {
		ArrayList<TextField> tfArr = GridHelper.getTextFields(grid);
		ArrayList<String> strArr = new ArrayList<String>();
		  tfArr.forEach(tf -> {
		  strArr.add(tf.getText());
		});
		return strArr;
	}
}
