 import bwapi.Position;
 import bwapi.Unit;

public class LocationManager {

 private static LocationManager instance = new LocationManager();
  


  private LocationManager()
  {
   
  }
  
  public static LocationManager getInstance()
  {
   return instance;
  }
  
  public Position getAbsolutePosition(MapSection section)
  {
   
   return StatusIndicator.Instance().getAbsMapPosition(section);
  }
  
  public boolean isExistsAbsolutePosition(Unit unit, MapSection section, int offset)
  {
   Position pos = getAbsolutePosition(section);
   
   if(unit.getPosition().getDistance(pos)  < offset)
   {
    return true;
   }
   else
   {
    return false;
   }
  }
  
  public MapSection getAbsolutePosition(Unit unit, int offset)
  {
   for(MapSection section : MapSection.values())
   {
    if(isExistsAbsolutePosition(unit, section, offset))
    {
     return section;
    }
   }
   
   return null;
  }
  
  
  public Position getRelativePosition(Unit unit, Direction direction, int dist, OptMovable movable)
  {
   Position result = null;
   Position curPos = unit.getPosition();

  int FIND_MAX_COUNT = 3;
   int findCount = 0;
   
   int direct = 1;
   
   while(result == null || findCount < FIND_MAX_COUNT || curPos.getDistance(result) > 0)
   {
    switch(direction)
    {
     case N :
      result = new Position(curPos.getX(), curPos.getY() - (dist + (findCount * direct)));
      break;
     case S :
      result = new Position(curPos.getX(), curPos.getY() + (dist + (findCount * direct)));
      break;
     case E :
      result = new Position(curPos.getX() + (dist + (findCount * direct)), curPos.getY());
      break;
     case W :
      result = new Position(curPos.getX() - (dist + (findCount * direct)), curPos.getY());
      break;
     case NE :
      result = new Position(curPos.getX() + (dist + (findCount * direct)), curPos.getY() + (dist + (findCount * direct)));
      break;
     case SE :
      result = new Position(curPos.getX() + (dist + (findCount * direct)), curPos.getY() - (dist + (findCount * direct)));
      break;
     case NW :
      result = new Position(curPos.getX() - (dist + (findCount * direct)), curPos.getY() + (dist + (findCount * direct)));
      break;
     case SW :
      result = new Position(curPos.getX() - (dist + (findCount * direct)), curPos.getY() - (dist + (findCount * direct)));
      break;
     default : 
      break;
    }

   if(result.isValid())
    {
     if(isMovablePosition(unit, result))
     {
      return result;
     }
     else
     {
      switch(movable)
      {
       case NO_CHECK:
        return curPos;
       case FIND_CLOSER:
        direct = -1;
        break;
       default :
        direct = 1;
        break;
      }
     }
     
     findCount++;
    }
    else
    {
     return curPos;
    }
    
   }
   
   return curPos;
   
  }
  
  public Position getRelativePosition(Unit unit, Unit target, Direction direction, int dist, OptMovable movable)
  {
   Position fromPos = unit.getPosition();
   Position toPos = target.getPosition();
     
   Position retPos = null;
   int direct = 1;
   
   int FIND_MAX_COUNT = 10;
   int findCount = 0;
   
   while(retPos == null || findCount < FIND_MAX_COUNT || toPos.getDistance(retPos) > 0)
   {
   
    double radian = Math.atan((double)(toPos.getY() - fromPos.getY()) / (double)(toPos.getX() - fromPos.getX()));
    
    double expectDist = fromPos.getDistance(toPos);
    
    if(direction == Direction.FRONT)
    {
     expectDist -= dist + (findCount * direct);
    }
    else if(direction == Direction.BACK)
    {
     expectDist += dist + (findCount * direct);
    }
    else
    {
     return null;
    }
    
    int posX = (int) (Math.cos(radian) * expectDist) + fromPos.getX();
    int posY = (int) (Math.sin(radian) * expectDist) + fromPos.getY();
    
    retPos = new Position(posX, posY);
    
    if(retPos.isValid())
    {
     if(isMovablePosition(unit, retPos))
     {
      return retPos;
     }
     else
     {
      switch(movable)
      {
       case NO_CHECK:
        return toPos;
       case FIND_CLOSER:
        direct = -1;
        break;
       default :
        direct = 1;
        break;
      }
     }
     
     findCount++;
    }
    else
    {
     return toPos;
    }
   
   }
   
   return toPos;
  }
  
  public boolean isAttackableRange(Unit unit, Position position)
  {
   return unit.canAttack(position);
   
  }
  
  public double getDistance(Unit unit, Position position)
  {
   return unit.getPosition().getDistance(position);
  }
  
  public boolean isSafePosition(Unit unit, Unit target)
  {
   if(target.canAttack(unit) && target.canAttack(unit.getPosition()))
   {
    return false;
   }
   else
   {
    return true;
   }
  }
  
  public Position getBestTargetPositionStorm(Unit unit)
  {
   
   return null;

 }
  
  
  public boolean isMovablePosition(Unit unit, Position position)
  {
  
   return true;
 //  if(unit != null && unit.getType().isFlyer())
 //  {
 //   return true;
 //  }
 //  else
 //  {
 //   return position.isValid();
 //  }
  }
  
  
  
  public static void main(String[] args)
  {
   LocationManager instance = LocationManager.getInstance();  
   Position answer = instance.getRelativePosition(null, null, Direction.BACK, 3, OptMovable.FIND_FAR);  
   System.out.println("X = " + answer.getX() + " , Y = " + answer.getY());
  }

}

enum Direction 
 {
  N,
  S,
  W,
  E,
  NE,
  SE,
  SW,
  NW,
  FRONT,
  BACK
 }

enum OptMovable
 {
  NO_CHECK,
  FIND_CLOSER,
  FIND_FAR
 }

enum MapSection
 {
  SELF_MAIN_CENTER,
  SELF_SECOND_CENTER,
  SELF_THIRD_CENTER,
  SELF_ENTRANCE_UP,
  SELF_ENTRANCE_BOTTOM,
  SELF_HUGE_ENTRANCE,
  SELF_BRIDGE_SUB1,
  SELF_BRIDGE_SUB2,
  SELF_BRIDGE_MAIN,
  
  ENEMY_MAIN_CENTER,
  ENEMY_SECOND_CENTER,
  ENEMY_THIRD_CENTER,
  ENEMY_ENTRANCE_UP,
  ENEMY_ENTRANCE_BOTTOM,
  ENEMY_HUGE_ENTRANCE,
  ENEMY_BRIDGE_SUB1,
  ENEMY_BRIDGE_SUB2,
  ENEMY_BRIDGE_MAIN,
  
  CENTER_1,
  CENTER_2,
  CENTER_3,
  CENTER_4,
  CENTER_5,
  CENTER_6,
  CENTER_7,
  CENTER_8,
  CENTER_9,
  
  SECTION_1,
  SECTION_2,
  SECTION_3,
  SECTION_4,
  SECTION_5,
  SECTION_6,
  SECTION_7,
  SECTION_8,
  SECTION_9
 }
