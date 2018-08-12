
public enum EllieSection {
	//엘리 시키기 - 적군 SIDE1,2,3, 적군 3멀티, 확장1,2,3,4, 아군,적군아닌 Main Center 1,2
	ENEMY_SIDE1(0), ENEMY_SIDE2(1), ENEMY_SIDE3(2), ENEMY_THIRD_CENTER(3), 
	MULTI1(4), MULTI2(5), MULTI3(6), MULTI4(7), OTHER_CENTER1(8), OTHER_CENTER2(9);

	private final int value;

	private EllieSection(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
