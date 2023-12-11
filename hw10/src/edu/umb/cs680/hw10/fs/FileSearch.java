package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.util.CountingVisitor;
import edu.umb.cs680.hw10.fs.util.FileSearchVisitor;

public class FileSearch implements FSCommand {

    private FileSearchVisitor v;
    private FSElement elem;

    public FileSearch(String fileName, FSElement elem) {
        this.v = new FileSearchVisitor(fileName);
        this.elem = elem;
    }

    public void execute() {
        elem.accept(v);
    }

    public FileSearchVisitor getVisitor() {
        return v;
    }

    public FSElement getElement() {
        return elem;
    }


}
