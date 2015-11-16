package at.mvl.mvllib.converter;

import java.util.Comparator;

import at.mvl.mvllib.data.Seite;

/**
 * simple recursiv comparator class
 * 
 * @author richi
 *
 */
public abstract class SeiteComparator implements Comparator<Seite>
{

	protected SeiteComparator child;
	protected boolean aufsteigend;

	public SeiteComparator(boolean aufsteigend)
	{
		this.aufsteigend = aufsteigend;
	}

	public SeiteComparator(boolean aufsteigend, SeiteComparator child)
	{
		this(aufsteigend);
		this.child = child;
	}

	@Override
	/**
	 * compares two pages in recursive way
	 */
	public int compare(Seite o1, Seite o2)
	{
		int ret = 0;
		if (o1 == null)
			ret = 1;
		if (o2 == null)
			ret -= 1;
		if (ret == 0 && o1 != null && child != null)
			return child.compare(o1, o2);
		return ret * (aufsteigend ? 1 : -1);
	}

	/**
	 * check two objects reference
	 * @param o1 Object 1
	 * @param o2 Object 2
	 * @return true if both are not null
	 */
	public boolean nullCheck(Object o1, Object o2)
	{
		return o1 == null || o2 == null;
	}
}
