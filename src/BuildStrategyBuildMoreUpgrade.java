
import bwapi.UnitType;

public class BuildStrategyBuildMoreUpgrade extends BuildStrategy {

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		queueBuild(false, UnitType.Protoss_Templar_Archives);
		queueBuild(false, UnitType.Protoss_Forge);
	}
}