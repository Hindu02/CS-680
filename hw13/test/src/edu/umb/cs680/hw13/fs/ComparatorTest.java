package edu.umb.cs680.hw13.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw13.fs.AlphabeticalComparator;
import edu.umb.cs680.hw13.fs.ReverseAlphabeticalComparator;
import edu.umb.cs680.hw13.fs.SizeComparator;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;

public class ComparatorTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void verifyAlphabeticalComparator() {
        Directory repo = fs.getRootDirs().getFirst();
        LinkedList<Directory> dirs = repo.getSubDirectories(new AlphabeticalComparator());

        List<Directory> expected = Arrays.asList(repo.getSubDirectories().get(0), repo.getSubDirectories().get(1) );
        assertIterableEquals(expected, dirs);
    }

    @Test
    public void verifyReverseAlphabeticalComparator() {
        Directory repo = fs.getRootDirs().getFirst();
        LinkedList<Directory> dirs = repo.getSubDirectories(new ReverseAlphabeticalComparator());

        List<Directory> expected = Arrays.asList(repo.getSubDirectories().get(1), repo.getSubDirectories().get(0) );
        assertIterableEquals(expected, dirs);
    }

    @Test
    public void verifySizeComparator() {
        Directory repo = fs.getRootDirs().getFirst();
        LinkedList<Directory> dirs = repo.getSubDirectories(new SizeComparator());

        List<Directory> expected = Arrays.asList(repo.getSubDirectories().get(0), repo.getSubDirectories().get(1) );
        assertIterableEquals(expected, dirs);

    }
    
}
