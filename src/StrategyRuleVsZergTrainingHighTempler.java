import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;

public class StrategyRuleVsZergTrainingHighTempler extends StrategyRule {

	public StrategyRuleVsZergTrainingHighTempler(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

		if (MyBotModule.Broodwar.self().minerals() >= 50 && MyBotModule.Broodwar.self().gas() >= 150
				&& MyBotModule.Broodwar.self().supplyUsed() < 400) {
			for (Unit unit : MyBotModule.Broodwar.self().getUnits()) {
				if (unit.getType() == UnitType.Protoss_Gateway && unit.isTraining() == false
						&& unit.canTrain(UnitType.Protoss_High_Templar) == true) {
					if (BuildManager.Instance().buildQueue.getItemCount(UnitType.Protoss_High_Templar, null) == 0) {
						return Strategy.ADD_HIGH_TEMPLER;
					}
				}
			}
		}

		return null;
	}
}
