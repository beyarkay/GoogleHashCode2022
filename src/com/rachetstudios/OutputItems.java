package com.rachetstudios;

import jdk.internal.joptsimple.internal.Strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class OutputItems {
    String filepath;
    // TODO rename items1 to be semantically correct
    ArrayList<CompletedProject> completedProjects;

    public OutputItems(String filepath) {
        this.filepath = filepath;
    }

    public void writeToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.filepath));

        writer.write(completedProjects.size() + "\n");
        for (CompletedProject proj : completedProjects) {
            writer.write(proj.toString());
        }

        writer.close();
    }

    public static class CompletedProject {
        String projectName;
        ArrayList<InputAsPojo.Person> people;

        /**
         * Plain ol' constructor with each member variable
         */
        public CompletedProject(String projectName, ArrayList<InputAsPojo.Person> people) {
            this.projectName = projectName;
            this.people = people;
        }

        /**
         * Constructor to build a completed project from a given project and a
         * list of people working on that project
         */
        public CompletedProject(InputAsPojo.Project project, ArrayList<InputAsPojo.Person> people) {
            this.projectName = project.projectName;
            this.people = people;
        }

        @Override
        public String toString() {
            String peopleAsString = Strings.join(
                    people.stream()
                            .map(p -> p.name)
                            .collect(Collectors.toList()), " ");
            return projectName + "\n" + peopleAsString + "\n";
        }


    }


}
