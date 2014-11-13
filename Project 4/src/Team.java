public class Team {
	private Olympian olympian1;
	private Olympian olympian2;
	private int wins;
	private int losses;

	/**
	 * Create Team
	 * Initialize wins and losses to 0
	 * @param olympian1
	 * @param olympian2
	 */
	public Team(Olympian olympian1, Olympian olympian2){
		this.olympian1 = olympian1;
		this.olympian2 = olympian2;
		this.wins = 0;
		this.losses = 0;
	}
	
	/**
	 * Set olympian1
	 * @param olympian1
	 */
	public void setOlympian1(Olympian olympian1) {
		this.olympian1 = olympian1;
	}
	
	/**
	 * Set olympian2
	 * @param olympian2
	 */
	public void setOlympian2(Olympian olympian2) {
		this.olympian2 = olympian2;
	}
	
	/**
	 * Set wins
	 * @param wins
	 */
	public void setWins(int wins) {
		this.wins = wins;
	}
	
	/**
	 * Set losses
	 * @param losses
	 */
	public void setLosses(int losses) {
		this.losses = losses;
	}
	
	/**
	 * Get olympian1
	 * @return olympian1
	 */
	public Olympian getOlympian1() {
		return this.olympian1;
	}
	
	/**
	 * Set olympian2
	 * @return olympian2
	 */
	public Olympian getOlympian2() {
		return this.olympian2;
	}
	
	/**
	 * Get wins
	 * @return wins
	 */
	public int getWins() {
		return this.wins;
	}
	
	/**
	 * Get losses
	 * @return losses
	 */
	public int getLosses() {
		return this.losses;
	}
	
	/**
	 * Increment wins
	 */
	public void incrementWins(){
		wins++;
	}
	
	/**
	 * Increment losses
	 */
	public void incrementLosses(){
		losses++;
	}
}
