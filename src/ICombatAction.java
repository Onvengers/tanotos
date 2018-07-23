import bwapi.TilePosition;
import bwapi.Unit;

public interface ICombatAction {

	public void act(Unit actSubject, TilePosition actLoc, Unit actObject);
}
