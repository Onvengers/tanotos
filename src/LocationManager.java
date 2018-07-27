import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bwapi.Position;
import bwapi.TilePosition;
import bwapi.Unit;

public class LocationManager {

	private static LocationManager instance = new LocationManager();
	private Map<Integer, List<TilePosition>> sectionPosition = new HashMap<>();
	private int centerX[] = { 37, 50, 63, 76, 89, 37, 50, 63, 76, 89, 37, 50, 63, 76, 89 };
	private int centerY[] = { 52, 52, 52, 52, 52, 63, 63, 63, 63, 63, 77, 77, 77, 77, 77 };
	private int sectionX[][] = { { 7, 6, 8, 7, 19, 24, 33, 33, 41, 38, 35, 0, 31, 22 },
			{ 117, 122, 118, 117, 109, 102, 94, 94, 87, 90, 89, 126, 98, 109 },
			{ 117, 121, 114, 117, 109, 102, 93, 93, 86, 90, 89, 126, 98, 107 },
			{ 7, 7, 11, 7, 19, 24, 35, 33, 42, 39, 35, 1, 30, 23 } };
	private int sectionY[][] = { { 9, 28, 32, 34, 34, 42, 45, 35, 41, 22, 15, 0, 2, 22 },
			{ 9, 26, 32, 34, 33, 4, 45, 36, 41, 22, 15, 2, 4, 24 },
			{ 119, 101, 97, 92, 93, 89, 82, 93, 86, 104, 107, 126, 125, 105 },
			{ 118, 101, 96, 92, 93, 89, 83, 93, 86, 106, 106, 124, 126, 109 } };

	private LocationManager() {

		sectionPosition.put(SectionOf.CENTER.getValue(), new ArrayList<TilePosition>());
		sectionPosition.put(SectionOf.ELEVEN_CLOCK.getValue(), new ArrayList<TilePosition>());
		sectionPosition.put(SectionOf.ONE_CLOCK.getValue(), new ArrayList<TilePosition>());
		sectionPosition.put(SectionOf.FIVE_CLOCK.getValue(), new ArrayList<TilePosition>());
		sectionPosition.put(SectionOf.SEVEN_CLOCK.getValue(), new ArrayList<TilePosition>());

		// center1-15까지 x,y좌표를 넣는다.
		for (int i = 0; i < 15; i++) {
			sectionPosition.get(SectionOf.CENTER.getValue()).add(new TilePosition(centerX[i], centerY[i]));
		}

		// 11시, 1시, 5시, 7시 방향의 Section들의 x,y좌표를 넣는다.
		for (int i = 0; i < 14; i++) {
			sectionPosition.get(SectionOf.ELEVEN_CLOCK.getValue()).add(new TilePosition(sectionX[0][i], sectionY[0][i]));
			sectionPosition.get(SectionOf.ONE_CLOCK.getValue()).add(new TilePosition(sectionX[1][i], sectionY[1][i]));
			sectionPosition.get(SectionOf.FIVE_CLOCK.getValue()).add(new TilePosition(sectionX[2][i], sectionY[2][i]));
			sectionPosition.get(SectionOf.SEVEN_CLOCK.getValue()).add(new TilePosition(sectionX[3][i], sectionY[3][i]));
		}
	}

	public static LocationManager getInstance() {
		return instance;
	}

	public Position getSectionPosition(SectionOf sectionOf, MapSection section) {
		return sectionPosition.get(sectionOf.getValue()).get(section.getValue()).toPosition();
	}

	public boolean isExistsSectionPosition(Unit unit, SectionOf sectionOf, MapSection section, int offset) {
		Position pos = sectionPosition.get(sectionOf.getValue()).get(section.getValue()).toPosition();

		if (unit.getPosition().getDistance(pos) < offset) {
			return true;
		} else {
			return false;
		}
	}

	public MapSection getSectionPosition(Unit unit, SectionOf sectionOf, int offset) {
		for (MapSection section : MapSection.values()) {
			if (isExistsSectionPosition(unit, sectionOf, section, offset)) {
				return section;
			}
		}

		return null;
	}

