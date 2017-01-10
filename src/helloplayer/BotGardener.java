package helloplayer;

import battlecode.common.*;

/**
 * Created by Dylan on 1/10/2017.
 */
public class BotGardener extends Globals {

	static void loop() throws GameActionException {

		while (true) {
			try {
				turn();
			} catch (Exception e) {
				System.out.println("Gardener Crit Fail");
				e.printStackTrace();
			}
			Clock.yield();
		}
	}

	private static void turn() throws GameActionException {

		if(rc.getTeamBullets() > 150)
			buildNearestOpenDirection(RobotType.LUMBERJACK);

		Navigation.tryMoveInRandomDirection();
	}

	private static boolean goodTreeSensed() throws GameActionException {

		return false;
	}

	private static boolean nextToTree() throws GameActionException {

		return false;
	}

	public static boolean buildNearestOpenDirection(RobotType type) throws GameActionException {
		Direction dir = Direction.getEast();

		float degreeOffset = 20;

		while (dir.getAngleDegrees() <= 360) {
			if(rc.canBuildRobot(type, dir)) {
				rc.buildRobot(type, dir);
				return true;
			}
			dir = dir.rotateLeftDegrees(degreeOffset);
		}

		return false;
	}


}
