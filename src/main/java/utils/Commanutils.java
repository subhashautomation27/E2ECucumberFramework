package utils;

import java.util.Date;

public class Commanutils {
	
public String getEmailTimeStamp()
	{
		Date date=new Date();
		return "subash"+date.toString().replace(" ", "_").replace(" ", "_")+"gmail.com";
	}

}
