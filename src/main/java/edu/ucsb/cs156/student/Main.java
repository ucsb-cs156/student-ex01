package edu.ucsb.cs156.student;
public class Main { // implicit: public class Main extends object

    public static void main(String[] args) {

        String usageMessage = "Usage: java Main first last perm units\n"
                + "  perm should be a positive integer between 1 and 9999999";

        if (args.length != 4) {
            System.err.println(usageMessage);
            System.exit(1);
        }

        String first = args[0];
        String last = args[1];

        int perm = 0; // avoids the "perm may not have been assigned" error
        try {
            perm = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.err.println(usageMessage);
            System.exit(2);
        }

        int units = 0; 
        try {
            units = Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            System.err.println(usageMessage);
            System.exit(3);
        }

        Student s1 = new Student();
        Student s2 = new Student(first, last, perm, units);

        System.out.println("s1 = " + s1); // implicit: r1.toString()
        System.out.println("s2 = " + s2); // implicit: r2.toString()

    } // main

}