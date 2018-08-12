import javax.net.ssl.SSLEngineResult.Status;

import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;

// 특정 troop 이 공격 준비가 끝났는지 판단한다.
public class CombatStatusHowToCombat implements ICombatStatus {

	private final Troop troop;

	public CombatStatusHowToCombat(Troop troop) {
		this.troop = troop;
	}

	@Override
	public boolean checkCombatStatus() {
		return false;
	}

	@Override
	public CommandFlag getHowToCombat() {
		// TODO Auto-generated method stub
		if (troop instanceof DefaultTroop) {
			if (((DefaultTroop) troop).getUnitType() == UnitType.Protoss_Zealot
					|| ((DefaultTroop) troop).getUnitType() == UnitType.Protoss_Dragoon) {
				if (MyBotModule.Broodwar.self().supplyUsed() < 300
						&& StatusIndicator.Instance().setAllAttackFlag == false
						&& StatusIndicator.Instance().setAttackEllie == false) {
					setTroopCommandFlag(CommandFlag.DEFENCE_MY_BIG_ENTRANCE);
					return CommandFlag.DEFENCE_MY_BIG_ENTRANCE;
				} else if (MyBotModule.Broodwar.self().supplyUsed() > 380) {
					StatusIndicator.Instance().setAttackEllie = true;
					return CommandFlag.ATTACK_ELLIE;
				} else if (StatusIndicator.Instance().setAttackEllie == false) {
					if (StatusIndicator.Instance().setAllAttackFlag == false) {
						StatusIndicator.Instance().setAllAttackFlag = true;
					}
					setTroopCommandFlag(CommandFlag.ATTACK_ENEMY_CENTER);
					return CommandFlag.ATTACK_ENEMY_CENTER;
				}
			} else if (((DefaultTroop) troop).getUnitType() == UnitType.Protoss_Observer) {
				return CommandFlag.MOVE_MY_TROOP;
			}
		}
		return null;
	}

	private void setTroopCommandFlag(CommandFlag cf) {
		if (StatusIndicator.Instance().getTroopCommandFlag() != cf) {
			StatusIndicator.Instance().setTroopCommandFlag(cf);
		}
	}
}
