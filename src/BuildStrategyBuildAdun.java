
import bwapi.UnitType;

public class BuildStrategyBuildAdun extends BuildStrategy {

	public BuildStrategyBuildAdun() {
		setBuildOrder();
	}

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		queueBuild(true, UnitType.Protoss_Citadel_of_Adun);
	}
}
