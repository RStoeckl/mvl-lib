package at.mvl.mvllib.main;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import at.mvl.mvllib.tools.Downloader;
import at.mvl.mvllib.tools.Networker;
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

		/*try (BufferedReader br = new BufferedReader(new FileReader("examples/termine.json")))
		{
			String line = "";
			while ((line = br.readLine()) != null)
				sb.append(line);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		// System.out.println(sb);
		//System.out.println(JsonToTermin.parseTermine(sb.toString()).get(0));
		System.out.println(Networker.doRequest("http://192.168.56.4/perl/termine.pl", "OK"));
		System.out.println(Downloader.downloadToFile("http://192.168.56.4/query/termine.json", new File("/home/richi/Dokumente/Java/Daheim/mvl-lib/examples/termine.json")));
	}

}
