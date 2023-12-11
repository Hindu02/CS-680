package edu.umb.cs680.hw17.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class FileSystemTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void verifySingletonFileSystemNotNull() {
        FileSystem firstInstance = FileSystem.getFileSystem();
        assertNotNull(firstInstance);
    }

    @Test
    public void verifySingletonFileSystem() {
        FileSystem firstInstance = FileSystem.getFileSystem();
        FileSystem secondInstance = FileSystem.getFileSystem();
        assertSame(firstInstance, secondInstance);
    }

    @Test
    public void verifyGetRootDirs() {
        LinkedList<Directory> rootDirs = fs.getRootDirs();
        assertNotNull(rootDirs);
    }

    @Test
    public void verifyAppendRootDir() {
        Directory newRootDir = new Directory(null, "newRoot", LocalDateTime.now());
        // Append the new directory to the root directories
        fs.appendRootDir(newRootDir);
        // Retrieve the root directories
        LinkedList<Directory> rootDirs = fs.getRootDirs();
        // Check that the new directory is the last in the list
        assertSame(newRootDir, rootDirs.getLast(), "The appended directory should be the last in the list.");
        // Cleanup after the test to maintain isolation
        rootDirs.removeLast();
    }


}