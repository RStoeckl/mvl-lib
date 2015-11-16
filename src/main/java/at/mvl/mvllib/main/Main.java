package at.mvl.mvllib.main;

import java.io.File;
import java.util.Collections;

import at.mvl.mvllib.converter.JsonToBuchsammlung;
import at.mvl.mvllib.converter.SeiteTitelComparator;
import at.mvl.mvllib.data.Buchsammlung;
import at.mvl.mvllib.tools.StringArtist;

public class Main
{

	public static void main(String[] args)
	{
		File local = new File("/home/richi/Dokumente/Java/Daheim/mvl-lib/examples/termine.json");
		/*String request = "http://192.168.56.4/perl/buecher.pl";
		String serverjson = "http://192.168.56.4/query/buecher.json";
		System.out.println(Networker.doRequest(request, "OK"));
		System.out.println(Downloader.downloadToFile(serverjson, local));*/
		Buchsammlung sammlung = JsonToBuchsammlung.parseBuchsammlung(StringArtist.read(local));
		Collections.shuffle(sammlung.get(0));
		System.out.println(sammlung.get(0));
		Collections.sort(sammlung.get(0), new SeiteTitelComparator(false));
		System.out.println(sammlung.get(0));
	}

}
