import bwapi.Position;
import bwapi.Unit;

public class CombatStatement {

	/*
	 * Param #1 : 판단 행위 주체
	 * Param #2 : 장소 파라미터
	 * Param #3 : 판단 행위 조건
	 * Param #4 : 액션 행위 주체
	 * Param #5 : 장소 파라미터
	 * Param #6 : 액션 행위 대상
	 * Param #7 : 액션 행위
	 * 
	 * 0 : CombatStatus 가 만족하지 않음
	 * 1 : CombatStatus 가 만족해서 Action 수행함
	 * 2 : CombatStatus 가 없어서  Action 수행함
	 */
	
	private ICombatStatus condStatus;
	private ICombatAction actAction;

	public CombatStatement(ICombatStatus condStatus, ICombatAction actAction)
	{
		this.condStatus = condStatus;
		this.actAction = actAction;
	}
	
	public int execute()
	{		
		if(condStatus != null)
		{
			if(condStatus.checkCombatStatus())
			{
				actAction.act();
				return 1;  
			}
			else
			{
				return 0;
			}
		}
		else
		{
			actAction.act();
			return 2;
		}
	}
	
}
