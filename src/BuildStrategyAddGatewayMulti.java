
import bwapi.UnitType;
public class BuildStrategyAddGatewayMulti extends BuildStrategy {
	
	private int unitCount;
	
	public BuildStrategyAddGatewayMulti(int count)
	{
		this.unitCount = count;
		setBuildOrder();
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
