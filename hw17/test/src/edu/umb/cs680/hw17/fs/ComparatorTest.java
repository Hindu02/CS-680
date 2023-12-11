package edu.umb.cs680.hw17.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        LinkedList<Directory> dirs = repo.getSubDirectories((element1, element2) -> element1.getName().compareTo(element2.getName()));

        List<Directory> expected = Arrays.asList(repo.getSubDirectories().get(0), repo.getSubDirectories().get(1) );
        assertIterableEquals(expected, dirs);
    }

    @Test
    public void verifyReverseAlphabeticalComparator() {
        Directory repo = fs.getRootDirs().getFirst();
        LinkedList<File> dirs = repo.getFiles((element1, element2) -> element2.getName().compareTo(element1.getName()));

        List<File> expected = Arrays.asList(repo.getFiles().get(0));
        assertIterableEquals(expected, dirs);
    }

    @Test
    public void verifySizeComparator() {
        Directory repo = fs.getRootDirs().getFirst();
        LinkedList<FSElement> dirs = repo.getChildren((element1, element2) -> Integer.compare(element1.getSize(), element2.getSize()));

        List<FSElement> expected = Arrays.asList(repo.getSubDirectories().get(0), repo.getSubDirectories().get(1), repo.getFiles().get(0) );
        assertIterableEquals(expected, dirs);

    }
    
}
