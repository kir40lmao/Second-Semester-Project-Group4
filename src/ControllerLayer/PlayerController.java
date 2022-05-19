package ControllerLayer;

import java.util.ArrayList;
import java.util.List;

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
	public List<Player> findAvailablePlayers() { //missing
		return playerDAO.findAvailablePlayers();
	}
	public ArrayList<Player> getAllPlayers() { //missing
		return playerDAO.getAllPlayers();
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
