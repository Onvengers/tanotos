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
		if(strategy == Strategy.ADD_PROBE)
		{	
			bs = new BuildStrategyAddProbeMulti(1);
			bs.setMyStrategy(Strategy.ADD_PROBE);
		}
		else if (strategy == Strategy.ADD_SUPPLY)
		{
			bs = new BuildStrategyAddSupplyMulti(1);
			bs.setMyStrategy(Strategy.ADD_SUPPLY);
		}
		else if (strategy == Strategy.ADD_GATEWAY)
		{
			bs = new BuildStrategyAddGatewayMulti(1);
			bs.setMyStrategy(Strategy.ADD_GATEWAY);
		}
		else if (strategy == Strategy.ADD_ZEALOT)
		{
			bs = new BuildStrategyAddZealotMulti(1);
			bs.setMyStrategy(Strategy.ADD_ZEALOT);
		}
		else if (strategy == Strategy.ADD_GAS)
		{
			bs = new BuildStrategyAddGas();
			bs.setMyStrategy(Strategy.ADD_GAS);
		}
		else
		{
			bs = null;
		}
		
		return bs;
	}
}
