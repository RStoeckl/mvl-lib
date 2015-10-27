package at.mvl.mvllib.data;

import java.util.HashMap;
import java.util.Set;

/**
 * represents a collection of books
 * 
 * @author richi
 *
 */
public class Buchsammlung extends HashMap<Integer, Buch>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8277009713577581315L;

	/**
	 * searches for name in titles
	 * 
	 * @param name
	 *            string to search
	 * @return all books with containment
	 */
	public Buchsammlung searchFor(String name)
	{
		Buchsammlung ret = new Buchsammlung();
		for (int buchnummer : this.keySet())
		{
			Buch buch = this.get(buchnummer);
			Set<Integer> nummern = buch.searchFor(name);
			if (!nummern.isEmpty())
			{
				Buch adding = new Buch(buch.getName());
				for (int resnummer : nummern)
					buch.putPage(resnummer, adding.getPage(resnummer));
				ret.put(buchnummer, adding);
			}
		}
		return ret;
	}
}
