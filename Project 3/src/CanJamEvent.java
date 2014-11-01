
public class CanJamEvent extends Event{
	
	private int frisbeeSize;
	
	public CanJamEvent() {
		super();
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
