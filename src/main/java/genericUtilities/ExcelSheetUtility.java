package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This file is used to read data from excel sheet
 * @author Namrata
 *
 */
public class ExcelSheetUtility {
	/**
	 * 
	 * @param SheetName
	 * @param rownum
	 * @param cellno
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelSheet(String SheetName,int rownum,int cellno) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		String value = workbook.getSheet(SheetName).getRow(rownum).getCell(cellno).getStringCellValue();
		return value;
	}
	/**
	 * This method will read multiple data from excel sheet at a time 
	 * used for data providers
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object readMultipleData(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		Object[][]data=new Object[lastRow][lastCell];
		for (int i=0;i<lastRow;i++) 
		{
			for (int j=0;j<lastCell;j++) 
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
			
		}
		return data;
	}
	

}
