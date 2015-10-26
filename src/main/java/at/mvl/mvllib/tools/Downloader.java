package at.mvl.mvllib.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;

public class Downloader
{
	public static boolean downloadToFile(String url, File target)
	{
		try
		{
			URL online = new URL(url);
			URLConnection connection = online.openConnection();
			if (target.exists() && target.isFile())
			{
				File backup = new File(target.toString() + ".bak");
				try
				{
					Files.copy(target.toPath(), new FileOutputStream(backup));
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(thirdLine(connection.getInputStream()));
			if (target.lastModified() == connection.getLastModified())
			{
				try (FileOutputStream fos = new FileOutputStream(target))
				{
					ReadableByteChannel rbc = Channels.newChannel(online.openStream());
					fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static String thirdLine(InputStream is)
	{
		String line = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(is)))
		{
			for (int i = 0; i <= 2; i++)
				line = br.readLine();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return line.split("\"")[3];
	}

}
