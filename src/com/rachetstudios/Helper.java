package com.rachetstudios;

import java.util.ArrayList;

import static com.rachetstudios.Main.input;

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
		int remainingDays = project.bestBeforeDay - (currentTime + project.daysToCompletion);
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
	
	/**
	 * Determines whether the project CAN be started given the current available people
	 *
	 * @param project
	 * @return
	 */
	public static boolean canStart(InputAsPojo.Project project) {
		ArrayList<InputAsPojo.Person> peopleOnJob = new ArrayList<InputAsPojo.Person>(project.numRoles);
		ArrayList<InputAsPojo.Skill> skillsRequired = new ArrayList<InputAsPojo.Skill>(project.skills);
		
		skillsRequired.remove(-1);
		
		for (InputAsPojo.Person person : input.people) {
		
		}
		return false;
	}
}
