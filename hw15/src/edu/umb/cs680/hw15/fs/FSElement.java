package edu.umb.cs680.hw15.fs;

import java.time.LocalDateTime;


abstract class FSElement {
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    protected Directory parent;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public String getName() {
        return name;
    }
 
    public Directory getParent() {
        return parent;
    }

    public int getSize() {
        return size;
    }

    public abstract boolean isDirectory();

    public abstract void accept(FSVisitor v);
}