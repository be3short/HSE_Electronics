package edu.ucsc.cross.hse.property.electrical;

import java.util.HashMap;

import edu.ucsc.cross.hse.core.variable.Variable;

public class StateBasedElectricalProperties implements ElectricalProperties
{

	private Variable<?> state;
	private ElectricalProperties failProperties;
	private HashMap<Object, ElectricalProperties> statePropertyMap;

	public <T> void addProperty(T object, ElectricalProperties props)
	{
		statePropertyMap.put(object, props);
	}

	public StateBasedElectricalProperties(Variable<?> state, ElectricalProperties fail_properties)
	{
		this.state = state;
		failProperties = fail_properties;
		statePropertyMap = new HashMap<Object, ElectricalProperties>();
	}

	public ElectricalProperties attemptProperties()
	{
		ElectricalProperties props = failProperties;

		if (state.getValue() != null)
		{
			if (statePropertyMap.keySet().contains(state.getValue()))
			{
				props = statePropertyMap.get(state.getValue());
			}
		}
		return props;
	}

	@Override
	public double getAmperage()
	{
		return attemptProperties().getAmperage();
	}

	@Override
	public double getVoltage()
	{
		return attemptProperties().getVoltage();
	}

	@Override
	public double getWattage()
	{
		return attemptProperties().getWattage();
	}

}
