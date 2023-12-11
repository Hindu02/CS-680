package edu.umb.cs680.hw15.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Directory extends FSElement {
    private LinkedList<FSElement> children;

    public Directory(Directory parent, String name, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
        children = new LinkedList<>();
    }

    public void appendChild(FSElement child) {
        children.add(child);
        Collections.sort(children, (elem1, elem2) -> elem1.getName().compareTo(elem2.getName()));
    }

    public int countChildren() {
        return children.size();
    }

    public LinkedList<FSElement> getChildren() {
        return children;
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
            if (!elem.isDirectory() && elem instanceof File) {
                files.add((File) elem);
            }
        }
        return files;
    }

    public LinkedList<Link> getLinks() {
        LinkedList<Link> links = new LinkedList<>();
        for (FSElement elem : children) {
            if (!elem.isDirectory() && elem instanceof Link) {
                links.add((Link) elem);
            }
        }
        return links;
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

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
        for (FSElement e : children) {
            e.accept(v);
        }
    }

    public LinkedList<FSElement> getChildren(Comparator<FSElement> comparator) {
        LinkedList<FSElement> sortedChildren = new LinkedList<>(children);
        Collections.sort(sortedChildren, comparator);

        return sortedChildren;
    }

    
    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comparator) {
        LinkedList<Directory> dirs = new LinkedList<>();
        for (FSElement elem : children) {
            if (elem.isDirectory()) {
                dirs.add((Directory) elem);
            }
        }

        LinkedList<Directory> sortedChildren = new LinkedList<>(dirs);
        Collections.sort(sortedChildren, comparator);

        return sortedChildren;
    }

    public LinkedList<File> getFiles(Comparator<FSElement> comparator) {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement elem : children) {
            if (!elem.isDirectory() && elem instanceof File) {
                files.add((File) elem);
            }
        }

        LinkedList<File> sortedChildren = new LinkedList<>(files);
        Collections.sort(sortedChildren, comparator);
        return sortedChildren;
    }

    public LinkedList<Link> getLinks(Comparator<FSElement> comparator) {
        LinkedList<Link> links = new LinkedList<>();
        for (FSElement elem : children) {
            if (!elem.isDirectory() && elem instanceof Link) {
                links.add((Link) elem);
            }
        }
        LinkedList<Link> sortedChildren = new LinkedList<>(links);
        Collections.sort(sortedChildren, comparator);
        return sortedChildren;
    }

}
