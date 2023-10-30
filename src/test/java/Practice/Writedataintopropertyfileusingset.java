package Practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Writedataintopropertyfileusingset {

	public static void main(String[] args) throws IOException {
		Properties s = new Properties();
		s.setProperty("username", "admin");
		s.setProperty("password", "admin");
		FileOutputStream file1=new FileOutputStream(".\\src\\test\\resources\\writedata1.properties", true);
		s.store(file1, "this is my file");
		System.out.println("file created");

	}

}
