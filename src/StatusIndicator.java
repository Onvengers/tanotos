import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bwapi.Position;
import bwapi.TilePosition;
import bwapi.Unit;
import bwapi.UnitType;

/**
 * 상태 지표 생성 상태 지표 - 전략/전투 등에서의 각종 판단을 위한 지표들을 생성하고 관리
 * 
 * @author myboy
 *
 */
public class StatusIndicator {

	private static StatusIndicator instance = new StatusIndicator();
	private Map<UnitType, Integer> unitCount = new HashMap<UnitType, Integer>();
	private SectionOf mySectionOf = null;
	private SectionOf enemySectionOf = null;

	private StatusIndicator() {
		
	}

	public static StatusIndicator Instance() {
		return instance;
	}

	public int getUnitCount(UnitType unitType) {
		return unitCount.get(unitType).intValue();
	}

	public void addUnitCount(MetaType metaType, int count) {
		if (metaType.isUnit() == true) {
			unitCount.put(metaType.getUnitType(), unitCount.get(metaType.getUnitType()) + count);
		}
		return;
	}

	public SectionOf getMySectionOf() {
		System.out.println("MySection : " + mySectionOf);
		return mySectionOf;
	}

	public void setMySectionOf(SectionOf mySectionOf) {
		this.mySectionOf = mySectionOf;
	}

	public SectionOf getEnemySectionOf() {
		System.out.println("enemySectionOf : " + enemySectionOf);
		return enemySectionOf;
	}

	public void setEnemySectionOf(SectionOf enemySectionOf) {
		this.enemySectionOf = enemySectionOf;
	}
}
