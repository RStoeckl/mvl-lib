package at.mvl.mvllib.data;

import java.util.HashMap;

/**
 * represents a single book
 * 
 * @author richi
 *
 */
public class Buch
{
	private String name;
	private HashMap<Integer, String> pages;

	public Buch(String name, HashMap<Integer, String> pages)
	{
		super();
		this.name = name;
		this.pages = pages;
	}

	public Buch(String name)
	{
		this(name, new HashMap<Integer, String>());
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
	 * 
	 * @param number number of the page
	 * @return name of the page
	 */
	public String getPage(int number)
	{
		return pages.get(number);
	}
	
	/**
	 * puts page into book and overwrites and old one if necessary
	 * @param number number of the page
	 * @param name name of the page
	 * @return true if replaced an old one
	 */
	public boolean putPage(int number, String name)
	{
		boolean ret = pages.containsValue(number);
		pages.put(number, name);
		return ret;
	}
}
