package com.rachetstudios;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello world");
    }


    /**
     * https://www.baeldung.com/java-list-directory-files
     */
    public static List<String> getAllInputFiles() {
        return Stream.of(Objects.requireNonNull(new File("examples_in").listFiles()))
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toList());
    }
}
