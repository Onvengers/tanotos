
import bwapi.UpgradeType;
public class BuildStrategyUpgradeDragoonRangeUp extends BuildStrategy {

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		queueBuild(false, UpgradeType.Singularity_Charge);
	}
}
