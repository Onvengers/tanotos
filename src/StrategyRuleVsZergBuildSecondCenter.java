import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;
import bwapi.UpgradeType;

public class StrategyRuleVsZergBuildSecondCenter extends StrategyRule {

	private boolean chkBuildSecondCenter = false;

	public StrategyRuleVsZergBuildSecondCenter(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

		if (MyBotModule.Broodwar.getFrameCount() % 120 != 0
				|| chkBuildSecondCenter == true) {
			return null;
		} else if (MyBotModule.Broodwar.self().allUnitCount(UnitType.Protoss_Gateway) > 1
				&& MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_Citadel_of_Adun) > 0) {
			chkBuildSecondCenter = true;
			return Strategy.BUILD_SECOND_CENTER;
		}

		return null;
	}
}
