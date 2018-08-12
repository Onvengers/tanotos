import javax.net.ssl.SSLEngineResult.Status;

import bwapi.Position;
import bwapi.Unit;
import bwapi.UnitType;

// 특정 troop이나 Unit을 특정 위치로 AttackGround 함
public class CombatActionAttackSection implements ICombatAction {

	private final Troop troop;
	private final Unit unit;

	public CombatActionAttackSection(Troop troop) {
		if (troop instanceof DefaultTroop) {
			this.troop = (DefaultTroop) troop;
		} else {
			this.troop = troop;
		}
		this.unit = null;
	}

	public CombatActionAttackSection(Unit unit) {
		this.unit = unit;
		this.troop = null;
	}

	@Override
	public void act() {
	}

	@Override
	public void act(CommandFlag commandFlag) {
		// // CommandFlag 처리하기
		if (commandFlag == CommandFlag.ATTACK_ENEMY_CENTER) {
			troop.command(TroopCommand.ATTACK_SECTION, StatusIndicator.Instance().getEnemySectionOf(),
					MapSection.MAIN_CENTER);
		} else if (commandFlag == CommandFlag.ATTACK_ENEMY_SECOND_CENTER) {
			troop.command(TroopCommand.ATTACK_SECTION, StatusIndicator.Instance().getEnemySectionOf(),
					MapSection.SECOND_CENTER);
		} else if (commandFlag == CommandFlag.DEFENCE_MY_CENTER) {
			troop.command(TroopCommand.ATTACK_SECTION, StatusIndicator.Instance().getMySectionOf(),
					MapSection.MAIN_CENTER);
		} else if (commandFlag == CommandFlag.DEFENCE_MY_SECOND_CENTER) {
			troop.command(TroopCommand.ATTACK_SECTION, StatusIndicator.Instance().getMySectionOf(),
					MapSection.SECOND_CENTER);
		} else if (commandFlag == CommandFlag.DEFENCE_MY_BIG_ENTRANCE) {
			troop.command(TroopCommand.ATTACK_SECTION, StatusIndicator.Instance().getMySectionOf(),
					MapSection.BIG_ENTRANCE);
		} else if (commandFlag == CommandFlag.MOVE_MY_TROOP) {
			if (TroopManager.Instance().getTroop(UnitType.Protoss_Zealot).getSize() > 0) {
				troop.command(TroopCommand.MOVE,
						TroopManager.Instance().getTroop(UnitType.Protoss_Zealot).units.get(0).getPosition());
			}
			// troop.command(TroopCommand.MOVE,
			// getSectionOfFromCF(StatusIndicator.Instance().getTroopCommandFlag()),
			// getMapSectionFromCF(StatusIndicator.Instance().getTroopCommandFlag()));
		} else if (commandFlag == CommandFlag.ATTACK_ELLIE) {
			troop.command(TroopCommand.ATTACK_ELLIE);
		}
	}

	private SectionOf getSectionOfFromCF(CommandFlag cf) {
		if (cf == CommandFlag.ATTACK_ENEMY_CENTER || cf == CommandFlag.ATTACK_ENEMY_SECOND_CENTER) {
			return StatusIndicator.Instance().getEnemySectionOf();
		}
		if (cf == CommandFlag.DEFENCE_MY_BIG_ENTRANCE || cf == CommandFlag.DEFENCE_MY_CENTER
				|| cf == CommandFlag.DEFENCE_MY_SECOND_CENTER) {
			return StatusIndicator.Instance().getMySectionOf();
		}
		return StatusIndicator.Instance().getMySectionOf();
	}

	private MapSection getMapSectionFromCF(CommandFlag cf) {
		if (cf == CommandFlag.ATTACK_ENEMY_CENTER || cf == CommandFlag.DEFENCE_MY_CENTER) {
			return MapSection.MAIN_CENTER;
		}
		if (cf == CommandFlag.ATTACK_ENEMY_SECOND_CENTER || cf == CommandFlag.DEFENCE_MY_SECOND_CENTER) {
			return MapSection.SECOND_CENTER;
		}
		if (cf == CommandFlag.DEFENCE_MY_BIG_ENTRANCE) {
			return MapSection.BIG_ENTRANCE;
		}
		return MapSection.BIG_ENTRANCE;
	}
}
