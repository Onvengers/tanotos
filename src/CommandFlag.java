
public enum CommandFlag {
	ATTACK_ENEMY_CENTER(0),
	ATTACK_ENEMY_SECOND_CENTER(1),
	DEFENCE_MY_CENTER(2),
	DEFENCE_MY_SECOND_CENTER(3),
	DEFENCE_MY_BIG_ENTRANCE(4),
	MOVE_MY_TROOP(5),
	ATTACK_ENEMY_SIDE1(6),
	ATTACK_ENEMY_SIDE2(7),
	ATTACK_ENEMY_SIDE3(8),
	ATTACK_ENEMY_THIRD_CENTER(9),
	ATTACK_ELLIE(10);
	
	private final int value;

	private CommandFlag(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
