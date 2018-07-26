import bwapi.UnitType;

public class DefaultTroop extends Troop {
	
	protected UnitType myType;
	
	public DefaultTroop(UnitType type, int priority)
	{
		this.myType = type;
		this.priority = priority;
	}
	
	public UnitType getUnitType()
	{
		return myType;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void command(TroopCommand cmd, Object param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(Troop o) {
		
		if(this.priority > o.priority)
		{
			return 1;
		}
		else if(this.priority < o.priority)
		{
			return -1;
		}
		// TODO Auto-generated method stub
		return 0;
	}

}
