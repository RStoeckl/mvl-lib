package at.mvl.mvllib.converter;

import at.mvl.mvllib.data.Seite;

public class SeiteTitelComparator extends SeiteComparator
{

	public SeiteTitelComparator(boolean aufsteigend, SeiteComparator child)
	{
		super(aufsteigend, child);
	}

	public SeiteTitelComparator(boolean aufsteigend)
	{
		super(aufsteigend);
	}

	@Override
	public int compare(Seite o1, Seite o2)
	{
		if (nullCheck(o1, o2))
			return super.compare(o1, o2);
		int ret = o1.getTitel().compareToIgnoreCase(o2.getTitel());
		if (ret == 0)
			return super.compare(o1, o2);
		return ret * (aufsteigend ? 1 : -1);
	}
}
