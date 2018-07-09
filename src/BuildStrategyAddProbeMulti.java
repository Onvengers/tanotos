
import bwapi.UnitType;
public class BuildStrategyAddProbeMulti extends BuildStrategy {
	
	private int unitCount;
	
	public BuildStrategyAddProbeMulti(int count)
	{
		this.unitCount = count;
		setBuildOrder();
	}

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		System.out.println("3");
		for(int i=0;i<unitCount;i++)
		{
			System.out.println("4");
			queueBuild(true, UnitType.Protoss_Probe);
		}		
	}
}