	public Position getRelativePosition(Unit unit, Direction direction, int dist, OptMovable movable) {
		Position result = null;
		Position curPos = unit.getPosition();

		int FIND_MAX_COUNT = 3;
		int findCount = 0;

		int direct = 1;

		while (result == null || findCount < FIND_MAX_COUNT || curPos.getDistance(result) > 0) {
			switch (direction) {
			case N:
				result = new Position(curPos.getX(), curPos.getY() - (dist + (findCount * direct)));
				break;
			case S:
				result = new Position(curPos.getX(), curPos.getY() + (dist + (findCount * direct)));
				break;
			case E:
				result = new Position(curPos.getX() + (dist + (findCount * direct)), curPos.getY());
				break;
			case W:
				result = new Position(curPos.getX() - (dist + (findCount * direct)), curPos.getY());
				break;
			case NE:
				result = new Position(curPos.getX() + (dist + (findCount * direct)),
						curPos.getY() + (dist + (findCount * direct)));
				break;
			case SE:
				result = new Position(curPos.getX() + (dist + (findCount * direct)),
						curPos.getY() - (dist + (findCount * direct)));
				break;
			case NW:
				result = new Position(curPos.getX() - (dist + (findCount * direct)),
						curPos.getY() + (dist + (findCount * direct)));
				break;
			case SW:
				result = new Position(curPos.getX() - (dist + (findCount * direct)),
						curPos.getY() - (dist + (findCount * direct)));
				break;
			default:
				break;
			}

			if (result.isValid()) {
				if (isMovablePosition(unit, result)) {
					return result;
				} else {
					switch (movable) {
					case NO_CHECK:
						return curPos;
					case FIND_CLOSER:
						direct = -1;
						break;
					default:
						direct = 1;
						break;
					}
				}

				findCount++;
			} else {
				return curPos;
			}

		}

		return curPos;

	}

	public Position getRelativePosition(Unit unit, Unit target, Direction direction, int dist, OptMovable movable) {
		Position fromPos = unit.getPosition();
		Position toPos = target.getPosition();

		Position retPos = null;
		int direct = 1;

		int FIND_MAX_COUNT = 10;
		int findCount = 0;

		while (retPos == null || findCount < FIND_MAX_COUNT || toPos.getDistance(retPos) > 0) {

			double radian = Math
					.atan((double) (toPos.getY() - fromPos.getY()) / (double) (toPos.getX() - fromPos.getX()));

			double expectDist = fromPos.getDistance(toPos);

			if (direction == Direction.FRONT) {
				expectDist -= dist + (findCount * direct);
			} else if (direction == Direction.BACK) {
				expectDist += dist + (findCount * direct);
			} else {
				return null;
			}

			int posX = (int) (Math.cos(radian) * expectDist) + fromPos.getX();
			int posY = (int) (Math.sin(radian) * expectDist) + fromPos.getY();

			retPos = new Position(posX, posY);

			if (retPos.isValid()) {
				if (isMovablePosition(unit, retPos)) {
					return retPos;
				} else {
					switch (movable) {
					case NO_CHECK:
						return toPos;
					case FIND_CLOSER:
						direct = -1;
						break;
					default:
						direct = 1;
						break;
					}
				}

				findCount++;
			} else {
				return toPos;
			}

		}

		return toPos;
	}

	public boolean isAttackableRange(Unit unit, Position position) {
		return unit.canAttack(position);

	}

	public double getDistance(Unit unit, Position position) {
		return unit.getPosition().getDistance(position);
	}

	public boolean isSafePosition(Unit unit, Unit target) {
		if (target.canAttack(unit) && target.canAttack(unit.getPosition())) {
			return false;
		} else {
			return true;
		}
	}

	public Position getBestTargetPositionStorm(Unit unit) {

		return null;

	}

	public boolean isMovablePosition(Unit unit, Position position) {

		return true;
		// if(unit != null && unit.getType().isFlyer())
		// {
		// return true;
		// }
		// else
		// {
		// return position.isValid();
		// }
	}

//	public static void main(String[] args) {
//		LocationManager instance = LocationManager.getInstance();
//		Position answer = instance.getRelativePosition(null, null, Direction.BACK, 3, OptMovable.FIND_FAR);
//		System.out.println("X = " + answer.getX() + " , Y = " + answer.getY());
//	}

}

enum Direction {
	N, S, W, E, NE, SE, SW, NW, FRONT, BACK
}

enum OptMovable {
	NO_CHECK, FIND_CLOSER, FIND_FAR
}

enum MapSection {
	MAIN_CENTER(0), ENTRANCE_UP(1), ENTRANCE_BOTTOM(2), SECOND_CENTER(3), BIG_ENTRANCE(4), FRONT_BRIDGE1(
			5), BACK_BRIDGE1(6), FRONT_BRIDGE2(
					7), BACK_BRIDGE2(8), BIG_BRIDGE(9), THIRD_CENTER(10), SIDE1(11), SIDE2(12), SIDE3(13);

	private final int value;

	private MapSection(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

enum SectionOf {
	CENTER(0), ELEVEN_CLOCK(1), ONE_CLOCK(2), FIVE_CLOCK(3), SEVEN_CLOCK(4);

	private final int value;

	private SectionOf(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
