package edu.umb.cs680.hw17.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class DirectoryTest {

    private static FileSystem fs;
    private static Directory src, test, testSrc, repo;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
        repo = fs.getRootDirs().getLast();
        src = repo.getSubDirectories().getFirst();
        test = repo.getSubDirectories().getLast();
        testSrc = test.getSubDirectories().getFirst();
    }

    private String[] dirToStringArray(Directory d) {

        if (d.getParent() != null) {
            String[] dirInfo = { d.getName(), Integer.toString(d.getSize()), d.getParent().getName() };
            return dirInfo;
        } else {
            String[] dirInfo = { d.getName(), Integer.toString(d.getSize()), "null" };
            return dirInfo;
        }
    }

    

    @Test
    public void verifyDirToStringArrayRepo() {
        String[] expected = { "repo", "0", "null" };
        assertArrayEquals(expected, dirToStringArray(repo));
    }

    @Test
    public void verifyDirToStringArrayTest() {
        String[] expected = { "test", "0", "repo" };
        assertArrayEquals(expected, dirToStringArray(test));
    }

    @Test
    public void verifyDirToStringArraySrc() {
        String[] expected = { "src", "0", "repo" };
        assertArrayEquals(expected, dirToStringArray(src));
    }

    @Test
    public void verifyDirToStringArrayTestSrc() {
        String[] expected = { "src", "0", "test" };
        assertArrayEquals(expected, dirToStringArray(testSrc));
    }

    @Test
    public void verifyCountChildren() {
        assertEquals(3, repo.countChildren());
    }

    @Test
    public void verifyGetSubDirectories() {
        LinkedList<Directory> expected = new LinkedList<>();
        expected.add(src);
        expected.add(test);

        assertIterableEquals(expected, repo.getSubDirectories());
    }

    @Test
    public void verifyGetFiles() {
        LinkedList<Directory> expected = new LinkedList<>();
        assertIterableEquals(expected, test.getFiles());
    }

    @Test
    public void verifyGetLinks() {
        LinkedList<Link> expected = new LinkedList<>();
        assertIterableEquals(expected, repo.getLinks());
    }
    
    @Test
    public void verifyGetTotalSize() {
        assertEquals(500, repo.getTotalSize());
    }

    @Test
    public void verifyIsDirectory() {
        assertTrue(test.isDirectory());
    }



}
