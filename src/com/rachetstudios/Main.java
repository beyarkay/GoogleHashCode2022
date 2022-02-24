package com.rachetstudios;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static HashMap<String, Integer> hashMapBecauseIForgetHowToCreateThem;


    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello world");
//        System.out.println(convertAllInputFilesToPojos());

        List<String> inputFiles = getAllInputFiles();

        InputAsPojo input = new InputAsPojo(inputFiles.get(0));

        hashMapBecauseIForgetHowToCreateThem.put("key", 1);
        hashMapBecauseIForgetHowToCreateThem.get("key");
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

    public static List<Object> convertAllInputFilesToPojos() {
        return getAllInputFiles().stream()
                .map(Main::convertFilePathToPojo)
                .collect(Collectors.toList());
    }

    /**
     * https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
     */
    public static Object convertFilePathToPojo(String path) {
        // If we don't specify a path, just use the first one
        if (path == null) {
            path = getAllInputFiles().get(0);
        }
        ArrayList<Object> replaceMeWithARealArray = new ArrayList<>();

        try {
            System.out.println("Parsing file: " + path + "...");
            BufferedReader br = new BufferedReader(new FileReader(path));

            // Read the first line with all the special input tokens
            StringTokenizer st = new StringTokenizer(br.readLine());
            int numberOfInputLines = Integer.parseInt(st.nextToken());
            int someOtherNumber2 = Integer.parseInt(st.nextToken());
            int someOtherNumber3 = Integer.parseInt(st.nextToken());
            int someOtherNumber4 = Integer.parseInt(st.nextToken());

            // And now go through the rest of the file, reading numberOfInputLines and saving them to some dummy variable
            while (numberOfInputLines-- > 0) {
                StringTokenizer stInner = new StringTokenizer(br.readLine());
                int innerNumber1 = Integer.parseInt(stInner.nextToken());
                int innerNumber2 = Integer.parseInt(stInner.nextToken());
                int[] arrOfItems = new int[]{
                        innerNumber1,
                        innerNumber2,
                };

                replaceMeWithARealArray.add(arrOfItems);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return replaceMeWithARealArray;
    }

}
