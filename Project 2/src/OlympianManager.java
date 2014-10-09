public class OlympianManager {
	
	private Object[][] Olympian; //creates a local variable for Olympian's
	
		public OlympianManager(){
			//creates an Object array and sets it to the Name, Sex, and Age of the Olympian's
			Object myOlympians[][] = new String[4][15];
					myOlympians[0][0] = "Ben Acosta, M , 20";
					myOlympians[0][1] = "Gabriela Alford, F, 23";
					myOlympians[0][2] = "John Almanza , M , 35";
					myOlympians[0][3] = "Sam Hayward , F , 25";
					myOlympians[0][4] = "Gabe Cahill , M, 21";
					myOlympians[0][5] = "Mason Ogden , M , 24";
					myOlympians[0][6] = "Sophia Walden , F , 22";
					myOlympians[0][7] = "Emilia Arthur , F, 20";
					myOlympians[0][8] = "Michael Arriaga , M , 32";
					myOlympians[0][9] = "Isabella Agnew , F , 24";
					myOlympians[0][10] = "Noah Mccaskill , M , 29";
					myOlympians[0][11] = "Aiden Lafferty , M , 23";
					myOlympians[0][12] = "Abigail Olsen , F , 30";
					myOlympians[0][13] = "Jaden Daily , M , 33";
					myOlympians[0][14] = "Liam Adamson , M , 24";
			Olympian = myOlympians; //sets Olympian to myOlympians
		}
		public Object[][] getOlympian(){
			return Olympian; //returns Olympian
		}
		public void setOlympian(String[][] Olympian){ 
			this.Olympian = Olympian; //sets the local variable Olympian to Olympian, the argument sent to the method
		}
		
		public void print(){
				//Displays the Object array Olympian to the console as a String
				for(int j = 0; j < Olympian[0].length; j++){
				System.out.println(Olympian[0][j]);
				}
		}
}


