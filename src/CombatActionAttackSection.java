import bwapi.Position;
import bwapi.Unit;
import bwapi.UnitType;

// 특정 troop이나 Unit을 특정 위치로 AttackGround 함
public class CombatActionAttackSection implements ICombatAction {

	private final Troop troop;
	private final Unit unit;
	private final SectionOf sectionOf;
	private final MapSection mapSection;

	public CombatActionAttackSection(Troop troop, SectionOf sectionOf, MapSection mapSection) {
		if (troop instanceof DefaultTroop) {
			this.troop = (DefaultTroop) troop;
		} else {
			this.troop = troop;
		}
		this.unit = null;
		this.sectionOf = sectionOf;
		this.mapSection = mapSection;
	}

	public CombatActionAttackSection(Unit unit, SectionOf sectionOf, MapSection mapSection) {
		this.unit = unit;
		this.troop = null;
		this.sectionOf = sectionOf;
		this.mapSection = mapSection;
	}

	@Override
	public void act() {
		if (((DefaultTroop) troop).getUnitType() == UnitType.Protoss_Zealot) {
			if (troop != null && 25 < troop.getSize()) {
				troop.command(TroopCommand.ATTACK_SECTION, StatusIndicator.Instance().getEnemySectionOf(),
						MapSection.SIDE3);
			}
			if (troop != null && 24 < troop.getSize()) {
				troop.command(TroopCommand.ATTACK_SECTION, StatusIndicator.Instance().getEnemySectionOf(),
						MapSection.SIDE2);
			}
			if (troop != null && 23 < troop.getSize()) {
				troop.command(TroopCommand.ATTACK_SECTION, StatusIndicator.Instance().getEnemySectionOf(),
						MapSection.SIDE1);
			}
			if (troop != null && 20 < troop.getSize()) {
				troop.command(TroopCommand.ATTACK_SECTION, StatusIndicator.Instance().getEnemySectionOf(),
						MapSection.MAIN_CENTER);
			}
			if (troop != null && 12 <= troop.getSize()) {
				troop.command(TroopCommand.ATTACK_SECTION, StatusIndicator.Instance().getEnemySectionOf(),
						MapSection.BIG_ENTRANCE);
			}
			if (troop != null && 4 < troop.getSize() && troop.getSize() < 12) {
				troop.command(TroopCommand.ATTACK_SECTION, StatusIndicator.Instance().getMySectionOf(),
						MapSection.BIG_ENTRANCE);
			}
			if (troop != null && 0 < troop.getSize() && troop.getSize() < 5) {
				troop.command(TroopCommand.ATTACK_SECTION, StatusIndicator.Instance().getMySectionOf(), mapSection);
			}

		} else if (((DefaultTroop) troop).getUnitType() == UnitType.Protoss_High_Templar) {
			if (troop != null) {
				troop.command(TroopCommand.MOVE, StatusIndicator.Instance().getMySectionOf(), MapSection.ENTRANCE_UP);
			}
		} else if (((DefaultTroop) troop).getUnitType() == UnitType.Protoss_Archon) {
			if (troop != null && 0 < troop.getSize()) {
				troop.command(TroopCommand.ATTACK_SECTION, StatusIndicator.Instance().getEnemySectionOf(),
						MapSection.BIG_ENTRANCE);
			}
			if (troop != null && 1 < troop.getSize()) {
				troop.command(TroopCommand.ATTACK_SECTION, StatusIndicator.Instance().getEnemySectionOf(),
						MapSection.MAIN_CENTER);
			}
		}
	}

}
