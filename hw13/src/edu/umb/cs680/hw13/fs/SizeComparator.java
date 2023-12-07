package edu.umb.cs680.hw13.fs;

import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement element1, FSElement element2) {
        return Integer.compare(element1.getSize(), element2.getSize());
    }
}
