package helloplayer;

import battlecode.common.*;

/**
 * Created by Dylan on 1/10/2017.
 */
public class BotSoldier extends Globals {

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

	static void turn() throws GameActionException {
		Navigation.tryMoveInRandomDirection();
	}
}
