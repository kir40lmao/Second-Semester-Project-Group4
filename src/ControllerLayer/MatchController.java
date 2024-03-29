package ControllerLayer;


import java.util.List;

import DatabaseLayer.MatchDAO;
import DatabaseLayer.MatchDAOIF;
import ModelLayer.Match;

public class MatchController {
	MatchDAOIF mdao = new MatchDAO();
	
	public void createMatch(int teamOneID, int teamTwoID, String date) {
		Match match = new Match(teamOneID, teamTwoID, date);
		mdao.createMatch(match);
	}
	
	public Match getMatchDetails(int matchID) {
		Match match = mdao.getMatchDetails(matchID);
		return match;
	}
	
	public void updateMatchScore(int matchID, int teamOneScore, int teamTwoScore) {
		mdao.updateMatchScore(matchID, teamOneScore, teamTwoScore);
		
	}

	public void updatePlayerMatchStats(int matchID, int playerID, int playerKills, int playerDeaths) {
		mdao.updatePlayerMatchStats(matchID, playerID, playerKills, playerDeaths);
		
	}
	
	public List<Match> getAllMatchesFromTournament(int tournamentID){
		List<Match> matches = mdao.getAllMatchesFromTournament(tournamentID);
		return matches;
	}
	
	public void updateMatch(int matchID, String date, int teamOneID, int teamTwoID) {
		mdao.updateMatch(matchID, date, teamOneID, teamTwoID);
	}
}
