import java.awt.Event;

public class HorseShoesEvent extends Event {

	int numHorsesShoes;
	
	public HorseShoesEvent(Object target, int id, Object arg) {
		super(target, id, arg);
		// TODO Auto-generated constructor stub
	}
	public int getnumHorsesShoes(){
		int myHorsesShoes = 15;
		return myHorsesShoes;
	}
	
	public void setnumBeanBags(int number){
		this.numHorsesShoes = number;
	}
}
