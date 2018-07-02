import bwapi.UnitType;

public class BuildStrategyAddProbeMulti extends BuildStrategy {
	
	private int unitCount;
	
	public BuildStrategyAddProbeMulti(int count)
	{
		this.unitCount = count;
	}

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<unitCount;i++)
		{
			this.queueBuild(true, UnitType.Protoss_Probe);
		}		
	}

}
