
public class BracketQueue {
	private Node head = null;
	private Node tail = null;
	private int size = 0;


	public BracketQueue(){
	}

	public boolean isEmpty(){
		return (size == 0);
	}

	/**
	 * Enqueue team
	 * @param item team to enqueue
	 */
	public void enqueue(Team item){
		//create node
		Node node = new Node(item);
		//check if empty
		if(isEmpty()){
			//update head
			head = node;
		}else{
			//update next tail
			tail.setNext(node);
		}		
		
		//update tail
		tail = node;
		
		//increment size
		size++;
	}

	/**
	 * Dequeue team
	 * @return team
	 */
	public Team dequeue(){
		//make sure not empty
		if(isEmpty()){
			return null;
		}

		//get head data
		Team item = head.getElement();
		//check if all elements removed
		if (tail == head) {
			tail = null;
		}
		//update next node
		head = head.getNext();

		//decrement size
		size--;
		
		return item;
	}

	/**
	 * Peak next node
	 * @return team
	 */
	public Team peek(){
		return head.getElement();
	}

	/**
	 * Peak 2 nodes deep
	 * @return team
	 */
	public Team peekNext(){
		return head.getNext().getElement();
	}
	
	/**
	 * Size of bracket
	 * @return size
	 */
	public int size(){
		return size;
	}

}
