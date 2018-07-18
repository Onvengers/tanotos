import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;
import bwapi.UpgradeType;

public class StrategyRuleVsZergBuildAdun extends StrategyRule {

	private boolean chkBuildAdun = false;
	
	public StrategyRuleVsZergBuildAdun(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

		if (MyBotModule.Broodwar.getFrameCount() % 120 != 0
				|| chkBuildAdun == true) {
			return null;
		}

		if (MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_Cybernetics_Core) > 0) {
			chkBuildAdun = true;
			return Strategy.BUILD_ADUN;
		}
		return null;
	}
}
