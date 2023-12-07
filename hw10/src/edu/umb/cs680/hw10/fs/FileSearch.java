package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.util.FileSearchVisitor;

public class FileSearch implements FSCommand {

    public FileSearchVisitor v;
    public FSElement elem;

    public FileSearch(String fileName, FSElement elem) {
        this.v = new FileSearchVisitor(fileName);
        this.elem = elem;
    }

    public void execute() {
        elem.accept(v);
    }

}
