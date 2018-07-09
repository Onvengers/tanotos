import java.util.Deque;
import java.util.LinkedList;
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
	private List<BuildRearrangeRule> lstRearrangeRules = new LinkedList<>();
		
	private BuildOrderAdjuster()
	{
		
	}
	
	public static BuildOrderAdjuster getInstance()
	{
		return instance;
	}

	public void initialBuildOrders(BuildStrategy buildStrategy)
	{
		while(buildStrategy.getBuildOrder().isEmpty() == false)
		{
			BuildManager.Instance().buildQueue.queueItem(buildStrategy.getBuildOrder().getHighestPriorityItem());
			buildStrategy.getBuildOrder().removeHighestPriorityItem();
		}
	}
	
	public void setRearrangeRules(BuildRearrangeRule buildRearrangeRule) 
	{
		lstRearrangeRules.add(buildRearrangeRule);
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
