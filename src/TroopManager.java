import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import bwapi.Unit;
import bwapi.UnitType;

public class TroopManager {

	private static TroopManager instance = new TroopManager();

	private List<Troop> troops = new LinkedList<Troop>();
	
	private TroopManager()
	{
		
	}
	
	public static TroopManager getInstance()
	{
		return instance;
	}
	
	public Troop getTroop(UnitType unitType)
	{
		for(Troop troop : troops)
		{
			if(troop instanceof DefaultTroop)
			{
				if(unitType == ((DefaultTroop) troop).getUnitType())
				{
					return troop;
				}
			}
		}
		
		return null;
	}
	
	public Troop getTroop(String name)
	{
		for(Troop troop : troops)
		{
			if(troop instanceof CustomTroop)
			{
				if(name.equals(((CustomTroop) troop).getName()))
				{
					return troop;
				}
			}
		}
		
		return null;
	}
	
	public void assignUnit(Unit unit, int priority)
	{
		for(Troop troop : troops)
		{
			if(troop instanceof DefaultTroop)
			{
				if(unit.getType() == ((DefaultTroop) troop).getUnitType())
				{
					troop.assignUnit(unit);
					break;
				}
			}
		}
		
		DefaultTroop newTroop = new DefaultTroop(unit.getType(), priority);
		newTroop.assignUnit(unit);
		troops.add(newTroop);
	}
	
	public void assignUnitToTroops(Unit unit, String key, int priority)
	{
		for(Troop troop : troops)
		{
			if(troop instanceof CustomTroop)
			{
				if(key.equals(((CustomTroop) troop).getName()))
				{
					troop.assignUnit(unit);
					break;
				}
			}
		}
		
		CustomTroop newTroop = new CustomTroop(key, priority);
		newTroop.assignUnit(unit);
		troops.add(newTroop);
	}
	
	public void update()
	{
		Collections.sort(troops);
		
		for(Troop troop : troops)
		{
			troop.update();
		}
	}
}
