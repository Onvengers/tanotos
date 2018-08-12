
import bwapi.UnitType;

public class BuildStrategyBuildPhoto extends BuildStrategy {

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		queueBuildSeed(false, UnitType.Protoss_Photon_Cannon, BuildOrderItem.SeedPositionStrategy.SecondChokePoint);
		queueBuildSeed(false, UnitType.Protoss_Photon_Cannon, BuildOrderItem.SeedPositionStrategy.SecondChokePoint);
	}
}
