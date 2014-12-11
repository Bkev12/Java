
public class CornHoleEvent extends Event {

	private int numBeanBags; //creates a local variable named numBeanBags
	
	public CornHoleEvent(Team[] teams) {
		super(teams);
	}

	@Override
	public String getExtraInfo() {
		return "Number of bean bags: " + this.numBeanBags;
	}

	/**
	 * Get num bean bags
	 * @return num beans bags
	 */
	public int getNumBeanBags() {
		return numBeanBags;
	}

	/**
	 * Set num bean bags
	 * @param numBeanBags
	 */
	public void setNumBeanBags(int numBeanBags) {
		this.numBeanBags = numBeanBags;
	}
}

