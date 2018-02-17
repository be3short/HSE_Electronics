package edu.ucsc.cross.hse.property.electrical;

import edu.ucsc.cross.hse.core.logging.Console;

public interface ElectricalProperties
{

	public double getAmperage();

	public double getVoltage();

	public double getWattage();

	public static double computeWattage(ElectricalProperties properties)
	{
		double watts = 0.0;
		try
		{
			watts = properties.getAmperage() * properties.getVoltage();
		} catch (Exception badValues)
		{
			Console.error("could not compute wattage for " + properties);
		}
		return watts;
	}

}
