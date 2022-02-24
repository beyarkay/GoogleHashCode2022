package com.rachetstudios;

public class ClassThatsComparable implements Comparable<ClassThatsComparable> {
    int dimensionAlongWhichToCompare = 0;

    /**
     * If this == other:  0 is returned
     * If this < other:  -1 is returned
     * If this > other:   1 is returned
     */
    @Override
    public int compareTo(ClassThatsComparable other) {
        return this.dimensionAlongWhichToCompare - other.dimensionAlongWhichToCompare;
    }
}
