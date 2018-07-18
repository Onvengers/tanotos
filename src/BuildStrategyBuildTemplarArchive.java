
import bwapi.UnitType;

public class BuildStrategyBuildTemplarArchive extends BuildStrategy {

	public BuildStrategyBuildTemplarArchive() {
		setBuildOrder();
	}

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		queueBuild(true, UnitType.Protoss_Templar_Archives);
	}
}