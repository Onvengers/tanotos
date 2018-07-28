import bwapi.Position;
import bwapi.Unit;

// 특정 troop이나 Unit을 특정 위치로 AttackGround 함
public class CombatActionAttackSection implements ICombatAction {

	private final Troop troop;
	private final Unit unit;
	private final SectionOf sectionOf;
	private final MapSection mapSection;
	
	public CombatActionAttackSection(Troop troop, SectionOf sectionOf, MapSection mapSection)
	{
		this.troop = troop;
		this.unit = null;
		this.sectionOf = sectionOf;
		this.mapSection = mapSection;
	}
	
	public CombatActionAttackSection(Unit unit, SectionOf sectionOf, MapSection mapSection)
	{
		this.unit = unit;
		this.troop = null;
		this.sectionOf = sectionOf;
		this.mapSection = mapSection;
	}
	
	@Override
	public void act() {

		if(troop != null)
		{
			troop.command(TroopCommand.ATTACK_SECTION, sectionOf, mapSection);
		}
	}

}
