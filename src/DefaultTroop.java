import bwapi.Position;
import bwapi.Unit;
import bwapi.UnitType;

public class DefaultTroop extends Troop {

	protected UnitType myType;
	private CommandUtil commandUtil = new CommandUtil();

	public DefaultTroop(UnitType type, int priority) {
		this.myType = type;
		this.priority = priority;
	}

	public UnitType getUnitType() {
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
		if (cmd == TroopCommand.MOVE) {

		} else if (cmd == TroopCommand.MOVE) {
			for (Unit unit : units) {
				if (unit.isIdle()) {
					commandUtil.move(unit, (Position) param);
				}
			}
		} else if (cmd == TroopCommand.ATTACK_UNIT) {

		} else if (cmd == TroopCommand.ATTACK_GROUND) {
			for (Unit unit : units) {
				if (unit.isIdle()) {
					commandUtil.attackMove(unit, (Position) param);
				}
			}
		} else if (cmd == TroopCommand.HOLD) {

		} else if (cmd == TroopCommand.ATTACK_STORM) {

		} else if (cmd == TroopCommand.NONE) {

		}

	}

	@Override
	public void command(TroopCommand cmd, Object param1, Object param2) {
		if (cmd == TroopCommand.ATTACK_SECTION) {
			for (Unit unit : units) {
				if (unit.isIdle() && !(LocationManager.getInstance().isExistsSection(unit, (SectionOf) param1,
						(MapSection) param2, 192))) {
					System.out.println("unitId:" + unit.getID());
					System.out.println("commandUtil.attackMove");
					commandUtil.attackMove(unit,
							LocationManager.getInstance().getSectionPosition((SectionOf) param1, (MapSection) param2));
				}
			}
		} else if (cmd == TroopCommand.MOVE) {
			for (Unit unit : units) {
				if (unit.isIdle() && !(LocationManager.getInstance().isExistsSection(unit, (SectionOf) param1,
						(MapSection) param2, 192))) {
					System.out.println("unitId:" + unit.getID());
					System.out.println("commandUtil.move");
					commandUtil.move(unit,
							LocationManager.getInstance().getSectionPosition((SectionOf) param1, (MapSection) param2));
				}
			}
		}
	}

	@Override
	public int compareTo(Troop o) {

		if (this.priority > o.priority) {
			return 1;
		} else if (this.priority < o.priority) {
			return -1;
		}
		// TODO Auto-generated method stub
		return 0;
	}

}
