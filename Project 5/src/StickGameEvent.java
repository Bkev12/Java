
public class StickGameEvent extends Event {

	private int frisbeeSize; //creates a local variable named FrisbeeSize
	
	public StickGameEvent(Team[] teams) {
		super(teams);
	}
	
	@Override
	public String getExtraInfo() {
		return "Frisbee Size: " + this.frisbeeSize;
	}

	/**
	 * Get frisbee size
	 * @return frisbee size
	 */
	public int getFrisbeeSize() {
		return frisbeeSize;
	}

	/**
	 * Set frisbee size
	 * @param frisbeeSize
	 */
	public void setFrisbeeSize(int frisbeeSize) {
		this.frisbeeSize = frisbeeSize;
	}
}
