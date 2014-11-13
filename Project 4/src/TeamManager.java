import java.util.Random;


public class TeamManager {
	private Team[] teams;
	private Olympian[] olympians;
	
	/**
	 * Create team manager
	 * @param olympians
	 */
	public TeamManager(Olympian[] olympians) {
		this.olympians = olympians;
		loadTeams();
	}

	/**
	 * Get random olympian based on sex and used indices
	 * @param usedIndex olympians index assignments
	 * @param sex sex of olympian
	 * @return index position
	 */
	private int getRandomOlympian(boolean[] usedIndex, Sex sex){
		//initialize index
		int olympianIndex = -1;
		
		//loop until find unused index of sex
		while(olympianIndex < 0){
			//get random position
			int index = new Random().nextInt(olympians.length);
			//check if used
			if(usedIndex[index] == false){
				//check sex
				if(olympians[index].getSex() == sex){
					//update index
					olympianIndex = index;
				}
			}
		}
		
		//return index
		return olympianIndex;
	}
	
	/**
	 * Get first unused index from array
	 * @param usedIndex array of used index olympians
	 * @return unused index
	 */
	private int getFirstUnusedIndex(boolean[] usedIndex){
		//loop through array
		for(int i=0; i<usedIndex.length; i++){
			//check if false
			if(usedIndex[i] == false){
				//return index
				return i;
			}
		}
		
		//not found
		return -1;
	}
	
	
	/**
	 * Load teams
	 * Assign male/female pairs for each matching olympian
	 */
	private void loadTeams() {
		//initialize teams
		this.teams = new Team[olympians.length / 2];
		
		//create array to keep track of which olympians are assigned
		boolean[] usedIndex = new boolean[olympians.length];
		
		//get num males and females remaining
		int malesRemaining = 0;
		int femalesRemaining = 0;
		
		//loop through array
		for (int i = 0; i < olympians.length; i++) {
			//increment males or females remaining
			if (olympians[i].getSex().equals(Sex.MALE)) {
				malesRemaining++;
			} else if (olympians[i].getSex().equals(Sex.FEMALE)) {
				femalesRemaining++;
			}
		}
		
		//index of team
		int teamCounter = 0;
				
		//try to assign teams first with both male and female pair
		while(malesRemaining > 0 && femalesRemaining > 0){
			//get random male
			int maleIndex = getRandomOlympian(usedIndex, Sex.MALE);
			//update used index
			usedIndex[maleIndex] = true;
			//decrement males remaining
			malesRemaining--;
			
			//get random female
			int femaleIndex = getRandomOlympian(usedIndex, Sex.FEMALE);
			//update used index
			usedIndex[femaleIndex] = true;
			//decrement females remaining
			femalesRemaining--;

			//create team
			Team team = new Team(olympians[maleIndex], olympians[femaleIndex]);
			//set team in array
			teams[teamCounter] = team;
			//increment counter
			teamCounter++;
		}
		
		//we might have remaining males/females exclusively, need to check and assign those to teams
		
		//get total remaining
		int totalRemaining = malesRemaining + femalesRemaining;
		
		//keep looping while olympians left
		while(totalRemaining > 0){
			//get first unused olympian
			int firstIndex = getFirstUnusedIndex(usedIndex);
			//update used
			usedIndex[firstIndex] = true;
			//decrement total remaining
			totalRemaining--;

			//get second unused olympian
			int secondIndex = getFirstUnusedIndex(usedIndex);
			//update used
			usedIndex[secondIndex] = true;
			//decrement total remaining
			totalRemaining--;

			//create team
			Team team = new Team(olympians[firstIndex], olympians[secondIndex]);
			//set team in array
			teams[teamCounter] = team;
			//increment counter
			teamCounter++;
		}
	}
	
	/**
	 * Print teams
	 */
	public void printTeams() {
		System.out.println();
		System.out.println("list of teams");
		//loop through teams
		for (int i = 0; i < teams.length; i++) {
			System.out.print("Team #" + (i + 1) + ": ");
			//display olympian details
			System.out.print(teams[i].getOlympian1().getName() + ",");
			System.out.print(teams[i].getOlympian1().getSex() + ",");
			System.out.print(teams[i].getOlympian1().getAge() + ",");
			System.out.print(teams[i].getOlympian2().getName() + ",");
			System.out.print(teams[i].getOlympian2().getAge() + ",");
			System.out.print(teams[i].getOlympian2().getSex() + ",");
			System.out.print(teams[i].getWins() + ",");
			System.out.println(teams[i].getLosses());
		}
	}
	
	public Team[] getTeams(){
		return teams;
	}
}
