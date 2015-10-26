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
			
			
			
			String dauer = rawtermin.get("dauer").toString();
			String treffpunkt = rawtermin.get("treffpunkt").toString();
			String name = rawtermin.get("name").toString();
			String beschreibung = rawtermin.get("beschreibung").toString();
			GregorianCalendar beginn = Parser.parseDate(rawtermin.get("beginn").toString());
			String adjustierung = rawtermin.get("adjustierung").toString();
			ret.add(new Termin(name, dauer, treffpunkt, beschreibung, adjustierung, beginn));
		}
		return ret;
	}
}
