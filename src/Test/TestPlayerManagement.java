package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ControllerLayer.PlayerController;
import ModelLayer.Player;

class TestPlayerManagement {
	PlayerController pc = new PlayerController();
	@Test
	void test() {
		Player playerToUpdate=pc.findPlayerByName("TestGamer42");
		int newTeamID=1002;
		pc.updatePlayerDetails(playerToUpdate.getPlayerID(), playerToUpdate.getGamerTag(), newTeamID);
		assertEquals(newTeamID,playerToUpdate.getTeamID());
	}

}
