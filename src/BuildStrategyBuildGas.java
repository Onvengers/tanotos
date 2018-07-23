
import bwapi.UnitType;
public class BuildStrategyBuildGas extends BuildStrategy {

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		queueBuild(false, UnitType.Protoss_Assimilator);
	}
}
