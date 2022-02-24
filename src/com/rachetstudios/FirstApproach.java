package com.rachetstudios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import static com.rachetstudios.Helper.pointsPerPersonHour;

import static com.rachetstudios.Main.input;
import static com.rachetstudios.Main.output;

public class FirstApproach {
	
	public static void run() {
		System.out.println("running");
		ArrayList<InputAsPojo.Project> projectsList = input.projects;
		PriorityQueue<InputAsPojo.Project> runningProjects =
				new PriorityQueue<>(Comparator.comparingInt(o -> o.daysToCompletion));

//		list of idle people
//		list of projects
//		    Sort this by points/total man hours
//		    Alternatively sort by expiry date
		int currentTime = 0;
		while (projectsList.size() > 0) {
			boolean startedAProject; // Check if we were able to find a project
			do {
				startedAProject = false;
				for (InputAsPojo.Project project : projectsList) {
					project.pointsPerPersonHour = pointsPerPersonHour(project, currentTime);
				}
				projectsList.sort(comparePointsPerHour);
				
				for (int i = 0; i < projectsList.size(); i++) {
					InputAsPojo.Project project = projectsList.get(i);
					ArrayList<InputAsPojo.Person> peopleOnJob = Helper.canStart(project);
					if (peopleOnJob != null) {

//						 start the project
						project.peopleOnProject = peopleOnJob;  // People capable of doing the jobe
						project.endTime = currentTime + project.daysToCompletion;
						runningProjects.add(project);
						projectsList.remove(project);
						i--;
						startedAProject = true;
						output.completedProjects.add(new OutputItems.CompletedProject(project, project.peopleOnProject));
						input.people.removeAll(peopleOnJob);
						
						
					}
				}
				
			} while (startedAProject);
			
			
			// wait for a project to finish
			int endTime;
			do {
				InputAsPojo.Project next_completed_project = runningProjects.poll();
				endTime = next_completed_project.endTime;
				for (InputAsPojo.Person person : next_completed_project.peopleOnProject) {
					person.currentSkill.level += 1;
				}
				input.people.addAll(next_completed_project.peopleOnProject);
			} while (runningProjects.peek() != null && endTime == runningProjects.peek().endTime);
			
			currentTime = endTime;

//
		}
		
		
	}
	
	public static Comparator<InputAsPojo.Project> comparePointsPerHour = Comparator.comparingDouble(o -> -o.pointsPerPersonHour);
}
