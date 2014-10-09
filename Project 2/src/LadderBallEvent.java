import java.awt.Event;

public class LadderBallEvent extends Event {

	int numRungs;
	
	public LadderBallEvent(Object target, int id, Object arg) {
		super(target, id, arg);
		// TODO Auto-generated constructor stub
	}
	public int getnumRungs(){
		int myRungs = 15;
		return myRungs;
	}
	
	public void setnumRungs(int number){
		this.numRungs = number;
	}
}
