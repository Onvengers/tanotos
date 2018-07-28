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
		initialTroops();
	}
	
	public static TroopManager Instance()
	{
		return instance;
	}
	
	public void initialTroops()
	{
		DefaultTroop zealotTroop = new DefaultTroop(UnitType.Protoss_Zealot, 1);
		troops.add(zealotTroop);
		DefaultTroop dragoonTroop = new DefaultTroop(UnitType.Protoss_Dragoon, 1);
		troops.add(dragoonTroop);
		DefaultTroop archonTroop = new DefaultTroop(UnitType.Protoss_Archon, 1);
		troops.add(archonTroop);
		DefaultTroop workerTroop = new DefaultTroop(UnitType.Protoss_Probe, 1);
		troops.add(workerTroop);
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
	}
	
	public void resignUnit(Unit unit)
	{
		for(Troop troop : troops)
		{
			if(troop instanceof DefaultTroop)
			{
				if(unit.getType() == ((DefaultTroop) troop).getUnitType())
				{
					troop.resignUnit(unit);
					break;
				}
			}
		}
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
