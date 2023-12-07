package edu.umb.cs680.hw13.fs;

public interface FSVisitor {
    public abstract void visit(Link link); 

    public abstract void visit(Directory directory);

    public abstract void visit(File file);

}
