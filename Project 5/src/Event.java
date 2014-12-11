
public abstract class Event {

	private String name;
	private int playTo;
	private boolean isPlayToExact;
	private int playDistance;
	
	//bracket
	private BracketQueue bracket = new BracketQueue();
	//placing
	private PlacingStack places = new PlacingStack();

	/**
	 * Create event
	 * @param teams teams to play in event
	 */
	public Event(Team[] teams){		
		//loop through teams
		for(Team team : teams){
			//add to bracket
			bracket.enqueue(team);
		}
	}

	/**
	 * Get extra info for event
	 * @return extra info
	 */
	public abstract String getExtraInfo();
	
	/**
	 * Get next two teams
	 * @return null if empty, next two teams otherwise
	 */
	public Team[] peakNextTeams(){
		if(bracket.size() <= 1){
			return null;
		}
		//create array of teams
		Team[] teams = new Team[2];
		//peek next two
		teams[0] = bracket.peek();
		teams[1] = bracket.peekNext();
		return teams;
	}
	
	/**
	 * Get next two teams to play
	 * @return teams
	 */
	public Team[] getNextTeams(){
		Team[] teams = new Team[2];
		teams[0] = bracket.dequeue();
		teams[1] = bracket.dequeue();
		return teams;
	}
	
	/**
	 * Return teams after they played
	 * @param winner winning team
	 * @param loser losing team
	 */
	public void returnTeams(Team winner, Team loser){
		//add winner back to bracket
		bracket.enqueue(winner);
		//add loser to places
		places.push(loser);
		
		//check if we have single left in bracket
		if(bracket.size() == 1){
			//won the event
			Team eventWinner = bracket.dequeue();
			//add to places
			places.push(eventWinner);
		}
	}

	/**
	 * Display event data
	 */
	public void print() {
		System.out.print("Name: " + this.name);
		System.out.print(", Play to: " + this.playTo);
		System.out.print(", Is Play To Exact: " + this.isPlayToExact);
		System.out.print(", Play Distance: " + this.playDistance);
		System.out.print(", " + getExtraInfo());
		
		//display places
		System.out.print("\nPlaces: ");
		places.print();
		
	}

	/**
	 * Get event name
	 * @return event name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set event name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get play to
	 * @return play to
	 */
	public int getPlayTo() {
		return playTo;
	}

	/**
	 * Set play to
	 * @param playTo
	 */
	public void setPlayTo(int playTo) {
		this.playTo = playTo;
	}

	/**
	 * Get is play to exact
	 * @return is play to exact
	 */
	public boolean getIsPlayToExact() {
		return isPlayToExact;
	}

	/**
	 * Set is play to exact
	 * @param isPlayToExact
	 */
	public void setIsPlayToExact(boolean isPlayToExact) {
		this.isPlayToExact = isPlayToExact;
	}

	/**
	 * Get play distance
	 * @return play distance
	 */
	public int getPlayDistance() {
		return playDistance;
	}

	/**
	 * Set play distance
	 * @param playDistance
	 */
	public void setPlayDistance(int playDistance) {
		this.playDistance = playDistance;
	}
}
