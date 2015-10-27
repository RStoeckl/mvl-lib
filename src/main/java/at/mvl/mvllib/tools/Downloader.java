package at.mvl.mvllib.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;

/**
 * represents an amount of download helpers
 * @author richi
 *
 */
public class Downloader
{
	/**
	 * makes a backup of the existing file, and downloads the new one it is
	 * different from the timestamp
	 * 
	 * @param url
	 *            must not be null
	 * @param target
	 *            must not be null
	 * @return true if file from url is different and successfully downloaded
	 */
	public static boolean downloadToFile(String url, File target)
	{
		if (!target.exists() || !target.isFile())
			try
			{
				target.createNewFile();
			} catch (IOException e1)
			{
				e1.printStackTrace();
				return false;
			}
		try (FileInputStream fis = new FileInputStream(target))
		{
			URL online = new URL(url);
			URLConnection connection = online.openConnection();
			File backup = new File(target.toString() + ".bak");
			copy(target, backup);
			if (!thirdLine(connection.getInputStream()).equalsIgnoreCase(thirdLine(fis)))
			{
				return download(online, target);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * reads the timestamp from the json file from the 3rd line
	 * 
	 * @param is
	 *            must not be null
	 * @return an empty string if it is not successful otherwise the timestamp
	 */
	public static String thirdLine(InputStream is)
	{
		if (is == null)
			return "";
		String line = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(is)))
		{
			for (int i = 0; i <= 2; i++)
				line = br.readLine();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		if (line == null)
			line = "";
		String[] parts = line.split("\"");
		return (parts.length >= 4) ? parts[3] : "";
	}

	/**
	 * starts a simple download
	 * 
	 * @param online
	 *            must not be null
	 * @param target
	 *            must not be null
	 * @return if successful or not
	 */
	private static boolean download(URL online, File target)
	{
		if (online == null || target == null)
			return false;
		try (FileOutputStream fos = new FileOutputStream(target))
		{
			ReadableByteChannel rbc = Channels.newChannel(online.openStream());
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		} catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * copies one file to the other
	 * 
	 * @param from
	 *            must not be null
	 * @param to
	 *            must not be null
	 * @return if successful or not
	 */
	private static boolean copy(File from, File to)
	{
		if (from == null || to == null)
			return false;
		try
		{
			Files.copy(from.toPath(), new FileOutputStream(to));
		} catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
