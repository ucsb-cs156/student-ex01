package edu.ucsb.cs156.student;


import java.util.Comparator;

/**
 * An example of a comparator as a separate named class.
 * 
 * Note that Comparators are seldom implemented this way in practice;
 * we illustrate it here as a basis for going on to show Comparators
 * as first inner classes, then anonymous inner classes, then
 * finally as lambda expressions.
 */
public class StudentNameComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }

}