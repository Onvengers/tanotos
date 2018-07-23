
import bwapi.UnitType;

public class BuildStrategyBuildForge extends BuildStrategy {

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		queueBuild(true, UnitType.Protoss_Forge);
	}
}
