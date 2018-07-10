import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;
import bwapi.UpgradeType;

public class StrategyRuleVsZergBuildAdun extends StrategyRule {

	public StrategyRuleVsZergBuildAdun(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

		if (MyBotModule.Broodwar.getFrameCount() % 120 != 0
				|| (BuildManager.Instance().buildQueue.getItemCount(UnitType.Protoss_Citadel_of_Adun)) > 0
				|| (MyBotModule.Broodwar.self().allUnitCount(UnitType.Protoss_Citadel_of_Adun) > 0)) {
			return null;
		}

		if (MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_Cybernetics_Core) > 0) {
			return Strategy.BUILD_ADUN;
		}

		return null;
	}
}
