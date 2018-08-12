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
	public void command(TroopCommand cmd) {
		if (cmd == TroopCommand.ATTACK_ELLIE) {
			for (Unit unit : units) {
				if (unit.isIdle()) {
					System.out.println(unit.getID() + " ATTACK_ELLIE START");
					if(StatusIndicator.Instance().countEllieUnit.get(EllieSection.ENEMY_SIDE1.getValue()) < 3) {
						commandUtil.attackMove(unit, LocationManager.getInstance().getSectionPosition(StatusIndicator.Instance().getEnemySectionOf(), 
								MapSection.SIDE1));
						System.out.println(unit.getID() + " ENEMY_SIDE1");
						StatusIndicator.Instance().countEllieUnit.set(EllieSection.ENEMY_SIDE1.getValue(), StatusIndicator.Instance().countEllieUnit.get(EllieSection.ENEMY_SIDE1.getValue()) + 1);
					}
					else if(StatusIndicator.Instance().countEllieUnit.get(EllieSection.ENEMY_SIDE2.getValue()) < 3) {
						commandUtil.attackMove(unit, LocationManager.getInstance().getSectionPosition(StatusIndicator.Instance().getEnemySectionOf(), 
								MapSection.SIDE2));
						System.out.println(unit.getID() + " ENEMY_SIDE2");
						StatusIndicator.Instance().countEllieUnit.set(EllieSection.ENEMY_SIDE2.getValue(), StatusIndicator.Instance().countEllieUnit.get(EllieSection.ENEMY_SIDE2.getValue()) + 1);
					}
					else if(StatusIndicator.Instance().countEllieUnit.get(EllieSection.ENEMY_SIDE3.getValue()) < 3) {
						commandUtil.attackMove(unit, LocationManager.getInstance().getSectionPosition(StatusIndicator.Instance().getEnemySectionOf(), 
								MapSection.SIDE3));
						System.out.println(unit.getID() + " ENEMY_SIDE3");
						StatusIndicator.Instance().countEllieUnit.set(EllieSection.ENEMY_SIDE3.getValue(), StatusIndicator.Instance().countEllieUnit.get(EllieSection.ENEMY_SIDE3.getValue()) + 1);
					}
					else if(StatusIndicator.Instance().countEllieUnit.get(EllieSection.ENEMY_THIRD_CENTER.getValue()) < 10) {
						commandUtil.attackMove(unit, LocationManager.getInstance().getSectionPosition(StatusIndicator.Instance().getEnemySectionOf(), 
								MapSection.THIRD_CENTER));
						System.out.println(unit.getID() + " ENEMY_THIRD_CENTER");
						StatusIndicator.Instance().countEllieUnit.set(EllieSection.ENEMY_THIRD_CENTER.getValue(), StatusIndicator.Instance().countEllieUnit.get(EllieSection.ENEMY_THIRD_CENTER.getValue()) + 1);
					}
					else if(StatusIndicator.Instance().countEllieUnit.get(EllieSection.MULTI1.getValue()) < 10) {
						commandUtil.attackMove(unit, LocationManager.getInstance().getSectionPosition(SectionOf.CENTER, MapSection.MULTI1));
						System.out.println(unit.getID() + " MULTI1");
						StatusIndicator.Instance().countEllieUnit.set(EllieSection.MULTI1.getValue(), StatusIndicator.Instance().countEllieUnit.get(EllieSection.MULTI1.getValue()) + 1);
					}
					else if(StatusIndicator.Instance().countEllieUnit.get(EllieSection.MULTI2.getValue()) < 10) {
						commandUtil.attackMove(unit, LocationManager.getInstance().getSectionPosition(SectionOf.CENTER, MapSection.MULTI2));
						System.out.println(unit.getID() + " MULTI2");
						StatusIndicator.Instance().countEllieUnit.set(EllieSection.MULTI2.getValue(), StatusIndicator.Instance().countEllieUnit.get(EllieSection.MULTI2.getValue()) + 1);
					}
					else if(StatusIndicator.Instance().countEllieUnit.get(EllieSection.MULTI3.getValue()) < 10) {
						commandUtil.attackMove(unit, LocationManager.getInstance().getSectionPosition(SectionOf.CENTER, MapSection.MULTI3));
						System.out.println(unit.getID() + " MULTI3");
						StatusIndicator.Instance().countEllieUnit.set(EllieSection.MULTI3.getValue(), StatusIndicator.Instance().countEllieUnit.get(EllieSection.MULTI3.getValue()) + 1);
					}
					else if(StatusIndicator.Instance().countEllieUnit.get(EllieSection.MULTI4.getValue()) < 10) {
						commandUtil.attackMove(unit, LocationManager.getInstance().getSectionPosition(SectionOf.CENTER, MapSection.MULTI4));
						System.out.println(unit.getID() + " MULTI4");
						StatusIndicator.Instance().countEllieUnit.set(EllieSection.MULTI4.getValue(), StatusIndicator.Instance().countEllieUnit.get(EllieSection.MULTI4.getValue()) + 1);
					}
				}
			}
		}
	}
	
	@Override
	public void command(TroopCommand cmd, Object param) {
		if (cmd == TroopCommand.MOVE) {
			for (Unit unit : units) {
				if (unit.isIdle() && !(LocationManager.getInstance().isExistsPosition(unit, (Position) param, 192)))
				{
					commandUtil.move(unit, (Position)param);
				}
			}
		}
	}

	@Override
	public void command(TroopCommand cmd, Object param1, Object param2) {
		if (cmd == TroopCommand.ATTACK_SECTION) {
			for (Unit unit : units) {
				if ((unit.isIdle() && !(LocationManager.getInstance().isExistsSection(unit, (SectionOf) param1,
						(MapSection) param2, 192)))
						|| (!unit.isIdle() && MyBotModule.Broodwar.getFrameCount() % 60 == 0
						&& !(LocationManager.getInstance().isExistsSection(unit, (SectionOf) param1,
								(MapSection) param2, 192)))) {
					commandUtil.attackMove(unit,
							LocationManager.getInstance().getSectionPosition((SectionOf) param1, (MapSection) param2));
					if (StatusIndicator.Instance().getTroopPosition(unit.getType()) != LocationManager.getInstance()
							.getSectionPosition((SectionOf) param1, (MapSection) param2)) {
						StatusIndicator.Instance().setTroopPosition(unit.getType(), LocationManager.getInstance()
								.getSectionPosition((SectionOf) param1, (MapSection) param2));
					}
				}
			}
		} else if (cmd == TroopCommand.MOVE) {
			for (Unit unit : units) {
				if (unit.isIdle() && !(LocationManager.getInstance().isExistsSection(unit, (SectionOf) param1,
						(MapSection) param2, 192))) {
					commandUtil.move(unit,
							LocationManager.getInstance().getSectionPosition((SectionOf) param1, (MapSection) param2));
					if (StatusIndicator.Instance().getTroopPosition(unit.getType()) != LocationManager.getInstance()
							.getSectionPosition((SectionOf) param1, (MapSection) param2)) {
						StatusIndicator.Instance().setTroopPosition(unit.getType(), LocationManager.getInstance()
								.getSectionPosition((SectionOf) param1, (MapSection) param2));
					}
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
