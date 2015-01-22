package xcom.log;

public class Operation extends Event {
	public static final int MAX_SOLDIERS_PER_MISSION = 12;
	
	// Mission Types
	public static final int ALIEN_ABDUCTION = 	0;
	public static final int UFO_CRASH = 		1;
	public static final int UFO_LANDING = 		2;
	public static final int TERROR_ATTACK = 	3;
	public static final int TARGET_EXTRACTION = 4;
	public static final int TARGET_ESCORT = 	5;
	public static final int ASSET_RECOVERY = 	6;
	public static final int BOMB_DISPOSAL = 	7;
	public static final int SLINGSHOT = 		8;
	public static final int PROGENY = 			9;
	public static final int BASE_ASSAULT = 		10;
	public static final int BASE_DEFENSE = 		11;
	public static final int SITE_RECON = 		12;
	public static final int TEMPLE_SHIP = 		13;
	public static final int COVERT_EXTRACTION = 14;
	public static final int COVERT_RECOVERY = 	15;
	public static final int EXALT_BASE = 		16;
	
	// Locations
	public static final int UNITED_STATES = 	0;
	public static final int CANADA = 			1;
	public static final int MEXICO = 			2;
	public static final int ARGENTINA = 		3;
	public static final int BRAZIL = 			4;
	public static final int EGYPT = 			5;
	public static final int SOUTH_AFRICA = 		6;
	public static final int NIGERIA = 			7;
	public static final int UNITED_KINGDOM = 	8;
	public static final int RUSSIA = 			9;
	public static final int FRANCE = 			10;
	public static final int GERMANY = 			11;
	public static final int CHINA = 			12;
	public static final int JAPAN = 			13;
	public static final int INDIA = 			14;
	public static final int AUSTRALIA = 		15;
	
	// Outcomes
	public static final int SUCCESS = 	0;
	public static final int ABORTED = 	1; // failed with surviving soldiers
	public static final int FAILED = 	2; // failed without surviving soldiers
	
	private String name;
	private static int numberOfOperations = 0;
	private int operationId;	// first mission is 0, second is 1...
	private int location;
	private int kills;
	private int type;
	private int deaths;
	private int injuries;
	private int meld;
	private int elerium;
	private int alloys;
	private int fragments;
	private int civiliansSaved;
	private int outcome;
	private int[] soldierId = new int[MAX_SOLDIERS_PER_MISSION];	// the id numbers of soldiers on the mission
	
	Operation() {
		operationId = numberOfOperations;
		numberOfOperations++;
		this.majorEvent = true;
	}
	
	Operation(int type, int location) {
		this.type = type;
		this.location = location;
		operationId = numberOfOperations;
		numberOfOperations++;
		this.majorEvent = true;
	}
	
	// Precondition: soldierId must be of length 12 or less
	Operation(int type, int location, int[] soldierId) {
		this.type = type;
		this.location = location;
		for (int i = 0; i < soldierId.length; i++) {
			this.soldierId[i] = soldierId[i];
		}
		operationId = numberOfOperations;
		numberOfOperations++;
		this.majorEvent = true;
	}
	
	Operation(Operation operation) {
		this.name = operation.getName();
		this.operationId = operation.getOperationId();
		this.location = operation.getLocation();
		this.kills = operation.getKills();
		this.type = operation.getType();
		this.deaths = operation.getDeaths();
		this.injuries = operation.getInjuries();
		this.meld = operation.getMeld();
		this.elerium = operation.getElerium();
		this.alloys = operation.getAlloys();
		this.fragments = operation.getFragments();
		this.civiliansSaved = operation.getCiviliansSaved();
		this.outcome = operation.getOutcome();
		this.soldierId = operation.getSoldierId();
		this.majorEvent = true;
		// doesn't add to number of operations
	}
	
	public String getName() {
		return name;
	}
	
	public int getOperationId() {
		return operationId;
	}
	
	public int getLocation() {
		return location;
	}
	
	public int getKills() {
		return kills;
	}
	
	public int getType() {
		return type;
	}
	
	public int getDeaths() {
		return deaths;
	}
	
	public int getInjuries() {
		return injuries;
	}
	
	public int getMeld() {
		return meld;
	}
	
	public int getElerium() {
		return elerium;
	}
	
	public int getAlloys() {
		return alloys;
	}
	
	public int getFragments () {
		return fragments;
	}
	
	public int getCiviliansSaved() {
		return civiliansSaved;
	}
	
	public int getOutcome() {
		return outcome;
	}
	
	public int[] getSoldierId() {
		int[] soldierIdCopy = new int[MAX_SOLDIERS_PER_MISSION];
		
		for (int i = 0; i < soldierIdCopy.length; i++) {
			soldierIdCopy[i] = soldierId[i];
		}
		
		return soldierIdCopy;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLocation(int location) {
		this.location = location;
	}
	
	public void setKills(int kills) {
		this.kills = kills;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	
	public void setInjuries(int injuries) {
		this.injuries = injuries;
	}
	
	public void setMeld(int meld) {
		this.meld = meld;
	}
	
	public void setElerium(int elerium) {
		this.elerium = elerium;
	}
	
	public void setAlloys(int alloys) {
		this.alloys = alloys;
	}
	
	public void setFragments(int fragments) {
		this.fragments = fragments;
	}
	
	public void setCiviliansSaved(int civiliansSaved)	{
		this.civiliansSaved = civiliansSaved;
	}
	
	public void setOutcome(int outcome)	{
		this.outcome = outcome;
	}

	// Precondition: soldierId must be length 12 or less
	public void setSoldierIDs(int[] soldierId) {
		for (int i = 0; i < soldierId.length; i++) {
			this.soldierId[i] = soldierId[i];
		}
	}
	
	public String toString() {
		String output;
		output = "\nName:\t" 		+ this.name
				+ "\nID:\t" 		+ this.operationId
				+ "\nLocation:\t"	+ this.location
				+ "\nKills:\t"		+ this.kills
				+ "\nType:\t"		+ this.type
				+ "\nDeaths:\t"		+ this.deaths
				+ "\nInjuries:\t"	+ this.injuries
				+ "\nMeld:\t"		+ this.meld
				+ "\nElerium:\t"	+ this.elerium
				+ "\nAlloys:\t"		+ this.alloys
				+ "\nFragments:\t"	+ this.fragments
				+ "\nOutcome:\t"	+ this.outcome;
		
		if (this.type == TERROR_ATTACK)
			output += "\nCivilians:\t" + this.civiliansSaved;
		
		output += "\nSoldiers:\t";
		
		for (int i = 0; i < soldierId.length; i++) {
			output += soldierId[i] + " ";
		}
				
		return output;
	}
}
