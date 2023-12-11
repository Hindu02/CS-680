package edu.umb.cs680.hw15.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw15.fs.util.CountingVisitor;
import edu.umb.cs680.hw15.fs.util.FileCrawlingVisitor;
import edu.umb.cs680.hw15.fs.util.FileSearchVisitor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

public class VisitorTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void verifyCountingVisitor() {
        CountingVisitor v = new CountingVisitor();
        Directory repo = fs.getRootDirs().getFirst();
        repo.accept(v);
        assert (v.getDirNum() == 4 && v.getFileNum() == 5 && v.getLinkNum() == 1);
    }

    @Test
    public void verifyFileCrawlingVisitor() {
        FileCrawlingVisitor v = new FileCrawlingVisitor();
        Directory repo = fs.getRootDirs().getFirst();
        File readme = repo.getFiles().getFirst();
        readme.accept(v);

        LinkedList<File> expected = new LinkedList<>();
        expected.add(readme);

        assertIterableEquals(expected, v.getFiles());
    }

    @Test
    public void verifyFileSearchVisitor() {
        FileSearchVisitor v = new FileSearchVisitor("readme.md");
        Directory repo = fs.getRootDirs().getFirst();
        File readme = repo.getFiles().getFirst();
        repo.accept(v);

        LinkedList<File> expected = new LinkedList<>();
        expected.add(readme);

        assertIterableEquals(expected, v.getFoundFiles());
    }

}
