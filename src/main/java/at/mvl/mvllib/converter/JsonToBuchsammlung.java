package at.mvl.mvllib.converter;

import org.json.JSONArray;
import org.json.JSONObject;

import at.mvl.mvllib.data.Buch;
import at.mvl.mvllib.data.Buchsammlung;
import at.mvl.mvllib.data.Seite;

public class JsonToBuchsammlung
{
	/**
	 * generates buchsammlung from json
	 * 
	 * @param raw
	 *            json text - must not be null
	 * @return the buchsammung from the json
	 */
	public static Buchsammlung parseBuchsammlung(String raw)
	{
		Buchsammlung ret = new Buchsammlung();
		if (raw == null)
			return null;
		JSONArray array = new JSONArray(raw);
		for (int i = 1; i < array.length(); i++)
		{
			JSONObject rawbook = array.getJSONObject(i);
			int buchid = rawbook.getInt("bid");
			System.out.println(buchid);
			String name = rawbook.getString("name");
			Buch buch = new Buch(buchid, name);
			JSONArray seiten = rawbook.getJSONArray("seiten");
			for(int i2 = 0; i2 < seiten.length(); i2++)
			{
				JSONObject seite = seiten.getJSONObject(i2);
				int nummer = seite.getInt("nummer");
				String titel = seite.getString("titel");
				Seite newSeite = new Seite(nummer, titel);
				buch.add(newSeite);
			}
			ret.add(buch);
		}
		return ret;
	}
}
