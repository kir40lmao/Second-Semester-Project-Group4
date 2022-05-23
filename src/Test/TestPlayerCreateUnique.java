package Test;

import static org.junit.jupiter.api.Assertions.*;

import ControllerLayer.PlayerController;
import ModelLayer.Player;


class TestPlayerCreateUnique {
	int testNo=9000;
	PlayerController pc = new PlayerController();
	@org.junit.jupiter.api.Test
	void testPlayerCreateUnique() {
		String newPlayerName="TestGamer"+testNo;
		pc.createPlayer(newPlayerName);
		int counter=0;
		for(Player p:pc.getAllPlayers()) {
			if(newPlayerName.equals(p.getGamerTag())) {
				counter++;
			}
		}
		assertEquals(1,counter);
		System.out.println(newPlayerName+" created!");
	}
}