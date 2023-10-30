package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * this class consists of generic method related to java
 * @author Namrata
 *
 */
public class javaFileUtilities 
{
	public int getrandomnumber()
	{
		Random R = new Random();
		int number = R.nextInt(10000);//this is the range
		return number;
	}
	/**
	 * this class shows current system date in required format
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String date = formatter.format(d);
		return date;
	}

}
