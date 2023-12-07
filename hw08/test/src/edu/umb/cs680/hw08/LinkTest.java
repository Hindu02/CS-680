package edu.umb.cs680.hw08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkTest {

    private static FileSystem fs;

    private static Link rm;
    private static String[] linkToStringArray(Link d) {
        String[] linkInfo = { d.getName(), Integer.toString(d.getSize()), d.getParent().getName() };
        return linkInfo;
    }

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
        Directory src = fs.getRootDirs().getFirst().getSubDirectories().getLast().getSubDirectories().getFirst();
        rm = src.getLinks().getFirst();

    }

    @Test
    public void verifyLinkToStringArrayRM() {
        String[] expected = { "rm.md", "0", "src" };
        assertArrayEquals(expected, linkToStringArray(rm));
    }

    @Test
    public void verifyGetTarget() {
        assertSame(fs.getRootDirs().get(0).getFiles().getLast(), rm.getTarget());
    }

}
