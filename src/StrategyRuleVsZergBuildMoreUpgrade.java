import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;
import bwapi.UpgradeType;

public class StrategyRuleVsZergBuildMoreUpgrade extends StrategyRule {

	private boolean chkBuildMoreUpgrade = false;

	public StrategyRuleVsZergBuildMoreUpgrade(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

		if (MyBotModule.Broodwar.getFrameCount() % 120 != 0 || chkBuildMoreUpgrade == true) {
			return null;
		}

		if (MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_Citadel_of_Adun) > 0
				&& MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_Nexus) > 1) {
			chkBuildMoreUpgrade = true;
			return Strategy.BUILD_MORE_UPGRADE;
		}
		return null;
	}
}
