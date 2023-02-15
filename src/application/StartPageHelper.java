package application;

import java.io.File;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StartPageHelper {
	public GridPane grid;
	public Stage stage;
	public File file;
	
	public StartPageHelper(GridPane grid, Stage stage, File file) {
		super();
		this.grid = grid;
		this.stage = stage;
		this.file = file;
	}
	
	public void defineColumns(Stage stage, File file, GridPane grid, int col, int row) {
		returnButton(col+1, row);
		addColumnButton(1, row+2);
	}
	
	public void columnLabel(int col, int row) {
		Label nameLabel = new Label("Column Name:");
		nameLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
		nameLabel.setPrefWidth(150);
		TextField nameText = new TextField();
        nameText.setPrefWidth(300);
        GridHelper.createHBox(grid, nameLabel, nameText, col, row);
        addColumnButton(col, row+1);
	}
	
	public void addColumnButton(int col, int row) {
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
      		  columnLabel(col, row);
      	  }
        });
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
      	  @Override
      	  public void handle(ActionEvent Event) {
      		  ArrayList<String> strArr = GridHelper.getTextData(grid);
      		  Status status = FileSave.saveColumnTitles(file, stage, strArr);
//      		  if (status.status == true) {
//            		  clientForm(grid, file, stage);
//      		  } else if (status.status == false) {
//      			  errorPage(grid, status, stage);
//      		  }
      	  }
        });
	}
	
	//button for adding client information form
	public void addClientButton(Stage stage, File file, GridPane grid) {
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
	public void clientForm(GridPane grid, File file, Stage stage) {
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
	
	public void errorPage(GridPane grid, Status status, Stage stage) {
		Text scenetitle = new Text(status.getReport());
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
	    grid.add(scenetitle, 0, 0, 2, 1);
	    returnButton(1, 2);
	}
	
	public void returnButton(int col, int row) {
		Button btn = new Button("Return to Start Page");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, col, row);
		btn.setOnAction(new EventHandler<ActionEvent>() {
	      	 @Override
	      	 public void handle(ActionEvent Event) {
	      		 grid.getChildren().removeAll(grid.getChildren());
	      		 StartPage sp = new StartPage(grid, stage);
	      		 sp.init();
	      	 }
	     });
	}
}
