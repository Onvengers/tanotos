
import bwapi.UnitType;
public class BuildStrategyAddZealotMulti extends BuildStrategy {
	
	private int unitCount;
	
	public BuildStrategyAddZealotMulti(int count)
	{
		this.unitCount = count;
	}

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		for(int i=0;i<unitCount;i++)
		{
			queueBuildSeed(false, UnitType.Protoss_Zealot, BuildOrderItem.SeedPositionStrategy.FirstExpansionLocation);
		}		
	}
}
