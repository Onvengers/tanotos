
public enum MapSection {
	MAIN_CENTER(0), ENTRANCE_UP(1), ENTRANCE_BOTTOM(2), SECOND_CENTER(3), BIG_ENTRANCE(4), FRONT_BRIDGE1(
			5), BACK_BRIDGE1(6), FRONT_BRIDGE2(7), BACK_BRIDGE2(8), BIG_BRIDGE(9), THIRD_CENTER(10), SIDE1(11), SIDE2(
					12), SIDE3(13), CENTER1(0), CENTER2(1), CENTER3(2), CENTER4(3), CENTER5(4), CENTER6(5), CENTER7(
							6), CENTER8(7), CENTER9(8), CENTER10(
									9), CENTER11(10), CENTER12(11), CENTER13(12), CENTER14(13), CENTER15(14);

	private final int value;

	private MapSection(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
