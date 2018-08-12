import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;

public class StrategyRuleVsZergTrainingDragoon extends StrategyRule {

	public StrategyRuleVsZergTrainingDragoon(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

		if (MyBotModule.Broodwar.self().minerals() >= 100 && MyBotModule.Broodwar.self().gas() >= 50
				&& MyBotModule.Broodwar.self().supplyUsed() < 400) {
			for (Unit unit : MyBotModule.Broodwar.self().getUnits()) {
				if ((unit.getType() == UnitType.Protoss_Gateway) && (unit.isTraining() == false)) {
					if (BuildManager.Instance().buildQueue.getItemCount(UnitType.Protoss_Dragoon, null) == 0) {
						return Strategy.ADD_DRAGOON;
					}
				}
			}
		}

		return null;
	}
}
