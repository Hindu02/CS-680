package edu.umb.cs680.hw17.fs;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement element1, FSElement element2) {
        return element1.getName().compareTo(element2.getName());
    }
}
