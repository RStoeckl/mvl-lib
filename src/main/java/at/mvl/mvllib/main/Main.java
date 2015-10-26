package at.mvl.mvllib.main;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import at.mvl.mvllib.tools.Parser;


public class Main
{

	public static void main(String[] args)
	{	
		GregorianCalendar cal = Parser.parseDate("2015-12-05 18:00:00");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		sdf.setCalendar(cal);
		System.out.println(sdf.format(cal.getTime()));
	}

}
