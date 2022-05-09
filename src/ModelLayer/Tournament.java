package ModelLayer;

public class Tournament {
	
	// We are storing date in a string for now and when we add it to the database we make it a Date.
	
	private int tournamentID;
	private String date;
	private String venue;
	private String tournamentName;
	private String status;
	
	// We use this constructor in the DAO read methods.
	
	public Tournament() {	
	
	}
	
	// We use this constructor when creating a tournament.
	
	public Tournament(int tournamentID, String tournamentName, String date) {
		this.tournamentID = tournamentID;
		this.tournamentName = tournamentName;
		this.date = date;
	}
	
	// We use this constructor when updating the tournament.
	
	public Tournament(int tournamentID, String date, String venue, String tournamentName, String status) {
		this.tournamentID = tournamentID;
		this.date = date;
		this.venue = venue;
		this.tournamentName = tournamentName;
		this.status = status;
	}
	
	// Getters and setters.
	
	public int getTournamentID() {
		return tournamentID;
	}

	public void setTournamentID(int tournamentID) {
		this.tournamentID = tournamentID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
