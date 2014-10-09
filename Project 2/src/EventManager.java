
public class EventManager {
	
	private static String[] Event; //a private local String array named Event

	public EventManager(){
		//sets the events to a String array, myEvents
		String myEvents[] = new String[6];
		myEvents[0] = "CanJumpEvent";
		myEvents[1] = "CornHoleEvent";
		myEvents[2] = "HorseShoesEvent";
		myEvents[3] = "LadderBallEvent";
		myEvents[4] = "StickGameEvent";
		myEvents[5] = "WashoosEvent"; 
		Event = myEvents; //sets Event to the local String array, myEvents
	}
	public static String[] getEvent(){
		return Event; //returns Event
	}
	public void setEvent(String[] Event){ 
		this.Event = Event; //sets the local variable Event to Event, the argument sent to the method
	}
	
	public void print(){
		//prints out the Events to the console
		for(int i = 0; i < Event.length; i++){
			System.out.println(Event[i]);
		}
	}
}
