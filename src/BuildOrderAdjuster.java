import java.util.Deque;
import java.util.List;

import bwapi.Race;
import bwapi.TechType;
import bwapi.UnitType;
import bwapi.UpgradeType;

/*
 * Build Order를 가치 있게 재조정(Rearrange) 또는 편집한다.
 * RearrangeRule을 관리하고 수행한다.
 */

public class BuildOrderAdjuster {

	private static BuildOrderAdjuster instance = new BuildOrderAdjuster();
	// Rearrange rules
	private List<BuildRearrangeRule> lstRearrangeRules;
		
	private BuildOrderAdjuster()
	{
		
	}
	
	public static BuildOrderAdjuster getInstance()
	{
		return instance;
	}

	public void rearrangeBuildOrders(BuildStrategy buildStrategy)
	{
		BuildRearrangeRule rule;
		
		for(int i=0;i<lstRearrangeRules.size();i++)
		{
			rule = lstRearrangeRules.get(i);
			rule.rearrange(BuildManager.Instance().buildQueue, buildStrategy);
		}
	}
	
	public void rearrangeBuildOrders(BuildOrderItem buildOrderItem)
	{	
		BuildRearrangeRule rule;
		
		for(int i=0;i<lstRearrangeRules.size();i++)
		{
			rule = lstRearrangeRules.get(i);
			rule.rearrange(BuildManager.Instance().buildQueue, buildOrderItem);
		}
	}

}
