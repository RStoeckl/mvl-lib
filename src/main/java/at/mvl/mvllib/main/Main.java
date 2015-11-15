package at.mvl.mvllib.main;

import java.io.File;

import at.mvl.mvllib.converter.JsonToBuchsammlung;
import at.mvl.mvllib.tools.Downloader;
import at.mvl.mvllib.tools.Networker;
import at.mvl.mvllib.tools.StringArtist;

public class Main
{

	public static void main(String[] args)
	{
		File local = new File("/home/richi/Dokumente/Java/Daheim/mvl-lib/examples/termine.json");
		String request = "http://192.168.56.4/perl/buecher.pl";
		String serverjson = "http://192.168.56.4/query/buecher.json";
		System.out.println(Networker.doRequest(request, "OK"));
		System.out.println(Downloader.downloadToFile(serverjson, local));
		System.out.println(JsonToBuchsammlung.parseBuchsammlung(StringArtist.read(local)).searchFor("a").get(0).getName());
	}

}
