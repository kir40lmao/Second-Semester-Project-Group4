package DatabaseLayer;

public interface TeamDAOIF {

	void createTeam(String name);
	void findTeamByID(int teamID);
	void getAllTeams();
	void updateTeamName(int teamID, String name);
	void getElidgeable();
	
}
