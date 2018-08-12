
import bwapi.UnitType;

public class BuildStrategyBuildObserver extends BuildStrategy {

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		queueBuildSeed(true, UnitType.Protoss_Robotics_Facility, BuildOrderItem.SeedPositionStrategy.MainBaseBackYard);
		queueBuildSeed(false, UnitType.Protoss_Observatory, BuildOrderItem.SeedPositionStrategy.MainBaseBackYard);
		queueBuildSeed(false, UnitType.Protoss_Observer, BuildOrderItem.SeedPositionStrategy.FirstExpansionLocation);
		queueBuildSeed(false, UnitType.Protoss_Observer, BuildOrderItem.SeedPositionStrategy.FirstExpansionLocation);
		queueBuildSeed(false, UnitType.Protoss_Observer, BuildOrderItem.SeedPositionStrategy.FirstExpansionLocation);
		queueBuildSeed(false, UnitType.Protoss_Observer, BuildOrderItem.SeedPositionStrategy.FirstExpansionLocation);
	}
}
