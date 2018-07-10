
import bwapi.UnitType;
public class BuildStrategyAddArchonMulti extends BuildStrategy {
	
	private int unitCount;
	
	public BuildStrategyAddArchonMulti(int count)
	{
		this.unitCount = count;
		setBuildOrder();
	}

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		for(int i=0;i<unitCount;i++)
		{
			queueBuildSeed(false, UnitType.Protoss_Archon, BuildOrderItem.SeedPositionStrategy.FirstExpansionLocation);
		}		
	}
}
