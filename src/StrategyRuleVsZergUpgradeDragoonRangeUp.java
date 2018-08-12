import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;
import bwapi.UpgradeType;
import bwapi.WeaponType;

public class StrategyRuleVsZergUpgradeDragoonRangeUp extends StrategyRule {

	private boolean chkUpgradeDragoonRangeUp = false;
	
	public StrategyRuleVsZergUpgradeDragoonRangeUp(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

		if (MyBotModule.Broodwar.getFrameCount() % 120 != 0
				|| chkUpgradeDragoonRangeUp == true) {
			return null;
		}

		if (MyBotModule.Broodwar.self().minerals() >= 100 && MyBotModule.Broodwar.self().gas() >= 100) {
			for (Unit unit : MyBotModule.Broodwar.self().getUnits()) {
				if (unit.getType() == UnitType.Protoss_Cybernetics_Core && unit.isTraining() == false) {
					chkUpgradeDragoonRangeUp = true;
					return Strategy.UPGRADE_DRAGOON_RANGE_UP;
				}
			}
		}

		return null;
	}
}
