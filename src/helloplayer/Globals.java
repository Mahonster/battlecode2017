package helloplayer;

import battlecode.common.*;

/**
 * Created by Dylan on 1/10/2017.
 */
public class Globals {

	public static int turnCreated;
	public static RobotController rc;
	public static RobotType type;
	public static int id;
	public static Team us;
	public static Team opponent;
	public static int sightRange;
	public static int range; // Weapon range

	public static void init(RobotController robotController) {
		rc = robotController;
		type = rc.getType();
		id = rc.getID();
		us = rc.getTeam();
		opponent = us.opponent();
		turnCreated = rc.getRoundNum();
	}
}
