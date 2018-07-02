
/**
 * 전략을 도출하는 판정 기준으로 상태정보를 기반으로 Strategy를 도출하는 클래스의 상위 클래스
 * 
 * @author lazydvlpr
 *
 */
public abstract class StrategyRule {

	protected StrategyType myType;
	
	public StrategyRule(StrategyType type)
	{
		this.myType = type;
	}
	
	public StrategyType getStrategyType()
	{
		return this.myType;
	}
	
	public abstract Strategy judgeStrategy();
}
