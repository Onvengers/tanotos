
import bwapi.UnitType;
import bwapi.UpgradeType;
public class BuildStrategyUpgradeGroundWeapon extends BuildStrategy {
	
	public BuildStrategyUpgradeGroundWeapon()
	{
		setBuildOrder();
	}

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		queueBuild(false, UpgradeType.Protoss_Ground_Weapons);
	}
}
