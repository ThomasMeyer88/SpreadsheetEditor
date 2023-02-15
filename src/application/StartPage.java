package application;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StartPage {
	public GridPane grid;
	public Stage stage;
	
	
	public StartPage(GridPane grid, Stage stage) {
		super();
		this.grid = grid;
		this.stage = stage;
	}


	public void init() {	
		Text scenetitle = new Text("Create New File or Select Spreadsheet");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
		Button btn = new Button("Save File");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 1);
		
		Button btn1 = new Button("Select File");
		HBox hbBtn1 = new HBox(10);
		hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn1.getChildren().add(btn1);
		grid.add(hbBtn1, 1, 2);
		
		final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 4);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event)
            {
//              File file = FileSave.simpleSave(primaryStage);
        	  grid.getChildren().removeAll(grid.getChildren());
        	  File file = FileSave.initSave(stage);
        	  
	          StartPageHelper spH = new StartPageHelper(grid, stage, file);

              spH.defineColumns(stage, file, grid, 1, 1);
              Label pathLabel = new Label ("File saved to: " + file.getAbsolutePath());
              grid.add(pathLabel, 1, 2);

//      		  addClientButton(grid, file, primaryStage);
            }
        });
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event)
            {
              File file = FileSave.simpleSelect(stage);
	          Label pathLabel = new Label ("File selected: " + file.getAbsolutePath());
	          grid.add(pathLabel, 1, 5);
	          
	          StartPageHelper spH = new StartPageHelper(grid, stage, file);
      		  spH.addClientButton(stage, file, grid);
            }
        });
	}
	
}
