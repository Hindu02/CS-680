package edu.umb.cs680.hw13.fs;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement element1, FSElement element2) {
        // Use compareTo method to compare names and reverse the result
        return element2.getName().compareTo(element1.getName());
    }
}
