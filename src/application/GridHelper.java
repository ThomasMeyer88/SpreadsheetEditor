package application;

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
}
