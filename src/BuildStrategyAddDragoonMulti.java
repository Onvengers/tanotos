
import bwapi.UnitType;
public class BuildStrategyAddDragoonMulti extends BuildStrategy {
	
	private int unitCount;
	
	public BuildStrategyAddDragoonMulti(int count)
	{
		this.unitCount = count;
	}

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		for(int i=0;i<unitCount;i++)
		{
			queueBuildSeed(false, UnitType.Protoss_Dragoon, BuildOrderItem.SeedPositionStrategy.FirstExpansionLocation);
		}		
	}
}
