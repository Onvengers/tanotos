
import bwapi.UnitType;

public class BuildStrategyBuildUnitObserver extends BuildStrategy {

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		queueBuildSeed(false, UnitType.Protoss_Observer, BuildOrderItem.SeedPositionStrategy.FirstExpansionLocation);
		queueBuildSeed(false, UnitType.Protoss_Observer, BuildOrderItem.SeedPositionStrategy.FirstExpansionLocation);
	}
}
