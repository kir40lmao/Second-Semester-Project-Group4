package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ControllerLayer.TeamController;
import ModelLayer.Player;
import ModelLayer.Team;

class TestTeamCreateUnique {
	int testNo=1500;
	TeamController tc = new TeamController();
	@Test
	void test() {
		String newTeamName="TestTeam"+testNo;
		tc.createTeam(newTeamName);
		int counter=0;
		for(Team t:tc.getAllTeams()) {
			if(newTeamName.equals(t.getTeamName())) {
				counter++;
			}
		}
		assertEquals(1,counter);
	}

}
