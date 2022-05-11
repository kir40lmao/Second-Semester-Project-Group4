package DatabaseLayer;

import java.util.ArrayList;

import ModelLayer.Player;

public interface PlayerDAOIF {
	void createPlayer(String gamerTag);
	Player findPlayerByName(String gamerTag);
	ArrayList<Player> findAvailablePlayers();
	ArrayList<Player> getAllPlayers();
	Player updatePlayer(int playerID, String gamerTag, int teamID);
	Player updatePlayerAfterMatch(int playerID, int totalKills, int totalDeaths);
	boolean deletePlayer(int playerID);
}

