import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;
import bwapi.UpgradeType;

public class StrategyRuleVsZergBuildCore extends StrategyRule {

	private boolean chkBuildCore = false;
	
	public StrategyRuleVsZergBuildCore(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

		if (MyBotModule.Broodwar.getFrameCount() % 120 != 0
				|| chkBuildCore == true) {
			return null;
		}

		if (MyBotModule.Broodwar.self().allUnitCount(UnitType.Protoss_Gateway) > 1
				&& MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_Zealot) > 2
				&& MyBotModule.Broodwar.self().allUnitCount(UnitType.Protoss_Assimilator) > 0) {
			chkBuildCore = true;
			return Strategy.BUILD_CORE;
		}

		return null;
	}
}
