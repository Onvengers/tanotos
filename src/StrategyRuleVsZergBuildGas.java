import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;
import bwapi.UpgradeType;

public class StrategyRuleVsZergBuildGas extends StrategyRule {

	public StrategyRuleVsZergBuildGas(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

		if ((MyBotModule.Broodwar.getFrameCount() % 120 != 0) ||
				((BuildManager.Instance().buildQueue.getItemCount(UnitType.Protoss_Assimilator)) > 0) ||
				((MyBotModule.Broodwar.self().allUnitCount(UnitType.Protoss_Assimilator)) > 0)) {
			return null;
		}

		if (MyBotModule.Broodwar.self().allUnitCount(UnitType.Protoss_Gateway) > 1
				&& MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_Zealot) > 2) {
			return Strategy.ADD_GAS;
		}

		return null;
	}
}
