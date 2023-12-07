package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.util.CountingVisitor;

public class Counting implements FSCommand {

    public FSElement elem;

    public CountingVisitor v = new CountingVisitor();

    public Counting(FSElement elem) {
        this.elem = elem;
    }

    public void execute() {
        elem.accept(v);
    }

}