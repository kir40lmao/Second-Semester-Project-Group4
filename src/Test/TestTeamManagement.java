package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ControllerLayer.TeamController;
import ModelLayer.Team;

class TestTeamManagement {
	TeamController tc = new TeamController();
	@Test
	void test() {
		Team teamToUpdate = tc.findTeamByName("TestTeam50");
		System.out.println(teamToUpdate.getTeamName());
		String newTeamName="TestTeam9000";
		tc.updateTeamName(teamToUpdate.getTeamID(), newTeamName);
		System.out.println(teamToUpdate.getTeamName());
		assertEquals(newTeamName,teamToUpdate.getTeamName());
	}

}
