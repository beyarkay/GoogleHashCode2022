package com.rachetstudios;

import java.util.ArrayList;
import java.util.Comparator;

import static com.rachetstudios.Helper.pointsPerPersonHour;

import static com.rachetstudios.Main.input;

public class FirstApproach {
	
	public static void run() {
		System.out.println("running");
		ArrayList<InputAsPojo.Project> projectsList = input.projects;
//		list of idle people
//		list of projects
//		    Sort this by points/total man hours
//		    Alternatively sort by expiry date
		int currentTime = 0;
		while (projectsList.size() > 0) {
			boolean startedAProject = false; // Check if we were able to find a project
			do {
				for (InputAsPojo.Project project : projectsList) {
					project.pointsPerPersonHour = pointsPerPersonHour(project, currentTime);
				}
				projectsList.sort(comparePointsPerHour);
				
				for (InputAsPojo.Project project : projectsList) {
					ArrayList<InputAsPojo.Person> peopleOnJob = Helper.canStart(project);
					if (peopleOnJob != null) {
						/*
						# start the project
		                project.people = ... # any people capable of doing it
		                project.start_time = current_time
		                running_projects.append(project)
		                projects_list.remove(project)
		                started_a_project = True
		                write_to_output_file(project)
						 */
					}
				}
				
			} while (startedAProject);
			/*
			
		    # wait for a project to finish
		    next_completed_project = get_next_completed_project(running_projects)
		    running_projects.remove(next_completed_project)
		    current_time = next_completed_project.start_time + next_completed_project.start_time.duration
			 */
		}
		
		
	}
	
	public static Comparator<InputAsPojo.Project> comparePointsPerHour = Comparator.comparingDouble(o -> -o.pointsPerPersonHour);
}
