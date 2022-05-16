package ModelLayer;

import java.util.ArrayList;

public class Team {
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private String teamName;
	private int wins;
	private int loses;
	private int teamID;
	
	public Team(String teamName, int wins, int loses, int teamID, ArrayList<Player> players) {
		//used for read methods
		this.loses = loses;
		this.wins = wins;
		this.teamName = teamName;
		this.teamID = teamID;
		this.players = players;
	}
		
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getLoses() {
		return loses;
	}
	public void setLoses(int loses) {
		this.loses = loses;
	}
	public int getTeamID() {
		return teamID;
	}
	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	
}
