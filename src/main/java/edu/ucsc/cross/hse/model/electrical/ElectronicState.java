package edu.ucsc.cross.hse.model.electrical;

import edu.ucsc.cross.hse.core.modelling.DataStructure;

public class ElectronicState extends DataStructure
{

	public double current;
	public double voltage;
	public double powerConsumed;
	public double wattage;

	public ElectronicState(double power_consumed)
	{
		powerConsumed = power_consumed;
		wattage = 0.0;
		current = 0.0;
		voltage = 0.0;
	}
}
