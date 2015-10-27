package at.mvl.mvllib.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * a class all about strings
 * 
 * @author richi
 *
 */
public class StringArtist
{
	/**
	 * turns a file into a readable string, high performant due to th
	 * StringBuilder
	 * 
	 * @param file
	 *            must not be, is the source
	 * @return the text read from the file, null if you want to cause some
	 *         damage
	 */
	public static String read(File file)
	{
		if (file == null)
			return null;
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			String line = "";
			while ((line = br.readLine()) != null)
				sb.append(line);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return sb.toString();
	}
}
