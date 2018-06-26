import bwapi.TechType;
import bwapi.UnitType;
import bwapi.UpgradeType;

/**
 * Build Order Set 으로 적 종족/전략별, 상황에 따른 아군 진형 변경 등에 대한 Build Order Set이다.
 *
 */
public abstract class BuildStrategy {

	private BuildOrderQueue tmpBuildQueue = new BuildOrderQueue();
	
	public abstract void setBuildOrder();
	
	public BuildOrderQueue getBuildOrder()
	{
		return tmpBuildQueue;
	}
	
	protected void clearQueue()
	{
		tmpBuildQueue.clearAll();
	}

	protected void queueBuild(boolean blocking, UnitType... types) {
		
		BuildOrderItem.SeedPositionStrategy defaultSeedPosition = BuildOrderItem.SeedPositionStrategy.MainBaseLocation;
		for (UnitType type : types) {
			tmpBuildQueue.queueAsLowestPriority(type, defaultSeedPosition, blocking);
		}
	}
	
	protected void queueBuildSeed(boolean blocking, UnitType type, BuildOrderItem.SeedPositionStrategy seedPosition) {

		tmpBuildQueue.queueAsLowestPriority(type, seedPosition, blocking);
	}
	
	protected void queueBuild(TechType type) {

		tmpBuildQueue.queueAsLowestPriority(type);
	}
	
	protected void queueBuild(UpgradeType type) {

		tmpBuildQueue.queueAsLowestPriority(type);
	}
}
