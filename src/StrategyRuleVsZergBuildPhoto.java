import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;
import bwapi.UpgradeType;

public class StrategyRuleVsZergBuildPhoto extends StrategyRule {

	private boolean chkBuildPhoto = false;

	public StrategyRuleVsZergBuildPhoto(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

		if (MyBotModule.Broodwar.getFrameCount() % 120 != 0
				|| chkBuildPhoto == true) {
			return null;
		} else if (MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_Nexus) > 1) {
			chkBuildPhoto = true;
			return Strategy.BUILD_PHOTO;
		}

		return null;
	}
}
