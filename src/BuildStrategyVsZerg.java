import bwapi.UnitType;
import bwapi.UpgradeType;

public class BuildStrategyVsZerg extends BuildStrategy {

	public BuildStrategyVsZerg() {
		// TODO Auto-generated constructor stub
		queueBuild(true, UnitType.Protoss_Probe, UnitType.Protoss_Probe, UnitType.Protoss_Probe, UnitType.Protoss_Probe, UnitType.Protoss_Probe);
		queueBuild(true, UnitType.Protoss_Gateway);
		queueBuild(true, UnitType.Protoss_Probe);
		queueBuild(true, UnitType.Protoss_Gateway);
		queueBuild(true, UnitType.Protoss_Zealot, UnitType.Protoss_Zealot, UnitType.Protoss_Zealot);
		queueBuild(false, UnitType.Protoss_Assimilator);
		queueBuild(false, UnitType.Protoss_Forge);
		queueBuild(false, UpgradeType.Protoss_Ground_Weapons);
		queueBuild(false, UnitType.Protoss_Cybernetics_Core);
		queueBuild(false, UnitType.Protoss_Citadel_of_Adun);
		queueBuild(false, UnitType.Protoss_Zealot, UnitType.Protoss_Zealot);
		queueBuild(false, UnitType.Protoss_Templar_Archives);
	}
	
	@Override
	public void setBuildOrder() {
		// TODO Auto-generated method stub
		
	}

}
