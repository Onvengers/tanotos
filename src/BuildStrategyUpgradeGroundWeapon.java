
import bwapi.UpgradeType;
public class BuildStrategyUpgradeGroundWeapon extends BuildStrategy {

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		queueBuild(false, UpgradeType.Protoss_Ground_Weapons);
	}
}
