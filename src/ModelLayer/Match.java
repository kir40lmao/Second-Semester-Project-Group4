package ModelLayer;

import java.sql.Date;

public class Match {
	int matchID, teamOneID, teamTwoID, teamOneScore, teamTwoScore;
	Date date;
	Integer[][] playerStats;
	
	public Match(int teamOneID, int teamTwoID, Date date) {
		//this.matchID = we will generate this somehow
		this.teamOneID = teamOneID;
		this.teamTwoID = teamTwoID;
		this.date = date;
		this.teamOneScore = 0;
		this.teamTwoScore = 0;
		playerStats = new Integer[10][3];
	}

	
	int getMatchID() {
		return matchID;
	}

	void setMatchID(int matchID) {
		this.matchID = matchID;
	}

	int getTeamOneID() {
		return teamOneID;
	}

	void setTeamOneID(int teamOneID) {
		this.teamOneID = teamOneID;
	}

	int getTeamTwoID() {
		return teamTwoID;
	}

	void setTeamTwoID(int teamTwoID) {
		this.teamTwoID = teamTwoID;
	}

	int getTeamOneScore() {
		return teamOneScore;
	}

	void setTeamOneScore(int teamOneScore) {
		this.teamOneScore = teamOneScore;
	}

	int getTeamTwoScore() {
		return teamTwoScore;
	}

	void setTeamTwoScore(int teamTwoScore) {
		this.teamTwoScore = teamTwoScore;
	}

	Date getDate() {
		return date;
	}

	void setDate(Date date) {
		this.date = date;
	}

	Integer[][] getPlayerStats() {
		return playerStats;
	}

	void setPlayerStats(Integer[][] playerStats) {
		this.playerStats = playerStats;
	}
	
}
