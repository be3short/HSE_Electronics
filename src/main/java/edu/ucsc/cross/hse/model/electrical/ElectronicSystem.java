package edu.ucsc.cross.hse.model.electrical;

import edu.ucsc.cross.hse.core.modelling.HybridSystem;
import edu.ucsc.cross.hse.core.variable.Variable;
import edu.ucsc.cross.hse.property.electrical.ElectricalProperties;

public class ElectronicSystem extends HybridSystem<ElectronicState>
{

	Variable<ElectricalProperties> properties;

	public ElectronicSystem(ElectronicState state, Variable<ElectricalProperties> properties)
	{
		super(state, properties);
		this.properties = properties;
	}

	@Override
	public boolean C(ElectronicState x)
	{
		return x.wattage > 0.0;
	}

	@Override
	public void F(ElectronicState x, ElectronicState x_dot)
	{
		x_dot.powerConsumed = x.wattage;
	}

	@Override
	public boolean D(ElectronicState x)
	{
		return properties.getValue().getWattage() != x.wattage;
	}

	@Override
	public void G(ElectronicState x, ElectronicState x_plus)
	{
		x_plus.wattage = properties.getValue().getWattage();
		x_plus.current = properties.getValue().getAmperage();
		x_plus.voltage = properties.getValue().getVoltage();
	}

}
