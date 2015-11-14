package at.mvl.mvllib.data;

import java.util.ArrayList;

/**
 * represents a collection of books
 * 
 * @author richi
 *
 */
public class Buchsammlung extends ArrayList<Buch>
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
		for (Buch b : this)
		{
			ret.add(b.searchFor(name));
		}
		return ret;
	}
}
