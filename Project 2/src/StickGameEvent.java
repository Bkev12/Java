import java.awt.Event;

public class StickGameEvent extends Event {

	int FrisbeeSize; //creates a local variable named FrisbeeSize
	
	public StickGameEvent(Object target, int id, Object arg) {
		super(target, id, arg);

	}
	public int getFrisbeeSize(){
		//sets myFrisbeeSize to 15
		int myFrisbeeSize = 12;
		return myFrisbeeSize; //returns myFrisbeeSize
	}
		//
	public void setnumBeanBags(int size){
		this.FrisbeeSize = size; //sets the local variable frisbeeSize to size, the argument sent to the method
	}
}
