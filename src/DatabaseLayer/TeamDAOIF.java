package DatabaseLayer;

public interface TeamDAOIF {
	void createTournament(String name);
	void findTournament(int tournamentID);
	void getAllTournaments();
	void getUpcoming();
	void getOngoing();
	//void getFinished(); - not in DCD; could maybe just be UI method
	void updateTournament(int tournamentID);
	void deleteTournament(int tournamentID);
	
}
