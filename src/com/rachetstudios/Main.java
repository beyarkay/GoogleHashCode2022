package com.rachetstudios;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
	
	public static InputAsPojo input;
	public static OutputItems output;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Hello world");
		
		List<String> inputFiles = getAllInputFiles();
		Collections.sort(inputFiles);
		
		input = new InputAsPojo(inputFiles.get(1));
		System.out.println("input.first = " + input.first);
		
		System.out.println("input.people.get(0) = " + input.people.get(0));
		System.out.println("input.projects.get(0) = " + input.projects.get(0));
		
		output = new OutputItems("1/temp.txt");
		
		FirstApproach.run();
		
		output.writeToFile();
	}
	
	/**
	 * https://www.baeldung.com/java-list-directory-files
	 */
	public static List<String> getAllInputFiles() {
		final String dirname = "examples_in";
		return Stream.of(Objects.requireNonNull(new File(dirname).listFiles()))
				.filter(file -> !file.isDirectory())
				.map(File::getName)
				.map(str -> dirname + "/" + str)
				.collect(Collectors.toList());
	}
}
