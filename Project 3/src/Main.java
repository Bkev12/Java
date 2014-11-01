import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	//variables for main program to access
	private OlympianManager olympianManager = new OlympianManager();
	private EventManager eventManager = new EventManager();
	private TeamManager teamManager;
	
	public static void main(String[] args) {
		//starts olympics
		new Main().startOlympics();
	}
	
	public void startOlympics(){
		//loads teams
		teamManager = new TeamManager(olympianManager.getOlympains());		
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
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
			} else {
				System.out.println("This is not a valid command please enter help for a list of valid commands");
			}
		}
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
				+ "To quit the program type \"quit\" or \"q\"");
	}
}
