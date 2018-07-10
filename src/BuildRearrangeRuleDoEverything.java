
public class BuildRearrangeRuleDoEverything extends BuildRearrangeRule{

	@Override
	public void rearrange(BuildOrderQueue queue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rearrange(BuildOrderQueue queue, BuildStrategy buildStrategy) {
		// TODO Auto-generated method stub
		BuildOrderQueue tmpBuildQueue = buildStrategy.getBuildOrder();
		for(int i=0; i<tmpBuildQueue.size(); i++) {
			BuildManager.Instance().buildQueue.queueAsLowestPriority(tmpBuildQueue.getHighestPriorityItem());
		}
		
	}

	@Override
	public void rearrange(BuildOrderQueue queue, BuildOrderItem buildOrderItem) {
		// TODO Auto-generated method stub
		
	}

}
