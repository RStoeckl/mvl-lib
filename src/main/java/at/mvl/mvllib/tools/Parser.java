package at.mvl.mvllib.tools;

import java.util.GregorianCalendar;

public class Parser
{
	public static GregorianCalendar parseDate(String raw)
	{
		if (raw == null)
			return null;
		String[] splitDateTime = raw.split(" ");
		String date = splitDateTime[0];
		String time = splitDateTime[1];
		String[] splitDate = date.split("-");
		String[] splitTime = time.split(":");
		int year = Integer.parseInt(splitDate[0]);
		int month = Integer.parseInt(splitDate[1]) - 1;
		int day = Integer.parseInt(splitDate[2]);
		int hour = Integer.parseInt(splitTime[0]);
		int minute = Integer.parseInt(splitTime[1]);
		int second = Integer.parseInt(splitTime[2]);
		return new GregorianCalendar(year, month, day, hour, minute, second);
	}
}
