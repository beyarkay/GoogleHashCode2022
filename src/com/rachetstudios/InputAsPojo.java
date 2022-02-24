package com.rachetstudios;

import jdk.internal.math.FloatingDecimal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class InputAsPojo {
    // Represents the very first line, which usually just has ints
    ArrayList<Integer> first;
    // Represents the remainder of the lines which usually represent a bunch of custom objects. @see LineItem
    ArrayList<LineItem> rest;

    /**
     * https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
     */
    public InputAsPojo(String path) {

        try {
            System.out.println("Parsing file: " + path + "...");
            BufferedReader br = new BufferedReader(new FileReader(path));

            // Read the first line with all the special input tokens
            StringTokenizer stFirst = new StringTokenizer(br.readLine());
            while (stFirst.hasMoreTokens()) {
                first.add(Integer.parseInt(stFirst.nextToken()));
            }

            // TODO we're assuming here that the very first token on the first line contains the total number of line items
            int numberOfInputLines = first.get(0);
            // And now go through the rest of the file, reading numberOfInputLines and saving them to some dummy variable
            while (numberOfInputLines-- > 0) {
                StringTokenizer stRest = new StringTokenizer(br.readLine());
                // TODO remove this assertion once we know how many tokens there are per line
                assert stRest.countTokens() == 4;

                // Create a lineItem object to represent whatever is on the current line
                LineItem lineItem = new LineItem(
                        // TODO Right now all these classes are abitrary. Rename and refactor them once we know what they're called
                        Integer.parseInt(stRest.nextToken()),
                        (String) (stRest.nextToken()),
                        FloatingDecimal.parseFloat(stRest.nextToken()),
                        Double.parseDouble(stRest.nextToken())
                );
                rest.add(lineItem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Represents one line of input data.
     */
    public static class LineItem {
        // TODO refactor and rename these and give them more specific classes
        Object thing1;
        Object thing2;
        Object thing3;
        Object thing4;

        public LineItem(Object thing1, Object thing2, Object thing3, Object thing4) {
            this.thing1 = thing1;
            this.thing2 = thing2;
            this.thing3 = thing3;
            this.thing4 = thing4;
        }
    }
}
