package ControllerLayer;


import DatabaseLayer.MatchDAOIF;
import ModelLayer.Match;

public class MatchController {
	MatchDAOIF mdao;
	
	public void createMatch(int teamOneID, int teamTwoID) {
		Match match = new Match(teamOneID, teamTwoID);
		mdao.createMatch(match);
	}
	
	public Match getMatchDetails(int matchID) {
		Match match = mdao.getMatchDetails(matchID);
		return match;
	}
	
	public void updateMatchDetails(int matchID) {
		mdao.updateMatchDetails(matchID);
		
	}

	public void setMatchDetails(int matchID, int playerID, int playerKills, int playerDeaths) {
		mdao.setMatchDetails(matchID, playerID, playerKills, playerDeaths);
		
	}
}
