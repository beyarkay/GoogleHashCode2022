package com.rachetstudios;

/**
 * Helper methods to be shared amongst the approaches
 */
public class Helper {
	
	/**
	 * Checks whether we can't complete the project before expiry
	 *
	 * @param project
	 * @param currentTime
	 * @return Whether the project is possible to complete before its expiry
	 */
	public static boolean tooLate(InputAsPojo.Project project, int currentTime) {
		return pointsPossibleToEarn(project, currentTime) == project.scoreOnCompletion;
	}
	
	/**
	 * Get the maximum potential score available. If the project can be completed before the best before then return the
	 * score, otherwise return the score adjusted for the penalty to a minimum of 0.
	 *
	 * @param project
	 * @param currentTime
	 * @return the number of points available
	 */
	public static int pointsPossibleToEarn(InputAsPojo.Project project, int currentTime) {
		int remainingDays = project.bestBeforeDay - currentTime;
		if (remainingDays <= 0) {
			int possibleScore = project.scoreOnCompletion - currentTime;
			if (possibleScore <= 0) {
				return 0;
			} else {
				return possibleScore;
			}
		} else {
			return project.scoreOnCompletion;
		}
	}

	public static double pointsPerPersonHour(InputAsPojo.Project project, int currentTime) {
		int points = pointsPossibleToEarn(project, currentTime);
		return ((double) points) / (project.numRoles + project.daysToCompletion);
	}
}
