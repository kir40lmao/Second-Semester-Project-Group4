package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ControllerLayer.TournamentController;
import ModelLayer.Tournament;

class TestCreateGoodTournament {
	TournamentController tc = new TournamentController();
	@Test
	void test() {
		String testName= "FinalTestTourney";
		String testDate="2022-05-24";
		tc.createTournament(testName, testDate);
		assertEquals(testDate, tc.findTournamentByName(testName).getDate());
	}

}
