import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OlympianManager {
	//max num olympians to load
	private static final int MAX_OLYMPIANS = 1000;
	
	//file name to load from
	private String lgooFile;
	//array of olympians
	private Olympian[] olympians;
	//olympian count
	private int olympianCount = 0;
	
	/**
	 * Create olympian manager
	 * @param lgooFile file of olympians
	 */
	public OlympianManager(String lgooFile){
		this.lgooFile = lgooFile;
		loadOlympians();
	}

	/**
	 * Read file
	 * @return array of olympians
	 */
	private String[] readLgooFile() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(this.lgooFile));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("file not found");
		}
		String line = null;
		
		//create temp array to hold lines
		String[] tempArray = new String[MAX_OLYMPIANS];
		int i = 0;
		try {
			//read first line
			line = reader.readLine();
			//make sure line 1 is valid file for lgoo
			if (line != null && line.equals("LGOO")) {	
				//read file line by line
				while ((line = reader.readLine()) != null) {
					//assign to array
					tempArray[i] = line;
					//increment line counter
					i++;
				}
			} else {
				System.out.println("Can not read file, it is not of type LGOO");
			}
		} catch (IOException e) {
			System.out.println("File can not be read");
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//resizes array based on num elements read
		String[] olympianArray = new String[i];
		//loop until max 
		for(int index=0; index < i; index++){
			olympianArray[index] = tempArray[index];
		}
		return olympianArray;
	}

	/**
	 * Load olympians
	 */
	private void loadOlympians() {
		//get string array from file
		String[] rawOlympians = readLgooFile();
		//initialize olympians array
		this.olympians = new Olympian[rawOlympians.length];
		
		int age;
		String name;
		Sex sex = null;
		//loop through string array
		for (int i = 0; i < rawOlympians.length; i++) {
			//split on comma
			String[] tempArray = rawOlympians[i].split(",");
			//get name
			name = tempArray[0];
			//get age
			age = Integer.parseInt(tempArray[2]);
			//get sex
			if (tempArray[1].equals("M")) {
				sex = Sex.MALE;
			} else if (tempArray[1].equals("F")) {
				sex = Sex.FEMALE;
			}
			//add olympian
			addOlympian(name, sex, age);
		}
	}

	/**
	 * Add olympian to array
	 * @param name
	 * @param sex
	 * @param age
	 */
	private void addOlympian(String name, Sex sex, int age) {
		//create olympian
		Olympian temp = new Olympian(name, sex, age);
		//update array
		olympians[olympianCount] = temp;
		olympianCount++;
	}

	/**
	 * Get olympians
	 * @return array of olympians
	 */
	public Olympian[] getOlympains() {
		return olympians;
	}

	/**
	 * Print olympians
	 */
	public void printOlympians() {
		System.out.println();
		System.out.println("List of Olympians");
		for (int i = 0; i < olympianCount; i++) {
			System.out.print(olympians[i].getName() + ",");
			System.out.print(olympians[i].getSex() + ",");
			System.out.println(olympians[i].getAge());
		}
	}
}
