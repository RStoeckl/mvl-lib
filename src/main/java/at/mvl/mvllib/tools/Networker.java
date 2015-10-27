package at.mvl.mvllib.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Networker
{
	public static boolean doRequest(String url, String check)
	{
		try
		{
			URL neturl = new URL(url);
			try (InputStream is = neturl.openStream(); BufferedReader br = new BufferedReader(new InputStreamReader(is)))
			{
				boolean isNull = check == null;
				return isNull || check.equalsIgnoreCase(br.readLine());
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
