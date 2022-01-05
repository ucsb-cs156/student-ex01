package edu.ucsb.cs156.student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import java.util.ArrayList;
import java.util.Collections;

import java.util.Comparator;

public class ReadStudents {
    public static void main(String[] args) {

        String usageMessage = "Usage: java Main filename\n"
                + "  filename should be a text file containing students in CSV format";

        if (args.length != 1) {
            System.err.println(usageMessage);
            System.exit(1);
        }

        String filename = args[0];

        List<String> allLines = null;

        try {
            allLines = Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            System.err.println("ERROR: could not open file " + filename);
            System.err.println(e);
            System.exit(2);
        }

        ArrayList<Student> students = linesToStudents(allLines);

        System.out.println("Order from file:");
        listStudents(students);

        Collections.sort(students);
        System.out.println("Sorted by perm (natural ordering):");
        listStudents(students);

        students.sort(new StudentLastNameComparator());
        System.out.println("Sorted by last name using StudentLastNameComparator");
        listStudents(students);

        students.sort(new Student.FirstNameComparator());
        System.out.println("Sorted by first name using Student.FirstNameComparator");
        listStudents(students);

        // Comparator as instance of anonymous inner class
        // that implements an interface

        Comparator<Student> unitsComparator = new Comparator<Student>(){
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getUnits(),s2.getUnits());
            }
        };

        // THE FOLLOWING IS EQUIVALENT TO THE CODE IN THE DECLARATION ABOVE
        // 
        // Comparator<Student> unitsComparator = 
        //    ( s1,  s2) -> Integer.compare(s1.getUnits(),s2.getUnits());
            
        students.sort(unitsComparator);
        System.out.println("Sorted by units using unitsComparator");
        listStudents(students);
        
        // Comparator as Lambda Expression
        // which is just a short hand for instance of anonymous
        // inner class.  
        
        // Can only be used with interfaces that
        // are declared with @FunctionalInterface.
        // They may have one and only one abstract method.
        
        Comparator<Student> unitsComparatorReversed = 
            (s1, s2) -> -1 * Integer.compare(s1.getUnits(), s2.getUnits());

        students.sort(unitsComparatorReversed);
        System.out.println("Sorted by units using unitsComparatorReversed");
        listStudents(students);

        // Compare first by last name, then first name, then perm.
        // That is, the order should be like this:

        // Wang, Richert, 876543
        // Wang, William, 123456
        // Wang, William, 234567
        // Wang, Yuan-Fang, 234776
        // Wang, Yuxiang, 129877
        
        Comparator <Student> permComparator = (s1,s2) -> s1.getPerm() - s2.getPerm();

        // Comparator <Student> permComparator = (s1,s2) -> Integer.compare(s1.getPerm(),s2.getPerm());


        Comparator<Student> rosterComparator = new StudentLastNameComparator().thenComparing(new Student.FirstNameComparator()).thenComparing(permComparator);

        students.sort(rosterComparator);
        System.out.println("Sorted by rosterComparator");
        listStudents(students);

    } // main

    /**
     * Print students one per line
     * @param students
     */
    public static void listStudents(List<Student> students) {
        for (Student s: students) {
            System.out.println(s);
        }
    }

    public static ArrayList<Student> linesToStudents(List<String> lines) {

        ArrayList<Student> result = new ArrayList<Student>();

        for (String line: lines) {
            try {
                Student s = Student.fromCSV(line);
                result.add(s);
            } catch (Student.InvalidCSVLineException e1) {
                System.err.println("Invalid line ignored: " + line);
            } catch (Student.InvalidPermException e2) {
                System.err.println("Line with invalid perm ignored: " + line);
            }
        }
        return result;
    }


}