public class EventManager {

	Event[] events = new Event[6];
	public int eventCount = 0;
	
	public EventManager(){
		loadEvents();
	}

	/**
	 * load events
	 */
	private void loadEvents() {
		CanJamEvent canJam = new CanJamEvent();
		canJam.setName("Can Jam");
		canJam.setPlayDistance(50);
		canJam.setIsPlayToExact(true);
		canJam.setPlayTo(21);
		canJam.setFrisbeeSize(5);
		events[eventCount] = canJam;
		eventCount++;

		CornHoleEvent cornHole = new CornHoleEvent();
		cornHole.setIsPlayToExact(false);
		cornHole.setName("corn hole");
		cornHole.setNumBeanBags(5);
		cornHole.setPlayDistance(27);
		cornHole.setPlayTo(27);
		events[eventCount] = cornHole;
		eventCount++;

		HorseShoesEvent horseShoes = new HorseShoesEvent();
		horseShoes.setIsPlayToExact(false);
		horseShoes.setName("horse shoes");
		horseShoes.setNumHorseShoes(10);
		horseShoes.setPlayDistance(40);
		horseShoes.setPlayTo(11);
		events[eventCount] = horseShoes;
		eventCount++;
		
		StickGameEvent stickGame = new StickGameEvent();
		stickGame.setFrisbeeSize(6);
		stickGame.setIsPlayToExact(false);
		stickGame.setName("stick game");
		stickGame.setPlayDistance(25);
		stickGame.setPlayTo(11);
		events[eventCount] = stickGame;
		eventCount++;

		WashoosEvent washoos = new WashoosEvent();
		washoos.setHasAutoWinStick(true);
		washoos.setIsPlayToExact(true);
		washoos.setName("washoos");
		washoos.setNumWashoos(3);
		washoos.setPlayDistance(15);
		washoos.setPlayTo(21);
		events[eventCount] = washoos;
		eventCount++;
		
		LadderBallEvent ladderBall = new LadderBallEvent();
		ladderBall.setName("Ladder Ball");
		ladderBall.setIsPlayToExact(true);
		ladderBall.setNumRungs(5);
		ladderBall.setPlayDistance(15);
		ladderBall.setPlayTo(21);
		events[eventCount] = ladderBall;
	}

	/**
	 * Get events
	 * @return event array
	 */
	public Event[] getEvents() {
		return events;
	}

	/**
	 * Print events
	 */
	public void printEvents() {
		System.out.println();
		System.out.println("List of events");
		for (int i = 0; i < eventCount; i++) {
			events[i].print();
			System.out.println();
		}
	}
}
