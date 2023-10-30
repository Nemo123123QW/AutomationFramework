package Practice;

import java.io.IOException;

import genericUtilities.ExcelSheetUtility;
import genericUtilities.javaFileUtilities;
import genericUtilities.proprtyFileUtility;

public class GenericfileUtilities {

	public static void main(String[] args) throws IOException {
		proprtyFileUtility putil = new proprtyFileUtility();
		String URL = putil.readDatafromPropertyFile("url");
        System.out.println(URL);
 
        String BROWSER = putil.readDatafromPropertyFile("browser");
        System.out.println(BROWSER);
        String USERNAME = putil.readDatafromPropertyFile("username");
        System.out.println(USERNAME);
 
        String PASSWORD = putil.readDatafromPropertyFile("password");
        System.out.println(PASSWORD);
        
        
        ExcelSheetUtility eutil = new ExcelSheetUtility();
        String value1 = eutil.readDataFromExcelSheet("organization", 4, 3);
        System.out.println(value1);
        String value = eutil.readDataFromExcelSheet("organization", 1, 2);
        System.out.println(value);
        
        javaFileUtilities jutil = new javaFileUtilities();
       int r = jutil.getrandomnumber();
       System.out.println(r);
      String s = jutil.getSystemDate();
      System.out.println(s);
	}

}
