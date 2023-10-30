package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		
		Row row1= sheet.createRow(0);
		Cell cell1 = row1.createCell(1);
		cell1.setCellValue("TC_Name");
		
		
		FileOutputStream fes = new FileOutputStream("./src/test/resources/Book1.xlsx");
		book.write(fes);
		System.out.println("data entered in excel");
		book.close();
		

	}

}
