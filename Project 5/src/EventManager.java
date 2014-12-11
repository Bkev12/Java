import java.util.Random;

public class EventManager {

	Event[] events = new Event[6];
	public int eventCount = 0;
	private static Random random;
	
	public EventManager(Team[] teams){
		loadEvents(teams);
	}

	/**
	 * load events
	 */
	private void loadEvents(Team[] teams1) {
		Team[] teams = new Team[teams1.length];
		for(int i=0; i<teams1.length; i++){
			teams[i] = teams1[i];
		}
		shuffle(teams);
		CanJamEvent canJam = new CanJamEvent(teams);
		canJam.setName("Can Jam");
		canJam.setPlayDistance(50);
		canJam.setIsPlayToExact(true);
		canJam.setPlayTo(21);
		canJam.setFrisbeeSize(5);
		events[eventCount] = canJam;
		eventCount++;

		shuffle(teams);
		CornHoleEvent cornHole = new CornHoleEvent(teams);
		cornHole.setIsPlayToExact(false);
		cornHole.setName("Corn Hole");
		cornHole.setNumBeanBags(5);
		cornHole.setPlayDistance(27);
		cornHole.setPlayTo(27);
		events[eventCount] = cornHole;
		eventCount++;

		shuffle(teams);
		HorseShoesEvent horseShoes = new HorseShoesEvent(teams);
		horseShoes.setIsPlayToExact(false);
		horseShoes.setName("Horse Shoes");
		horseShoes.setNumHorseShoes(10);
		horseShoes.setPlayDistance(40);
		horseShoes.setPlayTo(11);
		events[eventCount] = horseShoes;
		eventCount++;

		shuffle(teams);
		StickGameEvent stickGame = new StickGameEvent(teams);
		stickGame.setFrisbeeSize(6);
		stickGame.setIsPlayToExact(false);
		stickGame.setName("Stick Game");
		stickGame.setPlayDistance(25);
		stickGame.setPlayTo(11);
		events[eventCount] = stickGame;
		eventCount++;

		shuffle(teams);
		WashoosEvent washoos = new WashoosEvent(teams);
		washoos.setHasAutoWinStick(true);
		washoos.setIsPlayToExact(true);
		washoos.setName("Washoos");
		washoos.setNumWashoos(3);
		washoos.setPlayDistance(15);
		washoos.setPlayTo(21);
		events[eventCount] = washoos;
		eventCount++;

		shuffle(teams);
		LadderBallEvent ladderBall = new LadderBallEvent(teams);
		ladderBall.setName("Ladder Ball");
		ladderBall.setIsPlayToExact(true);
		ladderBall.setNumRungs(5);
		ladderBall.setPlayDistance(15);
		ladderBall.setPlayTo(21);
		events[eventCount] = ladderBall;
		eventCount++;
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
			System.out.print("Event #" + (i + 1) + ": ");
			events[i].print();
			System.out.println();
		}
	}
	
	/**
     * Code from method java.util.Collections.shuffle();
     */
    private static void shuffle(Team[] array) {
        if (random == null) {
        	random = new Random();
        }
        
        int count = array.length;
        for (int i = count; i > 1; i--) {
            swap(array, i - 1, random.nextInt(i));
        }
    }

    private static void swap(Team[] array, int i, int j) {
    	Team temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
