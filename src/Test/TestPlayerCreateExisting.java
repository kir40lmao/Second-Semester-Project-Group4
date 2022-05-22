package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ControllerLayer.PlayerController;
import ModelLayer.Player;

class TestPlayerCreateExisting {
	PlayerController pc = new PlayerController();
	@org.junit.jupiter.api.Test
	void testPlayerCreateExisting() {
		String newPlayerName="rHidden";
		int counter=0;
		for(Player p:pc.getAllPlayers()) {
			if(newPlayerName.equals(p.getGamerTag())) {
				counter++;
			}
		}
		if(counter==0) {
			pc.createPlayer(newPlayerName);
		}
		assertEquals(1,counter);
	}
}
