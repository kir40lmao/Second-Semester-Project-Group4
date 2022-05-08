package DatabaseLayer;

public interface TeamDAOIF {

	void createTeam(String name);
	void findTeamByID(int teamID);
	void findAvailiableTeams();
	void getAllTeams();
	void updateTeamName(int teamID, String name);
	
}
