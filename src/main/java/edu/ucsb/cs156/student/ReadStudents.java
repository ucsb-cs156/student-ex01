package edu.ucsb.cs156.student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import java.util.ArrayList;
import java.util.Collections;

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

        students.sort(new StudentNameComparator());
        System.out.println("Sorted by name using StudentNameComparator");
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