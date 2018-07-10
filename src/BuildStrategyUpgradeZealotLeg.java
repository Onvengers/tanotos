
import bwapi.UnitType;
import bwapi.UpgradeType;
public class BuildStrategyUpgradeZealotLeg extends BuildStrategy {
	
	public BuildStrategyUpgradeZealotLeg()
	{
		setBuildOrder();
	}

	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		queueBuild(false, UpgradeType.Leg_Enhancements);
	}
}
