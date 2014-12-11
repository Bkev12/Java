
public class WashoosEvent extends Event {

	private boolean hasAutoWinStick;
	private int numWashoos;
	
	public WashoosEvent(Team[] teams) {
		super(teams);
	}

	@Override
	public String getExtraInfo() {
		return "Has auto win stick: " + this.hasAutoWinStick + ", Num Washoos: " + this.numWashoos;
	}

	/**
	 * Get is has autowin stick
	 * @return has autowin stick
	 */
	public boolean isHasAutoWinStick() {
		return hasAutoWinStick;
	}

	/**
	 * Set has autowin stick
	 * @param hasAutoWinStick
	 */
	public void setHasAutoWinStick(boolean hasAutoWinStick) {
		this.hasAutoWinStick = hasAutoWinStick;
	}

	/**
	 * Get num washoos
	 * @return num washoos
	 */
	public int getNumWashoos() {
		return numWashoos;
	}

	/**
	 * Set num washoos
	 * @param numWashoos
	 */
	public void setNumWashoos(int numWashoos) {
		this.numWashoos = numWashoos;
	}
	
}
