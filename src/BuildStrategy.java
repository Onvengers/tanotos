import java.util.List;

/**
 * Build Order Set 으로 적 종족/전략별, 상황에 따른 아군 진형 변경 등에 대한 Build Order Set이다.
 *
 */
public abstract class BuildStrategy {

	public abstract List<BuildOrderItem>getBuildOrder();
}
