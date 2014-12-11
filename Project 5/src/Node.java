/**
 * Node for use in queue and stack
 */
public class Node {
	private Team element;
	private Node next;

	/**
	 * Create node
	 * @param element Team
	 */
	public Node(Team element){
		this.element = element;
	}

	/**
	 * Get team
	 * @return team
	 */
	public Team getElement() {
		return element;
	}

	/**
	 * Set team
	 * @param element Team
	 */
	public void setElement(Team element) {
		this.element = element;
	}

	/**
	 * Get next node
	 * @return next node
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * Set next node
	 * @param next next node
	 */
	public void setNext(Node next) {
		this.next = next;
	}
}
