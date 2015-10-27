package at.mvl.mvllib.data;

import java.util.GregorianCalendar;

/**
 * represents a single "Termin" with its attributes
 * 
 * @author richi
 *
 */
public class Termin
{
	private String name, dauer, treffpunkt, beschreibung, adjustierung;
	private GregorianCalendar beginn;

	public Termin(String name, String dauer, String treffpunkt, String beschreibung, String adjustierung, GregorianCalendar beginn)
	{
		super();
		this.name = name;
		this.dauer = dauer;
		this.treffpunkt = treffpunkt;
		this.beschreibung = beschreibung;
		this.adjustierung = adjustierung;
		this.beginn = beginn;
	}

	/**
	 * 
	 * @return the name of this "Termin"
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * 
	 * @return how long it takes
	 */
	public String getDauer()
	{
		return dauer;
	}

	/**
	 * 
	 * @returnw here we have to meet
	 */
	public String getTreffpunkt()
	{
		return treffpunkt;
	}

	/**
	 * 
	 * @return additional information
	 */
	public String getBeschreibung()
	{
		return beschreibung;
	}

	/**
	 * 
	 * @return the dresscode
	 */
	public String getAdjustierung()
	{
		return adjustierung;
	}

	/**
	 * 
	 * @return when we have to meet
	 */
	public GregorianCalendar getBeginn()
	{
		return beginn;
	}

	@Override
	public String toString()
	{
		return "Termin [name=" + name + ", dauer=" + dauer + ", treffpunkt=" + treffpunkt + ", beschreibung=" + beschreibung + ", adjustierung=" + adjustierung + ", beginn=" + beginn + "]";
	}

}
