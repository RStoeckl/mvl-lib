package at.mvl.mvllib.data;

import java.util.GregorianCalendar;

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

	public String getName()
	{
		return name;
	}

	public String getDauer()
	{
		return dauer;
	}

	public String getTreffpunkt()
	{
		return treffpunkt;
	}

	public String getBeschreibung()
	{
		return beschreibung;
	}

	public String getAdjustierung()
	{
		return adjustierung;
	}

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
