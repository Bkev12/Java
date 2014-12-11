
public class CompetitionManager {
	private Competition head;
	private int count;
	
	private EventManager eventManager;
	
	public CompetitionManager(EventManager eventManager){
		this.eventManager = eventManager;
		
		//start new competitions
		startNewCompetitions();
	}
	
	
	/**
	 * Start all competitions where not an event playing and teams are available
	 */
	private void startNewCompetitions(){
		//loop through events
		for(Event event : eventManager.getEvents()){
			//we can start a new event
			if(!containsEvent(event)){
				Team[] pTeams = event.peakNextTeams();
				if(pTeams == null){
					continue;
				}
				
				//make sure both teams aren't playing
				if(!containsTeam(pTeams[0]) && !containsTeam(pTeams[1])){
					Team[] teams = event.getNextTeams();
					Team team1 = teams[0];
					Team team2 = teams[1];
					//create a new event
					startCompetition(event, team1, team2);
				}
			}
		}
	}
	
	/**
	 * Begin competition
	 * @param event
	 * @param team1
	 * @param team2 
	 */
	private void startCompetition(Event event, Team team1, Team team2){
		//create competition
		Competition competition = new Competition(event, team1, team2);
		
		Competition node = head;
		//check if this is first node
		if(node == null){
			//update head
			head = competition;
		} else {
			//keep looping until end of list
	        while (node.getNext() != null) {
	        	//advance to next node
	        	node = node.getNext();
	        }
	        
	        //set next node to be competition
	        node.setNext(competition);
		}
		
		//increment count
        count++;
	}
	
	/**
	 * Get running competitions
	 * @return competitions
	 */
	public ICompetition[] getCompetitions(){
		//create array of competitions
		ICompetition[] competitions = new ICompetition[count];
		
		int curIndex = 0;
		//initialize node to start
		Competition node = head;
		//loop until end of list
		while(node != null){
			//set position in array
			competitions[curIndex] = node;
			//increment counter
			curIndex++;
			//get next node
			node = node.getNext();
		}
		
		return competitions;		
	}
	
	/**
	 * End competition
	 * @param competition
	 * @param winningTeam
	 */
	public void endCompetition(ICompetition competition, Team winningTeam){
		//end competition
		endExistingCompetition(competition, winningTeam);
		//start new competitions
		startNewCompetitions();
	}
	
	/**
	 * End competition
	 * @param competition
	 * @param winningTeam
	 */
	private void endExistingCompetition(ICompetition competition, Team winningTeam){
		//set current node
		Competition node = head;
		//set previous node
		Competition prevNode = head;
		
		boolean found = false;
		//loop until competition is found
		while(!found){		
			//check for match
			if(competition == node){
				found = true;
			}else{
				//no match
				//update prevnode and next node
				prevNode = node;
				node = node.getNext();
			}
		}
		
		Team winner;
		Team loser;
		//check for winning team
		//update wins and losses
		if(node.getTeam1().equals(winningTeam)){
			node.getTeam1().incrementWins();
			node.getTeam2().incrementLosses();
			
			winner = node.getTeam1();
			loser = node.getTeam2();
		}else{
			node.getTeam2().incrementWins();
			node.getTeam1().incrementLosses();
			
			winner = node.getTeam2();
			loser = node.getTeam1();
		}
		
		//get played event
		Event playedEvent = node.getEvent();
		//return teams
		playedEvent.returnTeams(winner, loser);
		
		//check if we need to update head
		if(prevNode == head){
			//update head
			head = head.getNext();
		} else {
			//update trailing node to skip current node
			prevNode.setNext(node.getNext());
		}
		
		//decrement count
		count--;
	}
	
	/**
	 * Check if event exists in running competitions
	 * @param event
	 * @return true if event exists, false otherwise
	 */
	public boolean containsEvent(Event event){
		//initialize to head
		Competition current = head;
		
		//loop until end
		while(current != null){
			//check if match
			if(current.getEvent().equals(event)){
				//event already exists
				return true;
			}
			
			//get next node
			current = current.getNext();
		}
		
		return false;
	}
	
	/**
	 * Check if team exists in running competitions
	 * @param team
	 * @return true if team exists, false otherwise
	 */
	public boolean containsTeam(Team team){
		//initialize to head
		Competition current = head;

		//loop until end
		while(current != null){
			//check if team1 match
			if(current.getTeam1().equals(team)){
				return true;
			}
			//check if team2 match
			if(current.getTeam2().equals(team)){
				return true;
			}
			//get next node
			current = current.getNext();
		}
		
		return false;
	}
	
	/**
	 * Print competitions
	 */
	public void printCompetitions(){
		//initialize node to head
		Competition node = head;
		int i = 1;
		
		System.out.println();
		
		//loop until end
		while(node != null){
			//display competition number
			System.out.print("Competition #" + i + " -- ");
			//display short description for competition
			node.printShortDescription();
			//get next node
			node = node.getNext();
			//increment count
			i++;
		}
	}
}
