package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist of generic methods to 
 * read data from property file
 * @author Namrata
 *
 */
public class proprtyFileUtility {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
public String readDatafromPropertyFile(String key) throws IOException
{
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties p = new Properties();
	p.load(fis);
	  String value = p.getProperty(key);
	return value;
}
}
