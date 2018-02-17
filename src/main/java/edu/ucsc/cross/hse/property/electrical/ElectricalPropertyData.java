package edu.ucsc.cross.hse.property.electrical;

public class ElectricalPropertyData implements ElectricalProperties
{

	public double voltage;
	public double amperage;
	public double wattage;

	public ElectricalPropertyData(double voltage, double amperage)
	{
		this.voltage = voltage;
		this.amperage = amperage;
		this.wattage = this.voltage * this.amperage;
	}

	public static ElectricalPropertyData getFromWatts(double voltage, double wattage)
	{
		double amperage = wattage / voltage;
		return new ElectricalPropertyData(voltage, amperage);
	}

	public void fillMissing()
	{
		if (amperage == 0.0)
		{
			amperage = wattage / voltage;
		} else if (wattage == 0.0)
		{
			wattage = voltage * amperage;
		}
	}

	@Override
	public double getAmperage()
	{
		return amperage;
	}

	@Override
	public double getVoltage()
	{
		return voltage;
	}

	@Override
	public double getWattage()
	{
		return wattage;
	}

}
