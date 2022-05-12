package ModelLayer;


import java.util.Random;

public class Match {
	int matchID, teamOneID, teamTwoID, teamOneScore, teamTwoScore;
	String date;
	Integer[][] playerStats;
	Random random = new Random();
	
	public Match(int teamOneID, int teamTwoID, String date) {
		this.matchID = random.nextInt(99999999);
		this.teamOneID = teamOneID;
		this.teamTwoID = teamTwoID;
		this.date = date;
		this.teamOneScore = 0;
		this.teamTwoScore = 0;
		playerStats = new Integer[10][3];
	}
	
	
	public Match(int matchID, int teamOneID, int teamTwoID, int teamOneScore, int teamTwoScore, String date, Integer[][] playerStats) {
		this.matchID = matchID;
		this.teamOneID = teamOneID;
		this.teamTwoID = teamTwoID;
		this.teamOneScore = teamOneScore;
		this.teamTwoScore = teamTwoScore;
		this.date = date;
		this.playerStats = playerStats;
	
	}


	public int getMatchID() {
		return matchID;
	}

	public void setMatchID(int matchID) {
		this.matchID = matchID;
	}

	public int getTeamOneID() {
		return teamOneID;
	}

	public void setTeamOneID(int teamOneID) {
		this.teamOneID = teamOneID;
	}

	public int getTeamTwoID() {
		return teamTwoID;
	}

	public void setTeamTwoID(int teamTwoID) {
		this.teamTwoID = teamTwoID;
	}

	public int getTeamOneScore() {
		return teamOneScore;
	}

	public void setTeamOneScore(int teamOneScore) {
		this.teamOneScore = teamOneScore;
	}

	public int getTeamTwoScore() {
		return teamTwoScore;
	}

	public void setTeamTwoScore(int teamTwoScore) {
		this.teamTwoScore = teamTwoScore;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer[][] getPlayerStats() {
		return playerStats;
	}

	public void setPlayerStats(Integer[][] playerStats) {
		this.playerStats = playerStats;
	}
	
}
