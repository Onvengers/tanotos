
import bwapi.UnitType;
public class BuildStrategyAddHighTemplerMulti extends BuildStrategy {
	
	private int unitCount;
	
	public BuildStrategyAddHighTemplerMulti(int count)
	{
		this.unitCount = count;
	}

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		for(int i=0;i<unitCount;i++)
		{
			queueBuildSeed(false, UnitType.Protoss_High_Templar, BuildOrderItem.SeedPositionStrategy.FirstExpansionLocation);
		}		
	}
}
