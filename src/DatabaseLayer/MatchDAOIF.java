package DatabaseLayer;


import ModelLayer.Match;

public interface MatchDAOIF {
	void createMatch(Match match);
	Match getMatchDetails(int matchID);
	void updateMatchScore(int matchID, int teamOneScore, int teamtwoScore);
	void updatePlayerMatchStats(int matchID, int playerID, int playerKills, int playerDeaths);
}
