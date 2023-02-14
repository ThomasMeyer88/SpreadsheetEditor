package application;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javafx.stage.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;

public class FileSave {
	
	public static File simpleSelect(Stage primaryStage) {
		FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(primaryStage);
        return file;
	}
	
	public static Status save(File file, Client client) {
		Map<String, Object[]> clientData = new TreeMap<String, Object[]>();
		Status status = new Status();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file.getAbsolutePath()));
			XSSFSheet spreadsheet = workbook.getSheetAt(0);
			XSSFRow row;
			int rowid = spreadsheet.getPhysicalNumberOfRows();
			clientData.put("1", new Object[] { client.getName(), client.getAddress(), client.getPhone(), client.getEmail(),
					client.getContactDate(), client.getContactMethod(), client.getMailReturned(), client.getNotes(),
					client.getNextSteps(), client.getDocsReceived(), client.getClaimPacketId(), client.getClaimSubmissionDate(),
					client.getClaimStatus()});

			// writing the data into the sheets...
			
			Set<String> keyid = clientData.keySet();

			for (String key : keyid) {

				row = spreadsheet.createRow(rowid++);
				Object[] objectArr = clientData.get(key);
				int cellid = 0;

				for (Object obj : objectArr) {
					Cell cell = row.createCell(cellid++);
					cell.setCellValue((String)obj);
				}
			}
			try (FileOutputStream outputStream = new FileOutputStream(file.getAbsolutePath())) {
	            workbook.write(outputStream);
	            workbook.close();
	        }
	        catch (IOException e) {
	          e.printStackTrace();
	          status.setReport(e.toString());
	  		  status.setStatus(false);
	  		  return status;
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			status.setReport(e.toString());
	  		status.setStatus(false);
	  		return status;
		} catch (IOException e) {
			e.printStackTrace();
			status.setReport(e.toString());
	  		status.setStatus(false);
	  		return status;
		}
		status.setReport("Client Information Saved");
		status.setStatus(true);
		return status;
	}
	
	public static File simpleSave(Stage primaryStage) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet(" Client Data ");
		XSSFRow row;

		Map<String, Object[]> clientData = new TreeMap<String, Object[]>();
		clientData.put("1", new Object[] { "Name", "Address", "Phone", "E-Mail", "Contact Date", "Contact Method", "Mail Returned",
				"Notes", "Next Steps", "Documents Received", "Claim Packet ID", "Claim Submission Date", "Claim Status"});

		int rowid = 0;

		// writing the data into the sheets...
		
		Set<String> keyid = clientData.keySet();

		for (String key : keyid) {

			row = spreadsheet.createRow(rowid++);
			Object[] objectArr = clientData.get(key);
			int cellid = 0;

			for (Object obj : objectArr) {
				Cell cell = row.createCell(cellid++);
				cell.setCellValue((String)obj);
			}
		}
		return saveToFile(primaryStage, workbook);
	}

	public static File saveToFile(Stage primaryStage, XSSFWorkbook workbook) {
		 FileChooser fileChooser = new FileChooser();

         //Set extension filter to .xlsx files
         FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx");
         fileChooser.getExtensionFilters().add(extFilter);

         //Show save file dialog
         File file = fileChooser.showSaveDialog(primaryStage);

         //If file is not null, write to file using output stream.
         if (file != null) {
             try (FileOutputStream outputStream = new FileOutputStream(file.getAbsolutePath())) {
                 workbook.write(outputStream);
             }
             catch (IOException ex) {
               
             }
         }
         return file;
	}

}