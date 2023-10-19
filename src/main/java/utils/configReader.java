package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configReader {
	
	public static final long IMPLICIT_WAIT=30;
	public static final long PAGELOAD_TIMEOUT=30;
	
	public static Properties prop ;
	
	public static Properties initlizeProperties()
	{
		 prop=new Properties();
		File file=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
		try {
		FileInputStream fis=new FileInputStream(file);
		prop.load(fis);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
		}
		
		return prop ;
	}

}
