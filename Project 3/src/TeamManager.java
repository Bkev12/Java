
public class TeamManager {
	private Team[] teams = new Team[8];
	private int teamCount = 0;
	private Olympian[] olympians;
	private Olympian extra = new Olympian();
	
	
	public TeamManager(Olympian[] olympians) {
		this.olympians = olympians;
		loadTeams();
	}

	/**
	 * load teams
	 */
	private void loadTeams() {
		Olympian[] femaleOlympians = new Olympian[olympians.length];
		Olympian[] maleOlympians = new Olympian[olympians.length];
		int maleCount = 0;
		int femaleCount = 0;
		for (int i = 0; i < olympians.length; i++) {
			if (olympians[i].getSex().equals(Sex.MALE)) {
				maleOlympians[maleCount] = olympians[i];
				maleCount++;
			} else if (olympians[i].getSex().equals(Sex.FEMALE)) {
				femaleOlympians[femaleCount] = olympians[i];
				femaleCount++;
			}
		}

		// creates teams from the arrays maleOlympians and femaleOlympians
		// if statment with two elseifs that check to see if the # of male
		// olympians = # of female olympians if not then which group is
		// larger
		if (maleCount == femaleCount) {
			// while loop that creates a random number and then uses that
			// number to determine the teams
			// the same number can not be used twice or one person would be
			// on multiple teams
			int[] maleUsedIndexes = new int[maleCount];
			for (int i = 0; i < maleUsedIndexes.length; i++) {
				maleUsedIndexes[i] = -1;
			}

			int indexCount = 0;
			boolean withinArray;
			int[] femaleUsedIndexes = new int[femaleCount];
			for (int i = 0; i < femaleUsedIndexes.length; i++) {
				femaleUsedIndexes[i] = -1;
			}
			int indexCount2 = 0;
			boolean withinArray2;
			for (int r = 0; r < maleCount; r++) {
				int rand = 0;
				withinArray = true;
				while (withinArray == true) {
					int tempCount = 0;
					rand = (int) ((Math.random() * (maleCount)));
					for (int i = 0; i < maleUsedIndexes.length; i++) {
						if (maleUsedIndexes[i] != rand) {
							tempCount++;
						}
					}
					if (tempCount == maleUsedIndexes.length) {
						withinArray = false;
					}
				}
				int rand2 = 0;
				withinArray2 = true;
				while (withinArray2 == true) {
					int tempCount = 0;
					rand2 = (int) ((Math.random() * (maleCount)));
					for (int i = 0; i < femaleUsedIndexes.length; i++) {
						if (femaleUsedIndexes[i] != rand2) {
							tempCount++;
						}
					}
					if (tempCount == femaleUsedIndexes.length) {
						withinArray2 = false;
					}
				}
				addTeam(maleOlympians[rand], femaleOlympians[rand2], 0, 0);
				femaleUsedIndexes[indexCount2] = rand2;
				maleUsedIndexes[indexCount] = rand;
				indexCount++;
				indexCount2++;
			}
		} else if (maleCount < femaleCount) {
			// this block of code is used when there are more female olympians
			// then males
			int[] maleUsedIndexes = new int[maleCount];
			for (int i = 0; i < maleUsedIndexes.length; i++) {
				maleUsedIndexes[i] = -1;
			}
			int indexCount = 0;
			int[] femaleUsedIndexes = new int[femaleCount];
			for(int i =0; i < femaleUsedIndexes.length; i++){
				femaleUsedIndexes[i] = -1;
			}
			int indexCount2 =0;
			for (int i1 = 0; i1 < maleCount; i1++) {
				int rand = 0;
				boolean withinArray = true;
				while (withinArray == true) {
					int tempCount = 0;
					rand = (int) ((Math.random() * (maleCount)));
					for (int i = 0; i < maleUsedIndexes.length; i++) {
						if (maleUsedIndexes[i] != rand) {
							tempCount++;
						}
					}
					if (tempCount == maleUsedIndexes.length) {
						withinArray = false;
					}
				}
				int rand2 =0;
				boolean withinArray2 = true;
				while(withinArray2 == true){
					int tempCount = 0;
					rand2 = (int) ((Math.random() * (femaleCount)));
					for (int i = 0; i < femaleUsedIndexes.length; i++) {
						if (femaleUsedIndexes[i] != rand2) {
							tempCount++;
						}
					}
					if (tempCount == femaleUsedIndexes.length) {
						withinArray = false;
					}
				}
				addTeam(maleOlympians[rand], femaleOlympians[rand2], 0, 0);
				femaleUsedIndexes[indexCount2] = rand2;
				maleUsedIndexes[indexCount] = rand;
				indexCount2++;
				indexCount++;
			}
			for (int i2 = maleCount; i2 < femaleCount - 1; i2 += 2) {
				// puts the remaing olympians on a team
				addTeam(femaleOlympians[i2], femaleOlympians[i2 + 1], 0, 0);
			}
			if ((femaleCount - maleCount) % 2 != 0) {
				// if there is an odd number of olympians the last one is put on
				// a team by themselves
				int rand3 = 0;
				boolean finalWithin = true;
				while (finalWithin == true) {
					rand3 = (int) ((Math.random() * (femaleCount)));
					int tempCount = 0;
					for (int i = 0; i < femaleUsedIndexes.length; i++) {
						if (femaleUsedIndexes[i] != rand3) {
							tempCount++;
						}
					}
					if (tempCount == femaleUsedIndexes.length) {
						finalWithin = false;
					}
				}
				extra = femaleOlympians[rand3];
			}
		} else if (femaleCount < maleCount) {
			// same concept as the elseif above execpt this is used when there
			// is a greater number of male Olympians
			int[] maleUsedIndexes = new int[maleCount];
			for (int i = 0; i < maleUsedIndexes.length; i++) {
				maleUsedIndexes[i] = -1;
			}
			int indexCount = 0;
			int[] femaleUsedIndexes = new int[maleCount];
			for (int i = 0; i < femaleUsedIndexes.length; i++) {
				femaleUsedIndexes[i] = -1;
			}
			int femaleIndexCount = 0;
			for (int r = 0; r < femaleCount; r++) {
				int rand = 0;
				boolean withinArray = true;
				while (withinArray == true) {
					int tempCount = 0;
					rand = (int) ((Math.random() * (maleCount)));
					for (int i = 0; i < maleUsedIndexes.length; i++) {
						if (maleUsedIndexes[i] != rand) {
							tempCount++;
						}
					}

					if (tempCount == maleUsedIndexes.length) {
						withinArray = false;
					}
				}
				int rand2 = 0;
				boolean withinArray2 = true;
				while (withinArray2 == true) {
					int tempCount2 = 0;
					rand2 = (int) ((Math.random() * (femaleCount)));
					for (int i = 0; i < femaleUsedIndexes.length; i++) {
						if (femaleUsedIndexes[i] != rand2) {
							tempCount2++;
						}
					}
					if (tempCount2 == femaleUsedIndexes.length) {
						withinArray2 = false;
					}
				}
				addTeam(maleOlympians[rand], femaleOlympians[rand2], 0, 0);
				maleUsedIndexes[indexCount] = rand;
				femaleUsedIndexes[femaleIndexCount] = rand2;
				femaleIndexCount++;
				indexCount++;
			}
			for (int r2 = maleCount; r2 < maleCount - 1; r2 += 2) {
				addTeam(maleOlympians[r2], maleOlympians[r2 + 1], 0, 0);
			}
			if ((maleCount - femaleCount) % 2 != 0) {
				int rand3 = 0;
				boolean finalWithin = true;
				while (finalWithin == true) {
					rand3 = (int) ((Math.random() * (maleCount)));
					int tempCount = 0;
					for (int i = 0; i < maleUsedIndexes.length; i++) {
						if (maleUsedIndexes[i] != rand3) {
							tempCount++;
						}
					}
					if (tempCount == maleUsedIndexes.length) {
						finalWithin = false;
					}
				}
				extra = maleOlympians[rand3];
			}
		}
	}
	
	private void addTeam(Olympian olympian1, Olympian olympian2, int wins, int losses) {
		Team temp = new Team();
		temp.setOlympian1(olympian1);
		temp.setOlympian2(olympian2);
		temp.setWins(wins);
		temp.setLosses(losses);
		teams[teamCount] = temp;
		teamCount++;
	}
	
	/**
	 * Print teams
	 */
	public void printTeams() {
		System.out.println();
		System.out.println("list of teams");
		for (int i = 0; i < teamCount; i++) {
			System.out.print(teams[i].getOlympian1().getName() + ",");
			System.out.print(teams[i].getOlympian1().getSex() + ",");
			System.out.print(teams[i].getOlympian1().getAge() + ",");
			System.out.print(teams[i].getOlympian2().getName() + ",");
			System.out.print(teams[i].getOlympian2().getAge() + ",");
			System.out.print(teams[i].getOlympian2().getSex() + ",");
			System.out.print(teams[i].getWins() + ",");
			System.out.println(teams[i].getLosses());
		}
		if (extra.getName() != null) {
			System.out.print(extra.getName() + ",");
			System.out.print(extra.getSex() + ",");
			System.out.print(extra.getAge());
		}
	}
}
