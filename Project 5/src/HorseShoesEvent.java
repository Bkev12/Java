
public class HorseShoesEvent extends Event {

	int numHorseShoes;
	
	public HorseShoesEvent(Team[] teams) {
		super(teams);
	}

	/**
	 * Get num horseshoes
	 * @return num horseshoes
	 */
	public int getNumHorseShoes() {
		return numHorseShoes;
	}

	/**
	 * Set num horseshoes
	 * @param numHorseShoes
	 */
	public void setNumHorseShoes(int numHorseShoes) {
		this.numHorseShoes = numHorseShoes;
	}

	@Override
	public String getExtraInfo() {
		return "Number of horse shoes: " + this.numHorseShoes;
	}
}
