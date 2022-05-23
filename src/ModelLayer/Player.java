package ModelLayer;

public class Player {
	private int playerID;
	private String gamerTag;
	private int teamID;
	private int totalKills;
	private int totalDeaths;
	
	
	public Player(int playerID, String gamerTag, int totalKills, int totalDeaths){
		this.playerID = playerID;
		this.gamerTag = gamerTag;
		this.totalKills = totalKills;
		this.totalDeaths = totalDeaths;
	}
	
	
	public Player(int playerID, String gamerTag, int teamID, int totalKills, int totalDeaths) {
		this.playerID = playerID;
		this.gamerTag = gamerTag;
		this.teamID = teamID;
		this.totalKills = totalKills;
		this.totalDeaths = totalDeaths;
	}
	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	
	public String getGamerTag() {
		return gamerTag;
	}
	public void setGamerTag(String gamerTag) {
		this.gamerTag = gamerTag;
	}
	
	public int getTeamID() {
		return teamID;
	}
	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
	
	public int getTotalKills() {
		return totalKills;
	}
	public void setTotalKills(int totalKills) {
		this.totalKills = totalKills;
	}
	
	public int getTotalDeaths() {
		return totalDeaths;
	}
	public void setTotalDeaths(int totalDeaths) {
		this.totalDeaths = totalDeaths;
	}
}
