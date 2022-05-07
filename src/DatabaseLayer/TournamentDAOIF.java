package DatabaseLayer;

import java.sql.Date;

public interface TournamentDAOIF {
	public void createTournament(String name, String date);
	public Tournament findTournamentByID(int tournamentID);
	public Tournament getAllTournaments();
	public Tournament getUpcoming();
	public Tournament getOngoing();
	public void updateTournament(int tournamentID, String tournamentName, String date, String Venue, boolean status);
	public void deleteTournament(int tournamentID);
}
