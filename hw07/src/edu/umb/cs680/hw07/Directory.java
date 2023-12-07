package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;


class Directory extends FSElement {
    private LinkedList<FSElement> children;

    public Directory(Directory parent, String name, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
        children = new LinkedList<>();
    }

    public void appendChild(FSElement child) {
        children.add(child);
    }

    public int countChildren() {
        return children.size();
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> dirs = new LinkedList<>();
        for (FSElement elem : children) {
            if (elem.isDirectory()) {
                dirs.add((Directory) elem);
            }
        }
        return dirs;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement elem : children) {
            if (!elem.isDirectory()) {
                files.add((File) elem);
            }
        }
        return files;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement elem : children) {
            totalSize += elem.getSize();
            if (elem.isDirectory()) {
                Directory dir = (Directory) elem;
                totalSize += dir.getTotalSize();
            }
        }
        return totalSize;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }
}
