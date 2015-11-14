package at.mvl.mvllib.data;

/**
 * represents a single page
 * @author richi
 *
 */
public class Seite
{
	private int nummer;
	private String titel;
	
	public Seite(int nummer, String titel)
	{
		super();
		this.nummer = nummer;
		this.titel = titel;
	}

	/**
	 *get the number of the page
	 * @return the number of the page
	 */
	public int getNummer()
	{
		return nummer;
	}

	/**
	 * get the title of the page
	 * @return the title of the page
	 */
	public String getTitel()
	{
		return titel;
	}

	@Override
	public String toString()
	{
		return "Seite [nummer=" + nummer + ", titel=" + titel + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + nummer;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seite other = (Seite) obj;
		if (nummer != other.nummer)
			return false;
		return true;
	}
	
	
}
