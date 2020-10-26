package edu.ucsb.cs156.student;
public class Student {
    private String name;
    private int perm;

    public Student() {
        name = "Sample Student";
        perm = 999999;
    }

    public Student(String name, int perm) {

        if (!validPerm(perm)) {
            throw new IllegalArgumentException("Unacceptable value for perm: " + perm);
        }

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

    public static boolean validPerm(int perm) {
        if (perm < 1 || perm > 9999996) {
            return false;
        }
        if (perm <= 999999)
           return true;
        int lastDigit = perm % 10;
        int firstSix = perm / 10;
        return lastDigit == Luhn.checkDigit(firstSix);
    }

}
