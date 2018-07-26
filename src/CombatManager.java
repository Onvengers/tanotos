import java.util.LinkedList;
import java.util.List;

import bwapi.Position;
import bwapi.UnitType;

public class CombatManager {

	private List<CombatStatement> statements = new LinkedList<CombatStatement>();
	
	private static CombatManager instance = new CombatManager();
	
	public static CombatManager getInstance()
	{
		return instance;
	}
	
	private CombatManager()
	{
		initStatements();
	}
	
	private void initStatements()
	{
		// 기본 전투 statements 추가
		Troop zealots = TroopManager.getInstance().getTroop(UnitType.Protoss_Zealot);
		Troop dragoons = TroopManager.getInstance().getTroop(UnitType.Protoss_Dragoon);		
		Position enemyCenter = LocationManager.getInstance().getAbsolutePosition(MapSection.ENEMY_MAIN_CENTER);
		
		// Zealot troop 이 공격준비가 되면 ENEMY_MAIN_CENTER 를 공격한다.
		addStatement(new CombatStatusReadyToCombat(zealots)
				, new CombatActionAttackGround(zealots, enemyCenter));
	}
	
	public void addStatement(ICombatStatus cs, ICombatAction ca)
	{
		addStatement(new CombatStatement(cs, ca));
	}
	
	public void addStatement(CombatStatement statement)
	{
		statements.add(statement);
	}
	
	public void update()
	{
		for(CombatStatement statement : statements)
		{
			statement.execute();
		}
	}
}
