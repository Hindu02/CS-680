package edu.umb.cs680.hw17.fs.util;

import java.util.LinkedList;
import edu.umb.cs680.hw17.fs.FSVisitor;
import edu.umb.cs680.hw17.fs.Directory;
import edu.umb.cs680.hw17.fs.File;
import edu.umb.cs680.hw17.fs.Link;

public class FileCrawlingVisitor implements FSVisitor {

    private LinkedList<File> files = new LinkedList<>();

    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(Directory directory) {
        return;
    }

    @Override
    public void visit(File file) {
        files.add(file);
    }

    public LinkedList<File> getFiles() {
        return files;
    }
}
