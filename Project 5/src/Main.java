/**
	 * Kevin Bruce
	 * Project 5
	 * 12/11/14
	 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	//variables for main program to access
	private OlympianManager olympianManager;
	private EventManager eventManager;
	private CompetitionManager competitionManager;
	private TeamManager teamManager;
	
	public static void main(String[] args) {
		//validate argument is passed
		if(args.length ==0){
			System.out.println("LGOO file required as parameter");
			return;
		}
		
		//get filename
		String lgooFile = args[0];
		
		//starts olympics
		new Main().startOlympics(lgooFile);
	}
	
	public void startOlympics(String lgooFile){
		//passes file to Olympian manager
		this.olympianManager = new OlympianManager(lgooFile);
		//loads teams
		this.teamManager = new TeamManager(olympianManager.getOlympains());
		//create events with teams
		this.eventManager = new EventManager(teamManager.getTeams());
		this.competitionManager = new CompetitionManager(eventManager);
		
		boolean exit = false;
		
		while (exit == false) {
			String userInput = null;

			//display menu
			System.out.println();
			System.out.println("Lawn Game Olympics");
			System.out.print("please enter in a command: ");
			
			//get user input
			try {
				userInput = input.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//determine command user set
			if (userInput.equals("e") || userInput.equals("events")) {
				listEvents();
			} else if (userInput.equals("o") || userInput.equals("olympians")) {
				listOlympians();
			} else if (userInput.equals("h") || userInput.equals("help")) {
				helpMenu();
			} else if (userInput.equals("q") || userInput.equals("quit")) {
				exit = true;
			} else if (userInput.equals("t") || userInput.equals("team")) {
				listTeams();
			} else if (userInput.equals("c") || userInput.equals("competitions")) {
				listCompetitions();
			} else if (userInput.equals("ec") || userInput.equals("endcompetition")) {
				endCompetition();
			} else {
				System.out.println("This is not a valid command please enter help for a list of valid commands");
			}
		}
	}

	/**
	 * End competition
	 */
	private void endCompetition() {
		//validate there are existing competitions
		if(competitionManager.getCompetitions().length == 0){
			System.out.println("There are no current competitions");
			return;
		}
		
		//select competition
		ICompetition competition = selectCompetition();
		//get winning team from user
		Team winningTeam = selectWinningTeam(competition);	
		
		//end competition
		competitionManager.endCompetition(competition, winningTeam);		
	}
	
	/**
	 * Prompts user for winning team
	 * @param competition
	 * @return Winning team
	 */
	private Team selectWinningTeam(ICompetition competition){
		//display teams
		System.out.println(
				"Team1: " +
				competition.getTeam1().getOlympian1().getName() + ", " + 
				competition.getTeam1().getOlympian2().getName());
		System.out.println("Team2: " + 
				competition.getTeam2().getOlympian1().getName() + ", " + 
				competition.getTeam2().getOlympian2().getName());
				
		int teamNum = -1;
		//loop until valid
		while(teamNum != 1 && teamNum != 2){
			//prompt for winning team
			System.out.print("Select the winning team (1-2): ");
			
			String sTeam = "";
			try {
				//get input
				sTeam = input.readLine();
				teamNum = Integer.parseInt(sTeam);
				
				//validate range
				if(teamNum != 1 && teamNum != 2){
					System.out.println("Invalid team choice");
				}
			} catch (IOException e) {
				//not a number
				System.out.println("Invalid entry");
			}
		}
		
		//get team based on index
		if(teamNum == 1){
			return competition.getTeam1();
		}
		return competition.getTeam2();
	}
	
	/**
	 * Select competition
	 * @return ICompetition
	 */
	private ICompetition selectCompetition(){
		//list competitions for the user
		listCompetitions();
		//get total number of competitions
		int numCompetitions = competitionManager.getCompetitions().length;		
		int competitionNum = -1;
		
		//loop until valid choice
		while(competitionNum < 1 || competitionNum > numCompetitions){
			//prompt for competition
			System.out.print("Select a competition (1-" + numCompetitions + "): ");
			
			String sComp = "";
			try {
				//read from user
				sComp = input.readLine();
				competitionNum = Integer.parseInt(sComp);
				
				//validate range
				if(competitionNum < 1 || competitionNum > numCompetitions){
					System.out.println("Invalid competition choice");
				}
			} catch (IOException e) {
				//was not a number
				System.out.println("Invalid entry");
			}
		}
		
		//return competition by index
		return competitionManager.getCompetitions()[competitionNum - 1];
	}

	/**
	 * List competitions
	 */
	private void listCompetitions() {
		competitionManager.printCompetitions();
	}

	/**
	 * List events
	 */
	private void listEvents() {
		eventManager.printEvents();
	}
	
	/**
	 * List olympians
	 */
	private void listOlympians() {
		olympianManager.printOlympians();
	}
	
	/**
	 * List teams
	 */
	private void listTeams() {
		teamManager.printTeams();
	}

	/**
	 * Display help menu
	 */
	private void helpMenu() {
		System.out.println();
		System.out.println("help menu");
		System.out
		.println("To access a list of the days events, type \"event\" or \"e\"" +  "\n"
				+ "To access a list of olympians type \"olympians\" or \"o\"" 	+  "\n"
				+ "To access a list of the teams, type \"team\" or \"t\"" 		+  "\n"
				+ "To access a list of the competitions, type \"competitions\" or \"c\""  +  "\n"
				+ "To start a new competition, type \"startcompetition\" or \"sc\""  +  "\n"
				+ "To end a running competition, type \"endcompetition\" or \"ec\"" +  "\n"
				+ "To quit the program type \"quit\" or \"q\"");
	}
}
