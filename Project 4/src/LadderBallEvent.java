
public class LadderBallEvent extends Event {

	private int numRungs;
	
	public LadderBallEvent() {
		super();
	}

	/**
	 * Get num rungs
	 * @return num rungs
	 */
	public int getNumRungs() {
		return numRungs;
	}

	/**
	 * Set num rungs
	 * @param numRungs
	 */
	public void setNumRungs(int numRungs) {
		this.numRungs = numRungs;
	}

	@Override
	public String getExtraInfo() {
		return "Number of rungs: " + this.numRungs;
	}
}
