package edu.umb.cs680.hw08;
import java.util.LinkedList;

class FileSystem {
    private static FileSystem instance = null;
    private LinkedList<Directory> rootDirs;

    private FileSystem() {
        rootDirs = new LinkedList<>();
    }

    public static FileSystem getFileSystem() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    public void appendRootDir(Directory root) {
        rootDirs.add(root);
    }

    public LinkedList<Directory> getRootDirs() {
        return rootDirs;
    }

}
