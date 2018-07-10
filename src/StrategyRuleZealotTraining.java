import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;

public class StrategyRuleZealotTraining extends StrategyRule {

	public StrategyRuleZealotTraining(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

		if (MyBotModule.Broodwar.self().minerals() >= 50 && MyBotModule.Broodwar.self().gas() >= 150
				&& MyBotModule.Broodwar.self().supplyUsed() < 400) {
			for (Unit unit : MyBotModule.Broodwar.self().getUnits()) {
				if (unit.getType() == UnitType.Protoss_Gateway) {
					if (unit.isTraining() == false || unit.getLarva().size() > 0) {
						if (BuildManager.Instance().buildQueue.getItemCount(UnitType.Protoss_High_Templar, null) == 0) {
							return Strategy.ADD_HIGH_TEMPLER;
						}
					}
				}

			}
			if (MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_High_Templar) >= 2) {
				return Strategy.ADD_ARCHON;
			}
		}

		// 기본 병력 추가 훈련
		if (MyBotModule.Broodwar.self().minerals() >= 100 && MyBotModule.Broodwar.self().supplyUsed() < 400) {
			for (Unit unit : MyBotModule.Broodwar.self().getUnits()) {
				if (unit.getType() == UnitType.Protoss_Gateway) {
					if (unit.isTraining() == false || unit.getLarva().size() > 0) {
						if (BuildManager.Instance().buildQueue.getItemCount(UnitType.Protoss_Zealot, null) == 0) {
							return Strategy.ADD_ZEALOT;
						}
					}
				}
			}
		}

		return null;
	}

}
