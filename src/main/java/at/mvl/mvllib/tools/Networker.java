package at.mvl.mvllib.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * a class about some network utils
 * @author richi
 *
 */
public class Networker
{
	/**
	 * does only a single request without much traffic, handy for executing a serverside script
	 * @param url must not be null
	 * @param check can be null, string which will be compared with the first line from the output from the url request
	 * @return only true if check is null or check is equal with the first line from the read text from the output from the url
	 */
	public static boolean doRequest(String url, String check)
	{
		if(url==null)
			return false;
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
