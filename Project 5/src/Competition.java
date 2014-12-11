
public class Competition implements ICompetition {
	private Event event;
	private Team team1;
	private Team team2;
	
	private Competition next;
	
	/**
	 * Create competition
	 * @param event
	 * @param team1
	 * @param team2
	 */
	public Competition(Event event, Team team1, Team team2) {
		this.event = event;
		this.team1 = team1;
		this.team2 = team2;
	}

	@Override
	public Event getEvent() {
		return this.event;
	}

	@Override
	public Team getTeam1() {
		return this.team1;
	}

	@Override
	public Team getTeam2() {
		return this.team2;
	}

	/**
	 * Get next node
	 * @return node
	 */
	public Competition getNext() {
		return next;
	}

	/**
	 * Set next node
	 * @param next 
	 */
	public void setNext(Competition next) {
		this.next = next;
	}	
	
	/**
	 * Print short description of event and teams
	 */
	public void printShortDescription(){
		System.out.println(getEvent().getName() + 
				" - Team1: " + getTeam1().getOlympian1().getName() + ", " + getTeam1().getOlympian2().getName() +
				" - Team2: " + getTeam2().getOlympian1().getName() + ", " + getTeam2().getOlympian2().getName());
	}
}
