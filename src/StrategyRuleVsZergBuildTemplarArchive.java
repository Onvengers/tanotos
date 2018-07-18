import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;
import bwapi.UpgradeType;

public class StrategyRuleVsZergBuildTemplarArchive extends StrategyRule {

	private boolean chkBuildTemplerArchive = false;
	
	public StrategyRuleVsZergBuildTemplarArchive(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

		if (MyBotModule.Broodwar.getFrameCount() % 120 != 0
				|| chkBuildTemplerArchive == true) {
			return null;
		}

		if (MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_Citadel_of_Adun) > 0) {
			chkBuildTemplerArchive = true;
			return Strategy.BUILD_TEMPLAR_ARCHIVE;
		}

		return null;
	}
}
