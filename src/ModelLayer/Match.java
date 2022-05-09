package ModelLayer;

import java.sql.Date;

public class Match {
	int matchID, teamOneID, teamTwoID, teamOneScore, teamTwoScore;
	Date date;
	long dateMilis;
	Integer[][] playerStats;
	
	public Match(int teamOneID, int teamTwoID) {
		//this.matchID = we will generate this somehow
		this.teamOneID = teamOneID;
		this.teamTwoID = teamTwoID;
		this.dateMilis = date.getTime();
		this.teamOneScore = 0;
		this.teamTwoScore = 0;
		playerStats = new Integer[10][3];
	}
	
	
	public Match(int matchID, int teamOneID, int teamTwoID, int teamOneScore, int teamTwoScore, Date date, Integer[][] playerStats) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer[][] getPlayerStats() {
		return playerStats;
	}

	public void setPlayerStats(Integer[][] playerStats) {
		this.playerStats = playerStats;
	}
	
}
