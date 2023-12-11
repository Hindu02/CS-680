package edu.umb.cs680.hw10.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class CommandTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void verifyCounting() {
        Directory repo = fs.getRootDirs().getFirst();
        Counting cmd = new Counting(repo);
        cmd.execute();

        assert (cmd.getVisitor().getDirNum() == 4 && cmd.getVisitor().getLinkNum() == 1);
    }

    @Test
    public void verifyFileSearch() {
        Directory repo = fs.getRootDirs().getFirst();
        FileSearch cmd = new FileSearch("readme.md", repo);
        cmd.execute();

        File readme = repo.getFiles().getFirst();

        LinkedList<File> expected = new LinkedList<>();
        expected.add(readme);

        assertIterableEquals(expected, cmd.getVisitor().getFoundFiles());
    }

    @Test
    public void verifyFileCrawling() {
        Directory repo = fs.getRootDirs().getFirst();
        File readme = repo.getFiles().getFirst();

        FileCrawling cmd = new FileCrawling(readme);
        cmd.execute();

        LinkedList<File> expected = new LinkedList<>();
        expected.add(readme);

        assertIterableEquals(expected, cmd.getVisitor().getFiles());
    }

}
