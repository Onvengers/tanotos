
import bwapi.UpgradeType;
public class BuildStrategyUpgradePlasma extends BuildStrategy {

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		queueBuild(false, UpgradeType.Protoss_Plasma_Shields);
	}
}
