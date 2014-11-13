public class Olympian {

	private String name; //sets a local String for the name
	private Sex sex; //sets a local sex variable for the sex
	private int age ; //sets a local integer for the age
	
	public Olympian(){
		
	}
	
	/**
	 * Create olympian
	 * @param name
	 * @param sex
	 * @param age
	 */
	public Olympian(String name, Sex sex, int age){
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	
	/**
	 * Get name 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get sex
	 * @return sex
	 */
	public Sex getSex() {
		return sex;
	}
	
	/**
	 * Set sex
	 * @param sex
	 */
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	/**
	 * Get age
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Set age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}


}

