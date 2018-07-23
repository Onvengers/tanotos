import java.util.List;

import bwapi.TilePosition;
import bwapi.Unit;

public interface ICombatAction {

	public void act(List<Unit> actSubject, TilePosition actLoc, Unit actObject);
}
