import java.util.Deque;
import java.util.List;

import bwapi.Race;
import bwapi.TechType;
import bwapi.UnitType;
import bwapi.UpgradeType;

/*
 * Build Order를 가치 있게 재조정(Rearrange) 또는 편집한다.
 * RearrangeRule을 관리하고 수행한다.
 */

public class BuildOrderAdjuster {

	private static BuildOrderAdjuster instance = new BuildOrderAdjuster();

	private BuildOrderAdjuster()
	{
		
	}
	
	public static BuildOrderAdjuster getInstance()
	{
		return instance;
	}

	// Rearrange rules
	private List<BuildRearrangeRule> lstRearrangeRules;
	
	public void rearrangeBuildOrders()
	{
		Deque tmpQueue = BuildManager.Instance().buildQueue.getQueue();
		
		
	}
	
	
	
	public void queueBuild(boolean blocking, UnitType... types) {
		
		BuildOrderItem.SeedPositionStrategy defaultSeedPosition = BuildOrderItem.SeedPositionStrategy.MainBaseLocation;
		
		BuildOrderQueue bq = BuildManager.Instance().buildQueue;		
		for (UnitType type : types) {
			bq.queueAsLowestPriority(type, defaultSeedPosition, blocking);
		}
	}
	
	public void queueBuildSeed(boolean blocking, UnitType type, BuildOrderItem.SeedPositionStrategy seedPosition) {
				
		BuildOrderQueue bq = BuildManager.Instance().buildQueue;
		bq.queueAsLowestPriority(type, seedPosition, blocking);
	}
	
	public void queueBuild(TechType type) {
		
		BuildOrderQueue bq = BuildManager.Instance().buildQueue;
		bq.queueAsLowestPriority(type);
	}
	
	public void queueBuild(UpgradeType type) {
		
		BuildOrderQueue bq = BuildManager.Instance().buildQueue;
		bq.queueAsLowestPriority(type);
	}

	
}
