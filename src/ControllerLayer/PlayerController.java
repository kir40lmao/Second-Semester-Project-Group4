package ControllerLayer;

import DatabaseLayer.PlayerDAO;
import ModelLayer.Player;

public class PlayerController {
	PlayerDAO playerDAO = new PlayerDAO();
	public PlayerController() {
		
	}
	public void createPlayer(String gamerTag) {
		playerDAO.createPlayer(gamerTag);
	}
	public Player findPlayerByName(String gamerTag) {
		Player player = playerDAO.findPlayerByName(gamerTag);
		return player;
	}
	public void findAvailablePlayers() { //missing
		playerDAO.findAvailablePlayers();
	}
	public void getAllPlayers() { //missing
		playerDAO.getAllPlayers();
	}
	public void updatePlayerDetails(int playerID, String gamerTag, int teamID) {
		playerDAO.updatePlayer(playerID, gamerTag, teamID);
	}
	public void updatePlayersAfterMatch(int playerID, int totalKills, int totalDeaths) {
		playerDAO.updatePlayerAfterMatch(playerID, totalKills, totalDeaths);
	}
	public void deletePlayer(int playerID) {
		playerDAO.deletePlayer(playerID);
	}
}
