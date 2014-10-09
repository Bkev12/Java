//Kevin Bruce 
//Java Project 2
//10-9-2014

import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
		//calls the constructor of this class in an instance
		Main myMain = new Main();
		myMain.run(args);
	}
	
	public static void run(String[] args){
		//calls the Welcome Screen where the user is able to input a command 	
		welcomescreen();
	} 

	public static void welcomescreen(){
		//creates an instance for the OlympianManager class
		OlympianManager myOLY = new OlympianManager();
		myOLY.getOlympian();
		//create an instance for the EventManager class
		EventManager myEV = new EventManager();
		myEV.getEvent();
		//creates an instance for the event class
		Event myInfo = new Event() {};
		Object[] getExtraInfo = myInfo.getExtraInfo();
		
		//Display the title whenever the program is executed
		System.out.println("Welcome to the 2014 Lawn Olympic Games");
		//calls the help Method. Displays the help screen the help user know what to input.
		help();
		//gives us permission to start entering commands 
		Scanner begin = new Scanner(System.in);
		System.out.println("Input a command: ");
		String inputCom;
		inputCom = begin.nextLine();
		while(inputCom != "q") {

			if (inputCom.equals("events") || inputCom.equals("e")) {
				myEV.print(); // method to display the day's events.
			} else if (inputCom.equals("olympians") || inputCom.equals("o")) {
				myOLY.print(); // method to display the day's olympian
			} else if (inputCom.equals("extrainfo") || inputCom.equals("ei")) {
				myInfo.print(); // method to display the day's event information
			} else if (inputCom.equals("help") || inputCom.equals("h")) {
				help(); // method to display the help screen
			} else
				System.out.println("Error: Please input the right command Or input 'h' to refer to the Help Screen.");
			inputCom = begin.nextLine();
		}
	}

	//the Help Method
	public static void help(){
		String help = ("To view the Events of the day input 'events' or 'e'."  +
				"\nTo view the Olympians of the day input olympians' or 'o'." +
				"\nTo view the Event Info input 'extrainfo' or 'ei'.");
		System.out.println("Help Screen");	
		System.out.println(help);	
	}
}	