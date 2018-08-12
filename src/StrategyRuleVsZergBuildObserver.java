import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;
import bwapi.UpgradeType;

public class StrategyRuleVsZergBuildObserver extends StrategyRule {

	private boolean chkBuildObserver = false;

	public StrategyRuleVsZergBuildObserver(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

		if (MyBotModule.Broodwar.getFrameCount() % 120 != 0) {
			return null;
		}
		
		if(MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_Observatory) > 0 
				&& MyBotModule.Broodwar.self().allUnitCount(UnitType.Protoss_Observer) == 0
				&& BuildManager.Instance().buildQueue.getItemCount(UnitType.Protoss_Observer) == 0) {
			return Strategy.BUILD_UNIT_OBSERVER;
		}
		
		if(chkBuildObserver == true) {
			return null;
		}

		if (MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_Nexus) > 1) {
			chkBuildObserver = true;
			return Strategy.BUILD_OBSERVER;
		}

		return null;
	}
}
