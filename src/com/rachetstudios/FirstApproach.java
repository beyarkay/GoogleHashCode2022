package com.rachetstudios;

public class FirstApproach {
	
	public static void run(){
		System.out.println("running");
		
//		list of idle people
//		list of projects
//		    Sort this by points/total man hours
//		    Alternatively sort by expiry date
//		current time
		while(projectsList.size() >0) {
			boolean startedAProject = false // Check if we were able to find a project
			do {
				for (Project project : projects) {
					if tooLate(project, currentTime)
//					project.score = ... # number of points we'd get if we started it now
				}
//			    projects_list = projects.sort(by = points/total_man_hours)  # maybe this is too slow?
				
				/*
				for project in projects_list:
		            if can_start(project, idle_people):
		                # start the project
		                project.people = ... # any people capable of doing it
		                project.start_time = current_time
		                running_projects.append(project)
		                projects_list.remove(project)
		                started_a_project = True
		                write_to_output_file(project)
				 */
			}
			/*
			while started_a_project
		    # wait for a project to finish
		    next_completed_project = get_next_completed_project(running_projects)
		    running_projects.remove(next_completed_project)
		    current_time = next_completed_project.start_time + next_completed_project.start_time.duration
			 */
		}
		
		
	}
	
	
}
