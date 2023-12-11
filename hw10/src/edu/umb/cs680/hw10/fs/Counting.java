package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.util.CountingVisitor;

public class Counting implements FSCommand {

    private FSElement elem;

    private CountingVisitor v = new CountingVisitor();

    public Counting(FSElement elem) {
        this.elem = elem;
    }

    public void execute() {
        elem.accept(v);
    }

    public CountingVisitor getVisitor() {
        return v;
    }

    public FSElement getElement() {
        return elem;
    }

}