
import bwapi.UnitType;

public class BuildStrategyBuildCore extends BuildStrategy {

	public BuildStrategyBuildCore() {
		setBuildOrder();
	}

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		queueBuild(true, UnitType.Protoss_Cybernetics_Core);
	}
}
