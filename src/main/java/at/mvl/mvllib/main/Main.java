package at.mvl.mvllib.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import at.mvl.mvllib.converter.JsonToTermin;
import at.mvl.mvllib.tools.Downloader;
import at.mvl.mvllib.tools.Parser;

public class Main
{

	public static void main(String[] args)
	{
		GregorianCalendar cal = Parser.parseDate("2015-12-05 18:00:00");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		sdf.setCalendar(cal);
		System.out.println(sdf.format(cal.getTime()));

		StringBuilder sb = new StringBuilder();

		try (BufferedReader br = new BufferedReader(new FileReader("examples/termine.json")))
		{
			String line = "";
			while ((line = br.readLine()) != null)
				sb.append(line);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(sb);
		System.out.println(JsonToTermin.parseTermine(sb.toString()).get(0));

		System.out.println(Downloader.downloadToFile("http://192.168.56.4/perl/termine.pl", new File("/home/richi/Dokumente/Java/Daheim/mvl-lib/examples/termine.json.pl")));
	}

}
