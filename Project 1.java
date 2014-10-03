import java.util.*;
public class Test {

	static String[] Eventinfo; 
	static String[][] OlympianData; 

	public static void main(String[] args){
		Scanner begin = new Scanner(System.in);
		welcomescreen();
	}

	public static void aryEvents(){
		int i;
		//array to hold the event names
		String Events[] = new String[6];
		Events[0] = "Egg Toss";  
		Events[1] = "Scavenger Hunt";
		Events[2] = "Trivia Contest"; 
		Events[3] = "Cribbage"; 
		Events[4] = "Croguet"; 
		Events[5] = "Dessert Contest"; 

		System.out.println("The Events of the day are: ");
		for(i = 0; i < Events.length; i++){
			System.out.println(Events[i]);
		}

		Eventinfo = Events;
		Returnscreen();
	}

	public static void aryOlympians(){

		int i;
		int j;

		//a matrix (two-dimensional array) for holding the Olympians
		String Olympians[][] = {{"Ben", "Acosta", "M", "20"},
				{"Gabriela", "Alford", "F", "23"}, 
				{"John", "Almanza", "M", "35"},
				{"Sam", "Hayward", "F", "25"}, 
				{"Gabe", "Cahill", "M", "21"}, 
				{"Mason", "Ogden", "M", "24"},
				{"Sophia", "Walden", "F", "22"}, 
				{"Emilia", "Arthur", "F", "20"},
				{"Michael", "Arriaga", "M", "32"},  
				{"Isabella", "Agnew", "F", "24"},
				{"Noah", "Mccaskill", "M", "29"},
				{"Aiden", "Lafferty", "M", "23"},
				{"Abigail", "Olsen", "F", "30"},
				{"Jaden", "Daily", "M", "33"},
				{"Liam", "Adamson", "M", "24"}};


		System.out.println("The Olympians of the day are: ");

		for(i = 0; i < Olympians.length; i++){
			for(j = 0; j < 4 ; j++){

				System.out.print("\t" + Olympians[i][j]);
			}	System.out.print("\n");

		}

		OlympianData = Olympians;
		Returnscreen();
	}
	public static void help(){
		String help = ("To view the Events of the day input 'e'."  +
				"\nTo view the Olympians of the day input 'o'.");
		System.out.println("Welcome to the Help Screen");	
		System.out.println(help);	
		Returnscreen(); 
	}

	public static void welcomescreen(){
		System.out.println("Welcome to the 2014 Lawn Olympic Games");
		Scanner begin = new Scanner(System.in);
		System.out.println("Input a command: ");
		String inputCom;
		inputCom = begin.nextLine();
		while(inputCom != "q") {

			if (inputCom.equals("events") || inputCom.equals("e")) {
				aryEvents(); // method to display the day's events.
			} else if (inputCom.equals("olympians") || inputCom.equals("o")) {
				aryOlympians(); // method to display the day's olympians
			} else if (inputCom.equals("help") || inputCom.equals("h")) {
				help(); // method to display the help screen
			} 
			System.out.println("Error: Please type the right command Or input 'h' to refer to the Help Screen.");
			inputCom = begin.nextLine();
		}
	}

	public static void Returnscreen(){
		Scanner begin = new Scanner(System.in);
		System.out.println("Input another command: ");
		String inputCom;
		inputCom = begin.nextLine();
		while(inputCom != "q") {

			if (inputCom.equals("events") || inputCom.equals("e")) {
				aryEvents(); // method to display the day's events.
			} else if (inputCom.equals("olympians") || inputCom.equals("o")) {
				aryOlympians(); // method to display the day's olympians
			} else if (inputCom.equals("help") || inputCom.equals("h")) {
				help(); // method to display the help screen
			} 
			System.out.println("Error: Please type the right command Or input 'h' to refer to the Help Screen.");
			inputCom = begin.nextLine();
		}
	}
}

