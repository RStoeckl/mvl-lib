package at.mvl.mvllib.converter;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.json.JSONArray;
import org.json.JSONObject;

import at.mvl.mvllib.data.Termin;
import at.mvl.mvllib.tools.Parser;

public class JsonToTermin
{
	public static ArrayList<Termin> parseTermine(String rawjson)
	{
		ArrayList<Termin> ret = new ArrayList<>();
		JSONArray termine = new JSONArray(rawjson);
		for (int i = 0; i < termine.length(); i++)
		{
			JSONObject rawtermin = termine.getJSONObject(i);
			String dauer = rawtermin.getString("dauer");
			String treffpunkt = rawtermin.getString("treffpunkt");
			String name = rawtermin.getString("name");
			String beschreibung = rawtermin.getString("beschreibung");
			GregorianCalendar beginn = Parser.parseDate(rawtermin.getString("beginn"));
			String adjustierung = rawtermin.getString("adjustierung");
			ret.add(new Termin(name, dauer, treffpunkt, beschreibung, adjustierung, beginn));
		}
		return ret;
	}
}
