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
    // TODO rename rest to be more semantically appropriate (ie 'Cars' or something)
    ArrayList<LineItem> rest;
    // Sometimes there are actually two arrays of items described. In this case, last contains those items
    // TODO rename rest2 to be more semantically appropriate (ie 'People' or something)
    ArrayList<OtherLineItem> otherRest;


    /**
     * Convert a path to a Plain Ol' Java Object.
     *
     * It automatically detects how many tokens are on the first line, and adds them as Integers to
     * `this.first`.
     *
     * It also will go through the rest of the file and add each remaining line as a LineItem object
     * to the arraylist `this.rest`.
     *
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
            int numberOfLineItems = first.get(0);

            // And now go through the rest of the file, reading numberOfLineItems and saving them to some dummy variable
            while (numberOfLineItems-- > 0) {
                StringTokenizer stRest = new StringTokenizer(br.readLine());
                // TODO remove this assertion once we know how many tokens there are per line
                assert stRest.countTokens() == 4;

                // Create a lineItem object to represent whatever is on the current line
                LineItem lineItem = new LineItem(
                        // TODO Right now all these classes are arbitrary. Rename and refactor them once we know what they're called
                        Integer.parseInt(stRest.nextToken()),
                        (String) (stRest.nextToken()),
                        FloatingDecimal.parseFloat(stRest.nextToken()),
                        Double.parseDouble(stRest.nextToken())
                );
                rest.add(lineItem);
            }

            // TODO this is only important if there are more than one set of objects (ie Libraries and Books, or Intersections and People)
//            int numberOfSecondaryLineItems = -1; // first.get(2);
//            while (numberOfSecondaryLineItems-- > 0) {
//                StringTokenizer stRest = new StringTokenizer(br.readLine());
//                // TODO remove this assertion once we know how many tokens there are per line
//                assert stRest.countTokens() == 4;
//
//                // Create a lineItem object to represent whatever is on the current line
//                OtherLineItem otherLineItem = new OtherLineItem(
//                        // TODO Right now all these classes are arbitrary. Rename and refactor them once we know what they're called
//                        Integer.parseInt(stRest.nextToken()),
//                        (String) (stRest.nextToken()),
//                        FloatingDecimal.parseFloat(stRest.nextToken()),
//                        Double.parseDouble(stRest.nextToken())
//                );
//                otherRest.add(otherLineItem);
//            }

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

    /**
     * Also represents one line of input data.
     */
    public static class OtherLineItem {
        // TODO refactor and rename these and give them more specific classes
        Object thing1;
        Object thing2;
        Object thing3;
        Object thing4;

        public OtherLineItem(Object thing1, Object thing2, Object thing3, Object thing4) {
            this.thing1 = thing1;
            this.thing2 = thing2;
            this.thing3 = thing3;
            this.thing4 = thing4;
        }
    }
}
