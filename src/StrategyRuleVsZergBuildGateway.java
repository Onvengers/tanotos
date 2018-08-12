import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;
import bwapi.UpgradeType;

public class StrategyRuleVsZergBuildGateway extends StrategyRule {

	public StrategyRuleVsZergBuildGateway(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

		if (MyBotModule.Broodwar.getFrameCount() % 120 != 0) {
			return null;
		}

		if (MyBotModule.Broodwar.self().allUnitCount(UnitType.Protoss_Gateway)
				+ BuildManager.Instance().buildQueue.getItemCount(UnitType.Protoss_Gateway) < 1
				&& MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_Probe) > 7) {
			return Strategy.BUILD_GATEWAY;
		}

		else if ((MyBotModule.Broodwar.self().allUnitCount(UnitType.Protoss_Gateway)
				+ BuildManager.Instance().buildQueue.getItemCount(UnitType.Protoss_Gateway)) < 2
				&& MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_Probe) > 10) {
			return Strategy.BUILD_GATEWAY;
		}

		else if (MyBotModule.Broodwar.self().minerals() > 400
				&& MyBotModule.Broodwar.self().allUnitCount(UnitType.Protoss_Gateway)
						+ BuildManager.Instance().buildQueue.getItemCount(UnitType.Protoss_Gateway) < 6
				&& MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_Probe) > 20
				&& MyBotModule.Broodwar.self().allUnitCount(UnitType.Protoss_Nexus) > 1) {
			return Strategy.BUILD_GATEWAY;
		}
		else if (MyBotModule.Broodwar.self().minerals() > 400
				&& MyBotModule.Broodwar.self().allUnitCount(UnitType.Protoss_Gateway)
						+ BuildManager.Instance().buildQueue.getItemCount(UnitType.Protoss_Gateway) < 8
				&& MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_Probe) > 20
				&& MyBotModule.Broodwar.self().allUnitCount(UnitType.Protoss_Nexus) > 2) {
			return Strategy.BUILD_GATEWAY;
		}

		return null;
	}

}
