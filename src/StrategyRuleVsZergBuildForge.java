import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;
import bwapi.UpgradeType;

public class StrategyRuleVsZergBuildForge extends StrategyRule {

	private boolean chkBuildForge = false;
	private boolean chkBuildForge2 = false;

	public StrategyRuleVsZergBuildForge(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

//		if (chkBuildForge2 == false && MyBotModule.Broodwar.self().gas() > 400) {
//			chkBuildForge2 = true;
//			return Strategy.BUILD_FORGE;
//		}

		if (MyBotModule.Broodwar.getFrameCount() % 120 != 0 || chkBuildForge == true) {
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
