
import bwapi.UnitType;
public class BuildStrategyAddSupplyMulti extends BuildStrategy {
	
	private int unitCount;
	
	public BuildStrategyAddSupplyMulti(int count)
	{
		this.unitCount = count;
		setBuildOrder();
	}

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		for(int i=0;i<unitCount;i++)
		{
			queueBuild(true, UnitType.Protoss_Pylon);
		}		
	}
}
