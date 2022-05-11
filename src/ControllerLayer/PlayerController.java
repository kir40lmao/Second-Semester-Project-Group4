package ControllerLayer;

import DatabaseLayer.PlayerDAO;

public class PlayerController {
	PlayerDAO playerDAO = new PlayerDAO();
	public PlayerController() {
		
	}
	public void createPlayer(String gamerTag) {
		playerDAO.createPlayer(gamerTag);
	}
	public void findPlayerByName(String gamerTag) {
		playerDAO.findPlayerByName(gamerTag);
	}
	public void findAvailablePlayers() { //missing
		playerDAO.findAvailablePlayers();
	}
	public void getAllPlayers() { //missing
		playerDAO.getAllPlayers();
	}
	public void updatePlayerDetails(int playerID, String gamerTag, int teamID) {
		playerDAO.updatePlayerDetails(playerID, gamerTag, teamID);
	}
	public void updatePlayersAfterMatch(int playerID, int totalKills, int totalDeaths) { //outdated
		playerDAO.updatePlayerDetails(playerID, totalKills, totalDeaths);
	}
	public void deletePlayer(int playerID) {
		playerDAO.deletePlayer(playerID);
	}
}
