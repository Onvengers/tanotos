import bwapi.Race;
import bwapi.Unit;
import bwapi.UnitType;
import bwapi.UpgradeType;
import bwapi.WeaponType;

public class StrategyRuleVsZergUpgradeOnForge extends StrategyRule {

	public StrategyRuleVsZergUpgradeOnForge(StrategyType type) {
		super(type);
	}

	@Override
	public Strategy judgeStrategy() {

		if (MyBotModule.Broodwar.getFrameCount() % 24 != 0
				|| (BuildManager.Instance().buildQueue.getItemCount(UpgradeType.Protoss_Ground_Weapons)) > 0
				|| (BuildManager.Instance().buildQueue.getItemCount(UpgradeType.Protoss_Ground_Armor)) > 0
				|| (BuildManager.Instance().buildQueue.getItemCount(UpgradeType.Protoss_Plasma_Shields)) > 0
				|| (MyBotModule.Broodwar.self().allUnitCount(UnitType.Protoss_Forge) == 0)) {
			return null;
		}

		for (Unit unit : MyBotModule.Broodwar.self().getUnits()) {
			if (unit.getType() == UnitType.Protoss_Forge && unit.isTraining() == false) {
				if (unit.canUpgrade(UpgradeType.Protoss_Ground_Weapons)) {
					return Strategy.UPGRADE_WEAPON;
				} else if (unit.canUpgrade(UpgradeType.Protoss_Ground_Armor)) {
					return Strategy.UPGRADE_ARMOR;
				} else if (unit.canUpgrade(UpgradeType.Protoss_Plasma_Shields)) {
					return Strategy.UPGRADE_PLASMA;
				}
			}
		}

		return null;
	}
}
