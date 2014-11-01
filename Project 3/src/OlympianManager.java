import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OlympianManager {
	//file name to load from
	private static final String FILE_NAME = "lgoo.txt";
	//num olympians to load
	private static final int NUM_OLYMPIANS = 16;
	//array of olympians
	private Olympian[] olympians = new Olympian[NUM_OLYMPIANS];
	
	public int olympianCount = 0;
	
	public OlympianManager(){
		loadOlympians();
	}

	/**
	 * Read file
	 * @return array of olympians
	 */
	private String[] readLgooFile() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(FILE_NAME));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("file not found");
		}
		String line = null;
		String[] tempArray = new String[NUM_OLYMPIANS];
		int i = 0;
		try {
			line = reader.readLine();
			if (line.equals("LGOO")) {
				while ((line = reader.readLine()) != null) {
					tempArray[i] = line;
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
		return tempArray;
	}

	/**
	 * Load olympians
	 */
	private void loadOlympians() {
		String[] rawOlympians = readLgooFile();
		int age;
		String name;
		Sex sex = null;
		for (int i = 0; i < rawOlympians.length; i++) {
			String[] tempArray = rawOlympians[i].split(",");
			name = tempArray[0];
			age = Integer.parseInt(tempArray[2]);
			if (tempArray[1].equals("M")) {
				sex = Sex.MALE;
			} else if (tempArray[1].equals("F")) {
				sex = Sex.FEMALE;
			}
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
		Olympian temp = new Olympian();
		temp.setName(name);
		temp.setSex(sex);
		temp.setAge(age);
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
