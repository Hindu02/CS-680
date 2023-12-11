package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.util.FileCrawlingVisitor;
import edu.umb.cs680.hw10.fs.util.FileSearchVisitor;

public class FileCrawling implements FSCommand {

    private FSElement elem;

    private FileCrawlingVisitor v = new FileCrawlingVisitor();

    public FileCrawling(FSElement elem) {
        this.elem = elem;
    }

    public void execute() {
        elem.accept(v);
    }

    public FileCrawlingVisitor getVisitor() {
        return v;
    }

    public FSElement getElement() {
        return elem;
    }


}