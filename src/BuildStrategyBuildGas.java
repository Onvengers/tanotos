
import bwapi.UnitType;
public class BuildStrategyBuildGas extends BuildStrategy {
	
	public BuildStrategyBuildGas()
	{
		setBuildOrder();
	}

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		queueBuild(false, UnitType.Protoss_Assimilator);
	}
}
