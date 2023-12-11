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

        List<Directory> expected = Arrays.asList(repo.getSubDirectories().get(0), repo.getSubDirectories().get(1));
        assertIterableEquals(expected, dirs);
    }

    @Test
    public void verifyReverseAlphabeticalComparator() {
        Directory repo = fs.getRootDirs().getFirst();
        LinkedList<File> dirs = repo.getFiles(new ReverseAlphabeticalComparator());

        List<File> expected = Arrays.asList(repo.getFiles().get(0));
        assertIterableEquals(expected, dirs);
    }

    @Test
    public void verifySizeComparator() {
        Directory repo = fs.getRootDirs().getFirst();
        LinkedList<FSElement> dirs = repo.getChildren(new SizeComparator());

        List<FSElement> expected = Arrays.asList(repo.getSubDirectories().get(0), repo.getSubDirectories().get(1),
                repo.getFiles().get(0));
        assertIterableEquals(expected, dirs);

    }

}
