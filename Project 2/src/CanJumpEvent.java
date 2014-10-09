import java.awt.Event;


public class CanJumpEvent extends Event {
	
	int frisbeeSize; //makes a local variable named risbeeSize
	static int t;
	
	public CanJumpEvent(Object t2, Object t3, Object t4) {
		super(t, t, t);
	}
		
	public int getFrisbeeSize(){
		int myFrisbeeSize = 10; //sets myFrisbeeSize to 10
		return myFrisbeeSize; //returns myFrisbeeSize
	}
	
	public void setFrisbeeSize(int size){
		this.frisbeeSize = size; //sets the local variable frisbeeSize to size, the argument sent to the method
	}
}

