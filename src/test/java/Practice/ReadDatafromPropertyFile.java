package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDatafromPropertyFile {

	public static void main(String[] args) throws IOException {
		//step 1:open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//step 2:create obj of properties for java.util package
		Properties p = new Properties();
		//step 3:load the file input stream into properties
		p.load(fis);
		//step 4: provide the key and read the value
		String value = p.getProperty("browser");
		String value2 = p.getProperty("url");
		String value3 = p.getProperty("username");
		String value4 = p.getProperty("xys");
		System.out.println(value);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);

	}

}
