package helloplayer;

import battlecode.common.*;

/**
 * Created by Dylan on 1/10/2017.
 */
public class BotArchon extends Globals {

	static void loop() throws GameActionException {
		while (true) {
			try {
				turn();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Clock.yield();
		}
	}

	private static void turn() throws GameActionException {

		Direction dir = new Direction((float) Math.PI / 2);

		// Randomly attempt to build a gardener in this direction
		if (rc.canHireGardener(dir) && Math.random() < .01) {
			rc.hireGardener(dir);
		}

		Navigation.tryMoveInRandomDirection();
	}

}
