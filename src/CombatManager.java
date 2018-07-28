import java.util.LinkedList;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import bwapi.Position;
import bwapi.UnitType;
import bwta.BWTA;
import bwta.BaseLocation;

public class CombatManager {

	private List<CombatStatement> statements = new LinkedList<CombatStatement>();
	
	private static CombatManager instance = new CombatManager();
	
	public static CombatManager Instance()
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
		Troop zealots = TroopManager.Instance().getTroop(UnitType.Protoss_Zealot);
		Troop dragoons = TroopManager.Instance().getTroop(UnitType.Protoss_Dragoon);
		Troop highTemplers = TroopManager.Instance().getTroop(UnitType.Protoss_High_Templar);
		Troop archons = TroopManager.Instance().getTroop(UnitType.Protoss_Archon);
		Troop workers= TroopManager.Instance().getTroop(UnitType.Protoss_Probe);
		
		// Zealot troop 이 공격준비가 되면 ENEMY_MAIN_CENTER 를 공격한다.
//		addStatement(new CombatStatusReadyToCombat(zealots)
//				, new CombatActionAttackGround(zealots, LocationManager.getInstance().getSectionPosition(SectionOf.CENTER, 1)));
		addStatement(new CombatStatusReadyToCombat(zealots)
				, new CombatActionAttackSection(zealots, StatusIndicator.Instance().getMySectionOf(), MapSection.ENTRANCE_UP));
		addStatement(new CombatStatusReadyToCombat(highTemplers)
				, new CombatActionAttackSection(highTemplers, StatusIndicator.Instance().getMySectionOf(), MapSection.ENTRANCE_UP));
		addStatement(new CombatStatusReadyToCombat(archons)
				, new CombatActionAttackSection(archons, StatusIndicator.Instance().getMySectionOf(), MapSection.ENTRANCE_UP));
//		addStatement(new CombatStatusReadyToCombat(dragoons)
//				, new CombatActionAttackGround(dragoons, LocationManager.getInstance().getSectionPosition(SectionOf.CENTER, 1)));
//		addStatement(new CombatStatusReadyToCombat(workers)
//				, new CombatActionAttackSection(workers, SectionOf.CENTER, MapSection.CENTER1));
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
