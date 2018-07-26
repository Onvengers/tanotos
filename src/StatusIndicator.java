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
	public List<TilePosition> centerPosition = new ArrayList<TilePosition>();
	private Map<Integer, List<TilePosition>> basePositions = new HashMap<>();
	private int centerX[] = { 37, 50, 63, 76, 89, 37, 50, 63, 76, 89, 37, 50, 63, 76, 89 };
	private int centerY[] = { 52, 52, 52, 52, 52, 63, 63, 63, 63, 63, 77, 77, 77, 77, 77 };
	private int baseX[][] = { { 7, 6, 8, 7, 19, 24, 33, 33, 41, 38, 35, 0, 31, 22 },
			{ 117, 122, 118, 117, 109, 102, 94, 94, 87, 90, 89, 126, 98, 109 },
			{ 117, 121, 114, 117, 109, 102, 93, 93, 86, 90, 89, 126, 98, 107 },
			{ 7, 7, 11, 7, 19, 24, 35, 33, 42, 39, 35, 1, 30, 23 } };
	private int baseY[][] = { { 9, 28, 32, 34, 34, 42, 45, 35, 41, 22, 15, 0, 2, 22 },
			{ 9, 26, 32, 34, 33, 4, 45, 36, 41, 22, 15, 2, 4, 24 },
			{ 119, 101, 97, 92, 93, 89, 82, 93, 86, 104, 107, 126, 125, 105 },
			{ 118, 101, 96, 92, 93, 89, 83, 93, 86, 106, 106, 124, 126, 109 } };

	private StatusIndicator() {
		// center1-15까지 x,y좌표를 넣는다.
		for (int i = 0; i < 15; i++) {
			centerPosition.add(new TilePosition(centerX[i], centerY[i]));
		}
		
		basePositions.put(1, new ArrayList<TilePosition>());
		basePositions.put(11, new ArrayList<TilePosition>());
		basePositions.put(5, new ArrayList<TilePosition>());
		basePositions.put(7, new ArrayList<TilePosition>());
		
		for(int i=0; i<14; i++) {
			basePositions.get(11).add(new TilePosition(baseX[0][i], baseY[0][i]));
			basePositions.get(1).add(new TilePosition(baseX[1][i], baseY[1][i]));
			basePositions.get(5).add(new TilePosition(baseX[2][i], baseY[2][i]));
			basePositions.get(7).add(new TilePosition(baseX[3][i], baseY[3][i]));
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
}
