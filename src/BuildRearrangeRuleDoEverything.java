
public class BuildRearrangeRuleDoEverything extends BuildRearrangeRule{

	@Override
	public void rearrange(BuildOrderQueue queue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rearrange(BuildOrderQueue queue, BuildStrategy buildStrategy) {
		// TODO Auto-generated method stub
		BuildOrderQueue tmpBuildQueue = buildStrategy.getBuildOrder();
		
		while(!tmpBuildQueue.isEmpty())
		{
			queue.queueAsLowestPriority(tmpBuildQueue.getHighestPriorityItem());			
			tmpBuildQueue.removeHighestPriorityItem();
		}
		
	}

	@Override
	public void rearrange(BuildOrderQueue queue, BuildOrderItem buildOrderItem) {
		// TODO Auto-generated method stub
		
	}

}
