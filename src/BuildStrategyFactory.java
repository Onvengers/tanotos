import bwapi.Race;

public class BuildStrategyFactory {

	private static BuildStrategyFactory instance = new BuildStrategyFactory();

	private BuildStrategyFactory()
	{
		
	}
	
	public static BuildStrategyFactory getInstance()
	{
		return instance;
	}
	
	public BuildStrategyFactor createBuildStrategyFactor(Strategy strategy)
	{
		return null;
	}
	
	// 적 종족별 build strategy를 생성함
	public BuildStrategy createBuildStrategy(Race enemy)
	{
		if(enemy == Race.Terran)
		{
			return new BuildStrategyVsTerran();
		}
		else if(enemy == Race.Zerg)
		{
			return new BuildStrategyVsZerg();
		} 
		else if(enemy == Race.Protoss)
		{
			return new BuildStrategyVsProtoss();
		}
		
		return new BuildStrategyVsRandom();
	}
	
	public BuildStrategy createBuildStrategy(Strategy strategy)
	{
		BuildStrategy bs;
		
		//건물생산
		if (strategy == Strategy.BUILD_SUPPLY)
		{
			bs = new BuildStrategyBuildSupplyMulti(1);
			bs.setMyStrategy(Strategy.BUILD_SUPPLY);
		}
		else if (strategy == Strategy.BUILD_GAS)
		{
			bs = new BuildStrategyBuildGas();
			bs.setMyStrategy(Strategy.BUILD_GAS);
		}
		else if (strategy == Strategy.BUILD_GATEWAY)
		{
			bs = new BuildStrategyBuildGatewayMulti(1);
			bs.setMyStrategy(Strategy.BUILD_GATEWAY);
		}
		else if (strategy == Strategy.BUILD_FORGE)
		{
			bs = new BuildStrategyBuildForge();
			bs.setMyStrategy(Strategy.BUILD_FORGE);
		}
		else if (strategy == Strategy.BUILD_CORE)
		{
			bs = new BuildStrategyBuildCore();
			bs.setMyStrategy(Strategy.BUILD_CORE);
		}
		else if (strategy == Strategy.BUILD_ADUN)
		{
			bs = new BuildStrategyBuildAdun();
			bs.setMyStrategy(Strategy.BUILD_ADUN);
		}
		
		//유닛생산
		else if(strategy == Strategy.ADD_PROBE)
		{	
			bs = new BuildStrategyAddProbeMulti(1);
			bs.setMyStrategy(Strategy.ADD_PROBE);
		}
		else if (strategy == Strategy.ADD_ZEALOT)
		{
			bs = new BuildStrategyAddZealotMulti(1);
			bs.setMyStrategy(Strategy.ADD_ZEALOT);
		}
		else if (strategy == Strategy.ADD_HIGH_TEMPLER)
		{
			bs = new BuildStrategyAddHighTemplerMulti(1);
			bs.setMyStrategy(Strategy.ADD_HIGH_TEMPLER);
		}
		else if (strategy == Strategy.ADD_ARCHON)
		{
			bs = new BuildStrategyAddArchonMulti(1);
			bs.setMyStrategy(Strategy.ADD_ARCHON);
		}
		
		//업그레이드
		else if (strategy == Strategy.UPGRADE_WEAPON)
		{
			bs = new BuildStrategyUpgradeGroundWeapon();
			bs.setMyStrategy(Strategy.UPGRADE_WEAPON);
		}
		else if (strategy == Strategy.UPGRADE_ARMOR)
		{
			bs = new BuildStrategyUpgradeGroundArmor();
			bs.setMyStrategy(Strategy.UPGRADE_ARMOR);
		}
		else if (strategy == Strategy.UPGRADE_PLASMA)
		{
			bs = new BuildStrategyUpgradePlasma();
			bs.setMyStrategy(Strategy.UPGRADE_PLASMA);
		}
		else if (strategy == Strategy.UPGRADE_ZEALOT_LEG)
		{
			bs = new BuildStrategyUpgradeZealotLeg();
			bs.setMyStrategy(Strategy.UPGRADE_ZEALOT_LEG);
		}
		
		else
		{
			bs = null;
		}
		
		return bs;
	}
}
