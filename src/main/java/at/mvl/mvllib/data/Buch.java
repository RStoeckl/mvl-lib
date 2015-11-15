package at.mvl.mvllib.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * represents a single book
 * 
 * @author richi
 *
 */
public class Buch extends ArrayList<Seite>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7409576451315560606L;
	private String name;
	private int id;

	public Buch(int id, String name, ArrayList<Seite> seiten)
	{
		super();
		this.name = name;
		if(seiten !=null)
			addAll(seiten);
	}

	public Buch(int id, String name)
	{
		this(id, name, new ArrayList<Seite>());
	}

	/**
	 * 
	 * @return name of the book
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * puts page into book and overwrites and old one if necessary
	 * 
	 * @param number
	 *            number of the page
	 * @param name
	 *            name of the page
	 *            
	 * @param overwrite
	 * 			  if true it overwrites existing pages
	 * @return true if replaced an old one
	 */
	public boolean putPage(int number, String name, boolean overwrite)
	{
		Seite seite = new Seite(number, name);
		if(contains(seite) && !overwrite)
			return false;
		add(seite);
		return true;
	}

	/**
	 * searches for a title from a page
	 * @param name what are you looking for
	 * @return all pages number which includes the given name
	 */
	public Buch searchFor(String name)
	{
		Buch ret = new Buch(id, this.name);
		for(Seite s : this)
			if(s.getTitel().toLowerCase().contains(name.toLowerCase())||(""+s.getNummer()).contains(name))
				ret.add(s);
		return ret;
	}
	
	/**
	 * 
	 * @return all put pages
	 */
	public Set<Integer> getNumbers()
	{
		HashSet<Integer> ret = new HashSet<>();
		for (Seite s : this)
			ret.add(s.getNummer());
		return ret;
	}

	public int getId()
	{
		return id;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Buch other = (Buch) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
