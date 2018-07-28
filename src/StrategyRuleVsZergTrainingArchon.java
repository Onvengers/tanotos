import javax.net.ssl.SSLEngineResult.Status;

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
			for (Unit unit : TroopManager.Instance().getTroop(UnitType.Protoss_High_Templar).units) {
				if (!(LocationManager.getInstance().isExistsSection(unit, StatusIndicator.Instance().getMySectionOf(),
						MapSection.ENTRANCE_UP, 5 * Config.TILE_SIZE))) {
					return null;
				}
			}
			return Strategy.ADD_ARCHON;
		}

		return null;
	}
}
