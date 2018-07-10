import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;

public class StrategyRuleVsZergTrainingArchon extends StrategyRule {

	public StrategyRuleVsZergTrainingArchon(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

		if (MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_High_Templar) >= 2
				&& BuildManager.Instance().buildQueue.getItemCount(UnitType.Protoss_Archon) == 0) {
			return Strategy.ADD_ARCHON;
		}

		return null;
	}
}
