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
	
	// 적 공격전략에 대응하는 build strategy를 생성함 (vs Enemies' Strategy)
	// 상황에 따른 아군 변경 build strategy를 생성함 (Self decision with my status)
	public BuildStrategy createBuildStrategy(Strategy strategy)
	{
		return null;
	}
}
