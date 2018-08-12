
import bwapi.UnitType;

public class BuildStrategyBuildSupplyMulti extends BuildStrategy {

	private int unitCount;
	private BuildOrderItem.SeedPositionStrategy seedPosition = BuildOrderItem.SeedPositionStrategy.MainBaseLocation;
	public BuildStrategyBuildSupplyMulti(int count) {
		this.unitCount = count;
	}

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		if (MyBotModule.Broodwar.self().allUnitCount(UnitType.Protoss_Gateway) > 2) {
			unitCount = 2;
			seedPosition = BuildOrderItem.SeedPositionStrategy.MainBaseBackYard;
		}
		if (MyBotModule.Broodwar.self().completedUnitCount(UnitType.Protoss_Nexus) > 1) {
			unitCount = 3;
			seedPosition = BuildOrderItem.SeedPositionStrategy.MainBaseLocation;
		}
		for (int i = 0; i < unitCount; i++) {
			queueBuildSeed(true, UnitType.Protoss_Pylon, seedPosition);
		}
	}
}
