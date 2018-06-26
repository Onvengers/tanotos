
public abstract class BuildRearrangeRule {

	public abstract void rearrange(BuildOrderQueue queue);
	
	public abstract void rearrange(BuildOrderQueue queue, BuildStrategy buildStrategy);
	
	public abstract void rearrange(BuildOrderQueue queue, BuildOrderItem buildOrderItem);
}
