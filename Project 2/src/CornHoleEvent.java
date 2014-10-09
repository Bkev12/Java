import java.awt.Event;

public class CornHoleEvent extends Event {

	int numBeanBags; //creates a local variable named numBeanBags
	
	public CornHoleEvent(Object target, int id, Object arg) {
		super(target, id, arg);
		// TODO Auto-generated constructor stub
	}
	
	public int getnumBeanBags(){
		int myBeanBags = 15; //sets myBeanBags to 15
		return myBeanBags; //returns myBeanBags
	}
	
	public void setnumBeanBags(int number){
		this.numBeanBags = number; //sets the local variable numBeanBags to number, the argument sent to the method
	}
}

