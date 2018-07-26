import java.util.LinkedList;
import java.util.List;

import bwapi.Unit;

public abstract class Troop implements Comparable<Troop> {

	protected List<Unit> units = new LinkedList<Unit>();
	
	protected TroopCommand command = TroopCommand.NONE;
	protected int priority = 0;
	
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public TroopCommand getCommand()
	{
		return command;
	}
	
	public void setCommand(TroopCommand command)
	{
		this.command = command;
	}
	
	public void assignUnit(Unit unit)
	{
		units.add(unit);
	}
	
	public abstract int update();
	
	public abstract void command(TroopCommand cmd, Object param);
}

enum TroopCommand
{
	MOVE,
	ATTACK_UNIT,
	ATTACK_GROUND,
	HOLD,
	ATTACK_STORM,
	NONE
}