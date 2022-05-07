package ModelLayer;

import java.sql.Date;


public class Tournament {
	
	private int tournamentID;
	private String dateString;
	// we are storing date in a string for now and when we add it to the database we make it a Date.
	private String date;
	private String venue;
	private String tournamentName;
	private boolean isInProgress;
	private boolean isFinished;
	
	public Tournament() {
		
	}
	public Tournament(int tournamentID, String date, String venue, String tournamentName) {
		this.tournamentID = tournamentID;
		this.date = date;
		this.venue = venue;
		this.tournamentName = tournamentName;
//	isInProgress is checking if it's in progress or ongoing and isFinished is checking if the event has been concluded.
		this.isInProgress = isInProgress;
		this.isFinished = isFinished;
	}

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

	public boolean isInProgress() {
		return isInProgress;
	}

	public void setInProgress(boolean isInProgress) {
		this.isInProgress = isInProgress;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
}
