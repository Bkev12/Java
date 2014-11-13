public abstract class Event {

	private String name;
	private int playTo;
	private boolean isPlayToExact;
	private int playDistance;

	public Event(){		
	}

	/**
	 * Get extra info for event
	 * @return extra info
	 */
	public abstract String getExtraInfo();

	/**
	 * Display event data
	 */
	public void print() {
		System.out.print("Name: " + this.name);
		System.out.print(", Play to: " + this.playTo);
		System.out.print(", Is Play To Exact: " + this.isPlayToExact);
		System.out.print(", Play Distance: " + this.playDistance);
		System.out.print(", " + getExtraInfo());
		
	}

	/**
	 * Get event name
	 * @return event name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set event name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get play to
	 * @return play to
	 */
	public int getPlayTo() {
		return playTo;
	}

	/**
	 * Set play to
	 * @param playTo
	 */
	public void setPlayTo(int playTo) {
		this.playTo = playTo;
	}

	/**
	 * Get is play to exact
	 * @return is play to exact
	 */
	public boolean getIsPlayToExact() {
		return isPlayToExact;
	}

	/**
	 * Set is play to exact
	 * @param isPlayToExact
	 */
	public void setIsPlayToExact(boolean isPlayToExact) {
		this.isPlayToExact = isPlayToExact;
	}

	/**
	 * Get play distance
	 * @return play distance
	 */
	public int getPlayDistance() {
		return playDistance;
	}

	/**
	 * Set play distance
	 * @param playDistance
	 */
	public void setPlayDistance(int playDistance) {
		this.playDistance = playDistance;
	}
}
