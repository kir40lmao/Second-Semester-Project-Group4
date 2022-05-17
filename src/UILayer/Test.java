package UILayer;

import ControllerLayer.TournamentController;
import DatabaseLayer.TournamentDAO;
import ModelLayer.Tournament;

public class Test {

	public static void main(String[] args) {
		TournamentController tc = new TournamentController();
		tc.createTournament("Test Tournament 1", "2022-05-02");

		//tc.createTournament("Test Tournament 5", "2022-01-03");

	}

}
