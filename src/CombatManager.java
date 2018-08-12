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

	public static CombatManager Instance() {
		return instance;
	}

	private CombatManager() {
		initStatements();
	}

	private void initStatements() {
		// 기본 전투 statements 추가
		Troop zealots = TroopManager.Instance().getTroop(UnitType.Protoss_Zealot);
		Troop dragoons = TroopManager.Instance().getTroop(UnitType.Protoss_Dragoon);
		Troop observers = TroopManager.Instance().getTroop(UnitType.Protoss_Observer);

		addStatement(new CombatStatusHowToCombat(zealots), new CombatActionAttackSection(zealots));
		addStatement(new CombatStatusHowToCombat(dragoons), new CombatActionAttackSection(dragoons));
		addStatement(new CombatStatusHowToCombat(observers), new CombatActionAttackSection(observers));
	}

	public void addStatement(ICombatStatus cs, ICombatAction ca) {
		addStatement(new CombatStatement(cs, ca));
	}

	public void addStatement(CombatStatement statement) {
		statements.add(statement);
	}

	public void update() {
		for (CombatStatement statement : statements) {
			statement.execute();
		}
	}
}
