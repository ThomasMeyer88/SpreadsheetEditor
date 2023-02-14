package application;
	
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

@SuppressWarnings("unused")
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("JavaFX Welcome");	        
	        primaryStage.show();
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.TOP_CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(50, 20, 20, 20));

			Scene scene = new Scene(grid, 1080, 720);
			primaryStage.setScene(scene);
			
			startPage(grid, primaryStage);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//adds details to GridPane for Start/Select of File
	//start of standard workflow
	public static void startPage(GridPane grid, Stage primaryStage) {	
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
              File file = defineColumns(grid, primaryStage, 1, 1);
              Label pathLabel = new Label ("File saved to: " + file.getAbsolutePath());
              grid.add(pathLabel, 1, 2);

//      		  addClientButton(grid, file, primaryStage);
            }
        });
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event)
            {
              File file = FileSave.simpleSelect(primaryStage);
	          Label pathLabel = new Label ("File selected: " + file.getAbsolutePath());
	          grid.add(pathLabel, 1, 5);

      		  addClientButton(grid, file, primaryStage);
            }
        });
	}
	
	public static File defineColumns(GridPane grid, Stage stage, int col, int row) {
		returnButton(grid, stage, col+1, row);
		addColumnButton(grid, 1, row+2);
		File dummy = new File("dummy");
		return dummy;
	}
	
	public static void columnLabel(GridPane grid, int col, int row) {
		Label nameLabel = new Label("Column Name:");
		nameLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
		nameLabel.setPrefWidth(150);
		TextField nameText = new TextField();
        nameText.setPrefWidth(300);
        GridHelper.createHBox(grid, nameLabel, nameText, col, row);
        addColumnButton(grid, col, row+1);
	}
	
	public static void addColumnButton(GridPane grid, int col, int row) {
		Button btn2 = new Button("Add Column");
		HBox hbBtn2 = new HBox(10);
		hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn2.getChildren().add(btn2);
		grid.add(hbBtn2, col+1, row);
		
		Button btn = new Button("Save");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, col+1, row+1);
				  
        btn2.setOnAction(new EventHandler<ActionEvent>() {
      	  @Override
      	  public void handle(ActionEvent Event) {
      		  GridHelper.deleteHBox(grid, hbBtn2);
      		  GridHelper.deleteHBox(grid, hbBtn);
      		  columnLabel(grid, col, row);
      	  }
        });
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
      	  @Override
      	  public void handle(ActionEvent Event) {
//      		  if (status.status == true) {
//            		  clientForm(grid, file, stage);
//      		  } else if (status.status == false) {
//      			  errorPage(grid, status, stage);
//      		  }
      	  }
        });
	}
	
	//button for adding client information form
	public static void addClientButton(GridPane grid, File file, Stage stage) {
		Button btn2 = new Button("Add Client Data");
		HBox hbBtn2 = new HBox(10);
		hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn2.getChildren().add(btn2);
		grid.add(hbBtn2, 1, 6);
		  
        btn2.setOnAction(new EventHandler<ActionEvent>() {
      	  @Override
      	  public void handle(ActionEvent Event) {
      		  grid.getChildren().removeAll(grid.getChildren());
      		  clientForm(grid, file, stage);
      	  }
        });
	}
	
	//page for client form
	public static void clientForm(GridPane grid, File file, Stage stage) {
		int fontSize = 15;
		int labelWidth = 200;
		Button btn = new Button("Save");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 0);
		  
		Label nameLabel = new Label("Client Name:");
		nameLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, fontSize));
		nameLabel.setPrefWidth(labelWidth);
		TextField nameText = new TextField();
        nameText.setPrefWidth(300);
        GridHelper.createHBox(grid, nameLabel, nameText, 1, 1);
		
		Label addressLabel = new Label("Address:");
		addressLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, fontSize));
		addressLabel.setPrefWidth(labelWidth);
		TextField addressText = new TextField();
        addressText.setPrefWidth(300);
        GridHelper.createHBox(grid, addressLabel, addressText, 1, 2);
        
        Label phoneLabel = new Label("Phone Number:");
		phoneLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, fontSize));
		phoneLabel.setPrefWidth(labelWidth);
		TextField phoneText = new TextField();
		phoneText.setPrefWidth(300);
		GridHelper.createHBox(grid, phoneLabel, phoneText, 1, 3);
        
        Label emailLabel = new Label("E-Mail:");
        emailLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, fontSize));
        emailLabel.setPrefWidth(labelWidth);
		TextField emailText = new TextField();
		emailText.setPrefWidth(300);
		GridHelper.createHBox(grid, emailLabel, emailText, 1, 4);
        
        Label contactDateLabel = new Label("Contact Date:");
        contactDateLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, fontSize));
        contactDateLabel.setPrefWidth(labelWidth);
		TextField contactDateText = new TextField();
		contactDateText.setPrefWidth(300);
		GridHelper.createHBox(grid, contactDateLabel, contactDateText, 1, 5);
        
        Label contactMethodLabel = new Label("Contact Method:");
        contactMethodLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, fontSize));
        contactMethodLabel.setPrefWidth(labelWidth);
		TextField contactMethodText = new TextField();
		contactMethodText.setPrefWidth(300);
		GridHelper.createHBox(grid, contactMethodLabel, contactMethodText, 1, 6);

        Label mailReturnedLabel = new Label("Mail Returned:");
        mailReturnedLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, fontSize));
        mailReturnedLabel.setPrefWidth(labelWidth);
		TextField mailReturnedText = new TextField();
		mailReturnedText.setPrefWidth(300);
		GridHelper.createHBox(grid, mailReturnedLabel, mailReturnedText, 1, 7);
        
        Label notesLabel = new Label("Notes:");
        notesLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, fontSize));
        notesLabel.setPrefWidth(labelWidth);
		TextField notesText = new TextField();
		notesText.setPrefWidth(300);
		GridHelper.createHBox(grid, notesLabel, notesText, 1, 8);
        
        Label nextStepsLabel = new Label("Next Steps:");
        nextStepsLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, fontSize));
        nextStepsLabel.setPrefWidth(labelWidth);
		TextField nextStepsText = new TextField();
		nextStepsText.setPrefWidth(300);
		GridHelper.createHBox(grid, nextStepsLabel, nextStepsText, 1, 9);
        
        Label docsReceivedLabel = new Label("Documents Received:");
        docsReceivedLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, fontSize));
        docsReceivedLabel.setPrefWidth(labelWidth);
		TextField docsReceivedText = new TextField();
		docsReceivedText.setPrefWidth(300);
		GridHelper.createHBox(grid, docsReceivedLabel, docsReceivedText, 1, 10);
        
        Label claimPacketIdLabel = new Label("Claim Packet ID:");
        claimPacketIdLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, fontSize));
        claimPacketIdLabel.setPrefWidth(labelWidth);
		TextField claimPacketText = new TextField();
		claimPacketText.setPrefWidth(300);
		GridHelper.createHBox(grid, claimPacketIdLabel, claimPacketText, 1, 11);
        
        Label claimSubmissionDateLabel = new Label("Claim Submission Date:");
        claimSubmissionDateLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, fontSize));
        claimSubmissionDateLabel.setPrefWidth(labelWidth);
		TextField claimSubmissionDateText = new TextField();
		claimSubmissionDateText.setPrefWidth(300);
		GridHelper.createHBox(grid, claimSubmissionDateLabel, claimSubmissionDateText, 1, 12);
        
        Label claimStatusLabel = new Label("Claim Status:");
        claimStatusLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, fontSize));
        claimStatusLabel.setPrefWidth(labelWidth);
		TextField claimStatusText = new TextField();
		claimStatusText.setPrefWidth(300);
		GridHelper.createHBox(grid, claimStatusLabel, claimStatusText, 1, 13);
		
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	  @Override
        	  public void handle(ActionEvent Event) {
        		  Client client = new Client(nameText.getText(), addressText.getText(), phoneText.getText(), emailText.getText(),
        				 contactDateText.getText(), contactMethodText.getText(), mailReturnedText.getText(), notesText.getText(),
        				 nextStepsText.getText(), docsReceivedText.getText(), claimPacketText.getText(),
        				 claimSubmissionDateText.getText(), claimStatusText.getText());
        		  Status status = FileSave.save(file, client);
        		  grid.getChildren().removeAll(grid.getChildren());
        		  if (status.status == true) {
              		  clientForm(grid, file, stage);
        		  } else if (status.status == false) {
        			  errorPage(grid, status, stage);
        		  }
        	  }
          });
	}
	
	public static void errorPage(GridPane grid, Status status, Stage stage) {
		Text scenetitle = new Text(status.getReport());
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
	    grid.add(scenetitle, 0, 0, 2, 1);
	    returnButton(grid, stage, 1, 2);
	}
	
	public static void returnButton(GridPane grid, Stage stage, int col, int row) {
		Button btn = new Button("Return to Start Page");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, col, row);
		btn.setOnAction(new EventHandler<ActionEvent>() {
	      	 @Override
	      	 public void handle(ActionEvent Event) {
	      		 grid.getChildren().removeAll(grid.getChildren());
	      		 startPage(grid, stage);
	      	 }
	     });
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
