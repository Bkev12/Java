public abstract class Event {
	
	private String name;
	private int playTo;
	private boolean isPlayToExact;
	private int playDistance;
	//private String getExtraInfo;
	private Object[] ExtraInfo = new Object[7];
	Object t;
	//sets an instance for the CanJumpEvent class
	CanJumpEvent CJE = new CanJumpEvent(t,t,t);
	//sets an instance for the CornHoleEvent class
	CornHoleEvent CHE = new CornHoleEvent(t, playDistance, t);
	//sets an instance for the HorseShoesEvent class
	HorseShoesEvent HSE = new HorseShoesEvent(CHE, playDistance, CHE);
	//sets an instance for the LadderBallEvent class
	LadderBallEvent LBE = new LadderBallEvent(CHE, playDistance, CHE);
	//sets an instance for the StickGameEvent class
	StickGameEvent SGE = new StickGameEvent(CHE, playDistance, CHE);
	//sets an instance for the WashoosEvent class
	WashoosEvent WE = new WashoosEvent(CHE, playDistance, CHE);

	
	public Object[] getExtraInfo() {
		//sets an array for the getExtraInfo which gets the set values for each of them
		//and sets the corresponding values for getExtraInfo
		ExtraInfo[0] = CJE.getFrisbeeSize();
		ExtraInfo[1] = CHE.getnumBeanBags();
		ExtraInfo[2] = HSE.getnumHorsesShoes();
		ExtraInfo[3] = LBE.getnumRungs();
		ExtraInfo[4] = SGE.getFrisbeeSize();
		ExtraInfo[5] = WE.gethasAutoWinStick();
		ExtraInfo[6] = WE.getnumWashoos();
		
		return ExtraInfo; //returns the Object array ExtraInfo
	}

	public void print() {
		//outputs the extraInfo information to the console
		if (ExtraInfo.equals(ExtraInfo)) {
			System.out.println("The frisbee size in inches for CanJumpEvent is: " + ExtraInfo[0]);
			System.out.println("The number of BeanBags for CornHoleEvent are : " + ExtraInfo[1]);
			System.out.println("The number of HorsesShoes for HorseShoesEvent are: " + ExtraInfo[2]);
			System.out.println("The number of Rungs for LadderBallEvent are: " + ExtraInfo[3]);
			System.out.println("The frisbee size in inches for StickGameEvent is: " + ExtraInfo[4]);
			System.out.println("AutoWinStick value = " + ExtraInfo[5]);
			System.out.println("The number of Washoos for WashoosEvent are: " + ExtraInfo[6]);
		}
	}

	public String name() {
		return name; //returns name
	}

	public int playTo() {
		return playTo;  //returns playTo
	}

	public boolean isPlayToExact() {
		return isPlayToExact; //returns isPlayToExact
	}

	public int playDistance() {
		return playDistance; //returns playDistance
	}
}
