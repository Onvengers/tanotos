import java.util.LinkedList;
import java.util.List;

import bwapi.Position;
import bwapi.Unit;

public abstract class Troop implements Comparable<Troop> {

	protected List<Unit> units = new LinkedList<Unit>();
	
	protected TroopCommand command = TroopCommand.NONE;
	protected int priority = 0;
	private Position troopPosition = new Position(0,0);
	
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getSize() {
		return units.size();
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
	
	public void resignUnit(Unit resignedUnit)
	{
		for(Unit unit : units) {
			if(unit.getID() == resignedUnit.getID()) {
				units.remove(unit);
				return;
			}
		}
	}
	
	public abstract int update();
	
	public abstract void command(TroopCommand cmd, Object param);
	
	public abstract void command(TroopCommand cmd, Object param1, Object param2);

	public Position getTroopPosition() {
		return troopPosition;
	}

	public void setTroopPosition(Position troopPosition) {
		this.troopPosition = troopPosition;
	}

	public void command(TroopCommand cmd) {
		// TODO Auto-generated method stub
	}
}

enum TroopCommand
{
	MOVE,
	ATTACK_UNIT,
	ATTACK_SECTION,
	ATTACK_GROUND,
	ATTACK_ELLIE,
	HOLD,
	ATTACK_STORM,
	NONE
}