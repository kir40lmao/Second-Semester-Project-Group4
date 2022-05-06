package DatabaseLayer;

import java.sql.Date;

public interface MatchDAOIF {
	void createMatch(int teamOneID,int teamTwoID,Date date);
	void getMatchDetails(int matchID);
	void updateMatchDetails(int matchID);
	void setMatchWinner(int winningTeamID);
	void setMatchDetails(int playerKills,int playerDeaths);
}
