module Spreadsheet {
	requires javafx.controls;
	requires org.apache.poi.poi;
	requires org.apache.poi.ooxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
}
