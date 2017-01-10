package helloplayer;

import battlecode.common.*;

/**
 * Created by Dylan on 1/10/2017.
 */
public class Navigation extends Globals {

	public static boolean tryMoveInDirection(Direction direction) throws GameActionException {

		if(rc.canMove(direction)) {
			rc.move(direction);
			return true;
		}

		int currentCheck = 1;
		int checksPerSide = 3;
		float degreeOffset = 10;

		while (currentCheck <= checksPerSide) {

			if(rc.canMove(direction.rotateLeftDegrees(degreeOffset * currentCheck))) {
				rc.move(direction.rotateLeftDegrees(degreeOffset * currentCheck));
				return true;
			}

			if(rc.canMove(direction.rotateRightDegrees(degreeOffset * currentCheck))) {
				rc.move(direction.rotateRightDegrees(degreeOffset * currentCheck));
				return true;
			}

			currentCheck++;
		}

		return false;
	}

	static boolean tryMoveInRandomDirection() throws GameActionException {
		return tryMoveInDirection(getRandomDirection());
	}

	static Direction getRandomDirection() throws GameActionException {
		return new Direction((float) Math.random() * 2 * (float) Math.PI);
	}
}
