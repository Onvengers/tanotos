
import bwapi.UnitType;

public class BuildStrategyBuildSecondCenter extends BuildStrategy {

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		queueBuildSeed(true, UnitType.Protoss_Nexus, BuildOrderItem.SeedPositionStrategy.FirstExpansionLocation);
		queueBuildSeed(true, UnitType.Protoss_Pylon, BuildOrderItem.SeedPositionStrategy.FirstExpansionLocation);
	}
}
