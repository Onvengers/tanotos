import bwapi.TilePosition;
import bwapi.Unit;

public interface ICombatStatus {

	public boolean checkCombatStatus(Unit unit, TilePosition loc);
}
