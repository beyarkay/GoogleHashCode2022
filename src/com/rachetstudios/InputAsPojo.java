package com.rachetstudios;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputAsPojo {
    // Represents the very first line, which usually just has ints
    ArrayList<Integer> first = new ArrayList<>();
    // Represents the remainder of the lines which usually represent a bunch of custom objects. @see LineItem
    // TODO rename rest to be more semantically appropriate (ie 'Cars' or something)
    ArrayList<Person> people = new ArrayList<>();
    // Sometimes there are actually two arrays of items described. In this case, last contains those items
    // TODO rename rest2 to be more semantically appropriate (ie 'People' or something)
    ArrayList<Project> projects = new ArrayList<>();


    /**
     * Convert a path to a Plain Ol' Java Object.
     * <p>
     * It automatically detects how many tokens are on the first line, and adds them as Integers to
     * `this.first`.
     * <p>
     * It also will go through the rest of the file and add each remaining line as a LineItem object
     * to the arraylist `this.rest`.
     * <p>
     * https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
     */
    public InputAsPojo(String path) {
        try {
            System.out.println("Parsing file: " + path + "...");
            BufferedReader br = new BufferedReader(new FileReader(path));

            // Read the first line with all the special input tokens
            String[] firstTokens = br.readLine().split(" ");

            for (String token : firstTokens) {
                first.add(Integer.parseInt(token));
            }


            // TODO we're assuming here that the very first token on the first line contains the total number of line items
            int numPeople = first.get(0);

            // And now go through the rest of the file, reading numPeople and saving them to some dummy variable
            while (numPeople-- > 0) {
                String[] peopleTokens = br.readLine().split(" ");
                String name = peopleTokens[0];
                Integer numSkills = Integer.valueOf(peopleTokens[1]);

                ArrayList<Skill> skills = new ArrayList<>();

                int numSkillLines = numSkills;

                while (numSkillLines-- > 0) {
                    String[] skillTokens = br.readLine().split(" ");
                    String skillName = skillTokens[0];
                    Integer skillLevel = Integer.valueOf(skillTokens[1]);
                    skills.add(new Skill(skillName, skillLevel));
                }
                Person person = new Person(
                        name,
                        numSkills,
                        skills
                );
                this.people.add(person);
            }

            int numProjects = first.get(1);

            // And now go through the rest of the file, reading numProjects and saving them to some dummy variable
            while (numProjects-- > 0) {
                String[] projTokens = br.readLine().split(" ");
                String projectName = (projTokens[0]);
                Integer daysToCompletion_D = Integer.valueOf(projTokens[1]);
                Integer scoreOnCompletion_S = Integer.valueOf(projTokens[2]);
                Integer bestBeforeDay_B = Integer.valueOf(projTokens[3]);
                Integer numRoles_R = Integer.valueOf(projTokens[4]);

                ArrayList<Skill> skills = new ArrayList<>();
                int numRoleLines = numRoles_R;

                // roles are equivalent to skills
                while (numRoleLines-- > 0) {
                    String[] skillTokens = br.readLine().split(" ");
                    String skillName = skillTokens[0];
                    Integer skillLevel = Integer.valueOf(skillTokens[1]);
                    skills.add(new Skill(skillName, skillLevel));
                }

                Project project = new Project(
                        projectName,
                        daysToCompletion_D,
                        scoreOnCompletion_S,
                        bestBeforeDay_B,
                        numRoles_R,
                        skills
                );
                projects.add(project);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Represents one line of input data.
     */
    public static class Person {
        // TODO refactor and rename these and give them more specific classes
        String name;
        Integer numSkills;
        ArrayList<Skill> skills;

        public Person(String name, Integer numSkills, ArrayList<Skill> skills) {
            this.name = name;
            this.numSkills = numSkills;
            this.skills = skills;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", numSkills=" + numSkills +
                    ", skills=" + skills +
                    '}';
        }
    }

    public static class Skill {
        String name;
        Integer level;

        public Skill(String name, Integer level) {
            this.name = name;
            this.level = level;
        }

        @Override
        public String toString() {
            return "Skill{" +
                    "name='" + name + '\'' +
                    ", level=" + level +
                    '}';
        }
    }

    /**
     * Also represents one line of input data.
     */
    public static class Project {
        String projectName, name;
        Integer daysToCompletion, D;
        Integer scoreOnCompletion, S;
        Integer bestBeforeDay, B;
        Integer numRoles, R;
        ArrayList<Skill> skills;


        public Project(String projectName, Integer daysToCompletion, Integer scoreOnCompletion, Integer bestBeforeDay, Integer numRoles, ArrayList<Skill> skills) {
            this.projectName = projectName;
            this.daysToCompletion = daysToCompletion;
            this.scoreOnCompletion = scoreOnCompletion;
            this.bestBeforeDay = bestBeforeDay;
            this.numRoles = numRoles;
            this.skills = skills;

            this.name = this.projectName;
            this.D = this.daysToCompletion;
            this.S = this.scoreOnCompletion;
            this.B = this.bestBeforeDay;
            this.R = this.numRoles;
        }

        @Override
        public String toString() {
            return "Project{" +
                    "projectName='" + projectName + '\'' +
                    ", daysToCompletion=" + daysToCompletion +
                    ", scoreOnCompletion=" + scoreOnCompletion +
                    ", bestBeforeDay=" + bestBeforeDay +
                    ", numRoles=" + numRoles +
                    ", skills=" + skills +
                    '}';
        }
    }
}
