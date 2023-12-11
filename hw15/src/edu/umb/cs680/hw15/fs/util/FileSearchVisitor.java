package edu.umb.cs680.hw15.fs.util;

import java.util.LinkedList;
import edu.umb.cs680.hw15.fs.FSVisitor;
import edu.umb.cs680.hw15.fs.Directory;
import edu.umb.cs680.hw15.fs.File;
import edu.umb.cs680.hw15.fs.Link;

public class FileSearchVisitor implements FSVisitor {

    private String fileName;
    private LinkedList<File> foundFiles;

    public FileSearchVisitor(String fileName) {
        this.fileName = fileName;
        this.foundFiles = new LinkedList<File>();
    }

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
        if(file.getName().equals(fileName)){
            foundFiles.add(file); 
        }
    }

    public LinkedList<File> getFoundFiles() {
        return foundFiles;
    }
}
