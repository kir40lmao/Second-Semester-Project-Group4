package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ControllerLayer.TeamController;
import ModelLayer.Team;

class TestTeamCreateExisting {
	TeamController tc = new TeamController();
	@Test
	void test() {
		String newTeamName="WorstTeam";
		
		int counter=0;
		for(Team t:tc.getAllTeams()) {
			if(newTeamName.equals(t.getTeamName())) {
				counter++;
			}
		}
		if(counter==0) {
			tc.createTeam(newTeamName);
		}
		assertEquals(1,counter);
	}

}
