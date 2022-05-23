package DatabaseLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import ModelLayer.Player;
import ModelLayer.Team;

public interface TeamDAOIF {

	void createTeam(String name);

	Team findTeamByID(int teamID);

	List<Team> getAllTeams();

	void updateTeamName(int teamID, String name);

	List<Team> HigherOrderFunctionForGetMethods(Supplier<String> stringSQL,  Supplier<String> tName);

	List<Team> getEligible();
	
	void updateTeamStats(int winningTeamID, int losingTeamID,int matchID);
	
	ArrayList<Player> PopulateArray(int teamID);

	Team findTeamByName(String teamName);
	
	List<Team> getTeamsInTournament(String tournamentName);
	
	void addTeamsToTournament(int tournamentID, int teamID);
}
