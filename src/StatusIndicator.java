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
	private Map<UnitType, Position> troopPosition = new HashMap<UnitType, Position>();
	private List <Boolean> commandFlags = new ArrayList<Boolean>();
	private int commandFlagSize = 4;
	private int secondCenterWorkerCount = 0;
	private CommandFlag troopCommandFlag = null;
	public Boolean setAllAttackFlag = false;
	public Boolean setAttackEllie = false;
	
	// 엘리 시키기 - 적군 SIDE1,2,3, 적군 3멀티, 확장1,2,3,4, 아군,적군아닌 Main Center 1,2, CENTER구역.
	public List<Integer> countEllieUnit = new ArrayList<Integer>();
	
	private StatusIndicator() {
		for(int i=0; i< 11; i++) {
			countEllieUnit.add(0);
		}
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
		return mySectionOf;
	}

	public void setMySectionOf(SectionOf mySectionOf) {
		this.mySectionOf = mySectionOf;
	}

	public SectionOf getEnemySectionOf() {
		return enemySectionOf;
	}

	public void setEnemySectionOf(SectionOf enemySectionOf) {
		this.enemySectionOf = enemySectionOf;
	}

	public Position getTroopPosition(UnitType unitType) {
		return troopPosition.get(unitType);
	}

	public void setTroopPosition(UnitType unitType, Position troopPosition) {
		this.troopPosition.put(unitType, troopPosition);
	}
	
	public Boolean getCommandFlag(CommandFlag commandFlag) {
		return commandFlags.get(commandFlag.getValue());
	}

	public void setCommandFlag(CommandFlag commandFlag, Boolean bool) {
		this.commandFlags.set(commandFlag.getValue(), bool);
	}

	public int getCommandFlagSize() {
		return commandFlagSize;
	}

	public int getSecondCenterWorkerCount() {
		return secondCenterWorkerCount;
	}

	public void addSecondCenterWorkerCount() {
		this.secondCenterWorkerCount++;
	}

	public CommandFlag getTroopCommandFlag() {
		return troopCommandFlag;
	}

	public void setTroopCommandFlag(CommandFlag troopCommandFlag) {
		this.troopCommandFlag = troopCommandFlag;
	}
}
