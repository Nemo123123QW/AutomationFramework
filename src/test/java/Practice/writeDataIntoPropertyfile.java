package Practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class writeDataIntoPropertyfile {

	public static void main(String[] args) throws IOException {
		Properties pro = new Properties();
		pro.put("username","Namrataadmin");
		pro.put("password", "xyz");
		FileOutputStream file=new FileOutputStream(".\\src\\test\\resources\\writedata.properties", true);
		pro.store(file,"this is my property file");
		System.out.println("file created");

	}

}
