package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.util.FileCrawlingVisitor;

public class FileCrawling implements FSCommand {

    public FSElement elem;

    public FileCrawlingVisitor v = new FileCrawlingVisitor();

    public FileCrawling(FSElement elem) {
        this.elem = elem;
    }

    public void execute() {
        elem.accept(v);
    }

}