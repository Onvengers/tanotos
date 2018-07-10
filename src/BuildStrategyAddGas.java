
import bwapi.UnitType;
public class BuildStrategyAddGas extends BuildStrategy {
	
	public BuildStrategyAddGas()
	{
		setBuildOrder();
	}

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		queueBuild(false, UnitType.Protoss_Assimilator);
	}
}
