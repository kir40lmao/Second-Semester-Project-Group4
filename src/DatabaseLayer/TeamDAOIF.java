package DatabaseLayer;

import java.util.function.Supplier;

public interface TeamDAOIF {

	void createTeam(String name);
	void findTeamByID(int teamID);
	void getAllTeams();
	void updateTeamName(int teamID, String name);
	void HigherOrderFunctionForGetMethods(Supplier<String> stringSQL);
	void getEligible();
	
}
