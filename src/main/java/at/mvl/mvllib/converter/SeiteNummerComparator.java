package at.mvl.mvllib.converter;

import at.mvl.mvllib.data.Seite;

public class SeiteNummerComparator extends SeiteComparator
{

	public SeiteNummerComparator(boolean aufsteigend)
	{
		super(aufsteigend);
	}

	public SeiteNummerComparator(boolean aufsteigend, SeiteComparator child)
	{
		super(aufsteigend, child);
	}

	@Override
	public int compare(Seite o1, Seite o2)
	{
		if (nullCheck(o1, o2))
			return super.compare(o1, o2);
		int ret = Integer.compare(o1.getNummer(), o2.getNummer());
		if (ret == 0)
			return super.compare(o1, o2);
		return ret * (aufsteigend ? 1 : -1);
	}
}
