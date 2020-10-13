package edu.ucsb.cs156.student;
public class Student {
    String name;
    int perm;

    public Student() {
        name = "Sample Student";
        perm = 9999999;
    }

    public Student(String name, int perm) {
        this.name = name;
        this.perm = perm;
    }

    public String getName() {
        return this.name;
    }

    public int getPerm() {
        return this.perm;
    }

    @Override
    public String toString() {
        return "[name: " + this.name + ", perm: " + this.perm + "]";
    }
}