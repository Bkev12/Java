
public class PlacingStack {
	
	private int total = 0;
    private Node first;
    
    public PlacingStack() {     	
    }

    
    /**
     * Push team onto stack
     * @param element
     */
    public void push(Team element){
    	//create new node
    	Node front = new Node(element);
    	//set next
    	front.setNext(first);
    	//update head node
    	first = front;
        //increment total
        total++;
    }

    /**
     * Pop team from stack
     * @return Team
     */
    public Team pop()
    {        
    	//get first element
        Team element = first.getElement();
        //update next
        first = first.getNext();
        //decrement total
        total--;
        return element;
    }
    
    /**
     * Size of stack
     * @return size
     */
    public int size(){
    	return this.total;
    }
    
    /**
     * Print out stack
     */
    public void print(){
    	//get head
    	Node current = first;
    	//loop
    	while(current != null){
    		//display team
    		System.out.print(current.getElement() + " ");
    		//get next
    		current = current.getNext();
    	}
    }
}
