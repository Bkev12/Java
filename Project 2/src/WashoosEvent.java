import java.awt.Event;
import java.util.Random;

public class WashoosEvent extends Event {

	boolean hasAutoWinStick;
	int numWashoos;
	
	public WashoosEvent(Object target, int id, Object arg) {
		super(target, id, arg);

	}
	public boolean gethasAutoWinStick(){
		//makes an instance to call random integer
		Random rn = new Random();
		int i = rn.nextInt() % 2; 
		boolean boolhasAutoWinStick;
		if (i > 0) //checks to see if the random integer is above 0 (1)
			boolhasAutoWinStick = true;
		else //if the random integer is 0 or below, (0 or -1)
			boolhasAutoWinStick = false;
		return boolhasAutoWinStick; //returns boolhasAutoWinStick
	}
	
	public int getnumWashoos(){
		int mynumWashoos = 15; //sets mynumWashoos to 15
		return mynumWashoos; //returns mynumWashoos
	}
	
	public void hasAutoWinStick(boolean number){
		this.hasAutoWinStick = number; //sets the local variable hasAutoWinStick to number, the argument sent to the method
	}
	
	public void setnumBeanBags(int number){
		this.numWashoos = number; //sets the local variable numWashoos to number, the argument sent to the method
	}
}
