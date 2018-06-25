import bwapi.Race;

public class BuildStrategyFactory {

	private static BuildStrategyFactory instance = new BuildStrategyFactory();
	
	public enum Strategies
	{
		//========= 적 종족에 대한 기본 Build Order
		VS_TERRAN,
		VS_ZERG,
		VS_PROTOSS,
		//========= 대비 Build Order
		RESPOND_FAST_ZERGLING,
		RESPOND_PHOTON_RUSH,
		RESPOND_BUNKER_RUSH,
		//========= 테크트리 변형용 Build Order
		CHG_CARRIER,
		CHG_LIVER
		
	}
	
	private BuildStrategyFactory()
	{
		
	}
	
	public static BuildStrategyFactory getInstance()
	{
		return instance;
	}
	
	// 적 종족별 build strategy를 생성함
	public BuildStrategy createBuildStrategy(Race enemy)
	{
		if(enemy == Race.Terran)
		{
			return new BuildStrategyVsTerran();
		}
		
		return null;
	}
	
	// 적 공격전략에 대응하는 build strategy를 생성함 (vs Enemies' Strategy)
	// 상황에 따른 아군 변경 build strategy를 생성함 (Self decision with my status)
	public BuildStrategy createBuildStrategy(Strategies strategy)
	{
		return null;
	}
}
