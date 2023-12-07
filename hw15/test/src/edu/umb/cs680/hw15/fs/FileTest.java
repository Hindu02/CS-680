package edu.umb.cs680.hw15.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileTest {

    private static FileSystem fs;

    private static File readmeFile, A, B, ATest, BTest;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
        readmeFile = fs.getRootDirs().getLast().getFiles().getFirst();

        A = fs.getRootDirs().getLast().getSubDirectories().getFirst().getFiles().getFirst();
        B = fs.getRootDirs().getLast().getSubDirectories().getFirst().getFiles().getLast();

        Directory src = fs.getRootDirs().getFirst().getSubDirectories().getLast().getSubDirectories().getFirst();

        ATest = src.getFiles().getFirst();
        BTest = src.getFiles().getLast();

    }

    private static String[] fileToStringArray(File d) {
        String[] fileInfo = { d.getName(), Integer.toString(d.getSize()), d.getParent().getName() };
        return fileInfo;
    }

    @Test
    public void verifyFileToStringArrayReadme() {
        String[] expected = { "readme.md", "100", "repo" };
        assertArrayEquals(expected, fileToStringArray(readmeFile));
    }

    @Test
    public void verifyFileToStringArrayA() {
        String[] expected = { "A.java", "100", "src" };
        assertArrayEquals(expected, fileToStringArray(A));
    }

    @Test
    public void verifyFileToStringArrayB() {
        String[] expected = { "B.java", "100", "src" };
        assertArrayEquals(expected, fileToStringArray(B));
    }

    @Test
    public void verifyFileToStringArrayATest() {
        String[] expected = { "ATest.java", "100", "src" };
        assertArrayEquals(expected, fileToStringArray(ATest));
    }

    @Test
    public void verifyFileToStringArrayBTest() {
        String[] expected = { "BTest.java", "100", "src" };
        assertArrayEquals(expected, fileToStringArray(BTest));
    }

    @Test
    public void verifyIsDirectory() {
        assertFalse(readmeFile.isDirectory());
    }

}
