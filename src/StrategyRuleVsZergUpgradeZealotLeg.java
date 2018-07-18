import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;
import bwapi.UpgradeType;
import bwapi.WeaponType;

public class StrategyRuleVsZergUpgradeZealotLeg extends StrategyRule {

	private boolean chkUpgradeZealotLeg = false;
	
	public StrategyRuleVsZergUpgradeZealotLeg(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

		if (MyBotModule.Broodwar.getFrameCount() % 120 != 0
				|| chkUpgradeZealotLeg == true) {
			return null;
		}

		if (MyBotModule.Broodwar.self().minerals() >= 100 && MyBotModule.Broodwar.self().gas() >= 100
				&& MyBotModule.Broodwar.self().supplyUsed() < 400) {
			for (Unit unit : MyBotModule.Broodwar.self().getUnits()) {
				if (unit.getType() == UnitType.Protoss_Citadel_of_Adun && unit.isTraining() == false) {
					chkUpgradeZealotLeg = true;
					return Strategy.UPGRADE_ZEALOT_LEG;
				}
			}
		}

		return null;
	}
}
