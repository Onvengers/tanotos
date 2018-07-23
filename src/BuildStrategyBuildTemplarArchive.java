
import bwapi.UnitType;

public class BuildStrategyBuildTemplarArchive extends BuildStrategy {

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		queueBuild(true, UnitType.Protoss_Templar_Archives);
	}
}