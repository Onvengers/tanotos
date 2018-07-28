import bwapi.UnitType;

// 특정 troop 이 공격 준비가 끝났는지 판단한다.
public class CombatStatusReadyToCombat implements ICombatStatus {

	private final Troop troop;
	
	public CombatStatusReadyToCombat(Troop troop)
	{
		this.troop = troop;
	}
	
	@Override
	public boolean checkCombatStatus() {
		
		if(troop instanceof DefaultTroop)
		{
			if(((DefaultTroop) troop).getUnitType() == UnitType.Protoss_Zealot
					&& true /* 전투 준비 완료 조건 */)
			{
				return true;
			}
			else if(((DefaultTroop) troop).getUnitType() == UnitType.Protoss_Dragoon
					&& troop.getSize() > 2 /* 전투 준비 완료 조건 */)
			{
				return true;
			}
			else if(((DefaultTroop) troop).getUnitType() == UnitType.Protoss_High_Templar
					&& true /* 전투 준비 완료 조건 */)
			{
				return true;
			}
			else if(((DefaultTroop) troop).getUnitType() == UnitType.Protoss_Archon
					&& true /* 전투 준비 완료 조건 */)
			{
				return true;
			}
			else if(((DefaultTroop) troop).getUnitType() == UnitType.Protoss_Probe
					&& troop.getSize() > 5 /* 전투 준비 완료 조건 */)
			{
				return false;
			}
		}
		else
		{
			// decision for custom Troop
		}
		return false;
	}

}
