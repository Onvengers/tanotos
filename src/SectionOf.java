
public enum SectionOf {
	CENTER(0), ELEVEN_CLOCK(1), ONE_CLOCK(2), FIVE_CLOCK(3), SEVEN_CLOCK(4);

	private final int value;

	private SectionOf(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
