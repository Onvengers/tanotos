import bwapi.UnitType;

public class CustomTroop extends Troop {

	protected String myName;
	
	public CustomTroop(String name, int priority)
	{
		this.myName = name;
		this.priority = priority;
	}
	
	public String getName()
	{
		return myName;
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
