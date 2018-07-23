
import bwapi.UnitType;
public class BuildStrategyBuildGatewayMulti extends BuildStrategy {
	
	private int unitCount;
	
	public BuildStrategyBuildGatewayMulti(int count)
	{
		this.unitCount = count;
	}

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		for(int i=0;i<unitCount;i++)
		{
			queueBuild(true, UnitType.Protoss_Gateway);
		}		
	}
}
