package DatabaseLayer;


import ModelLayer.Match;

public interface MatchDAOIF {
	void createMatch(Match match);
	Match getMatchDetails(int matchID);
	void updateMatchDetails(int matchID, int teamOneScore, int teamtwoScore);
	void setMatchDetails(int matchID, int playerID, int playerKills, int playerDeaths);
}
