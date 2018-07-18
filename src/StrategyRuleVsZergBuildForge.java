import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;
import bwapi.UpgradeType;

public class StrategyRuleVsZergBuildForge extends StrategyRule {

	private boolean chkBuildForge = false;

	public StrategyRuleVsZergBuildForge(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

		if (MyBotModule.Broodwar.getFrameCount() % 120 != 0
				|| chkBuildForge == true) {
			return null;
		} else if (MyBotModule.Broodwar.self().allUnitCount(UnitType.Protoss_Gateway) > 1
				&& MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_Zealot) > 2
				&& MyBotModule.Broodwar.self().allUnitCount(UnitType.Protoss_Assimilator) > 0) {
			chkBuildForge = true;
			return Strategy.BUILD_FORGE;
		}

		return null;
	}
}
