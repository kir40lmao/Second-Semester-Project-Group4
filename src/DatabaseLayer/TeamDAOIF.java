package DatabaseLayer;

import java.util.List;
import java.util.function.Supplier;

import ModelLayer.Team;

public interface TeamDAOIF {

	void createTeam(String name);

	Team findTeamByID(int teamID);

	List<Team> getAllTeams();

	void updateTeamName(int teamID, String name);

	List<Team> HigherOrderFunctionForGetMethods(Supplier<String> stringSQL,int teamID,String tName);

	List<Team> getEligible();

	void updateTeamStats(int teamID, int wins, int loses, int matchID);

	Team findTeamByName(String teamName);
}
