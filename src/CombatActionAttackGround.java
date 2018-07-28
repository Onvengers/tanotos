import bwapi.Position;
import bwapi.Unit;

// 특정 troop이나 Unit을 특정 위치로 AttackGround 함
public class CombatActionAttackGround implements ICombatAction {

	private final Troop troop;
	private final Unit unit;
	private final Position pos;
	
	public CombatActionAttackGround(Troop troop, Position pos)
	{
		this.troop = troop;
		this.unit = null;
		this.pos = pos;
	}
	
	public CombatActionAttackGround(Unit unit, Position pos)
	{
		this.unit = unit;
		this.troop = null;
		this.pos = pos;
	}
	
	@Override
	public void act() {

		if(troop != null || troop.getSize() > 0)
		{
			troop.command(TroopCommand.ATTACK_GROUND, pos);
		}
		else if(unit != null
				&& unit.canAttack(pos))
		{
			unit.attack(pos);
		}
	}

}
