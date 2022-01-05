package edu.ucsb.cs156.student;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    public void test_getName1() {
        Student s = new Student();
        assertEquals("Sample Student", s.getName());
    }

    @Test
    public void test_getName2() {
        Student s = new Student("Chris Gaucho", 1234567);
        assertEquals("Chris Gaucho", s.getName());
    }

    @Test
    public void test_getPerm1() {
        Student s = new Student();
        assertEquals(9999999, s.getPerm());
    }

    @Test
    public void test_toString1() {
        Student s = new Student();
        String expected = "[name: Sample Student, perm: 9999999]";
        assertEquals(expected, s.toString());
    }

    @Test
    public void test_constructor_zeroPerm() {
        assertThrows( IllegalArgumentException.class, () -> {
                Student s = new Student("Test",0);
        });
    }

    @Test
    public void test_constructor_negPerm() {
        assertThrows( IllegalArgumentException.class, () -> {
            Student s = new Student("Test",-1);
        });
    }

    @Test
    public void test_constructor_tooBigPerm() {
        assertThrows( IllegalArgumentException.class, () -> {
            Student s = new Student("Test",10000000);
        });
    }

    @Test
    public void test_constructor_perm_1_ok() {
        Student s = new Student("Test",1);
        assertEquals(1,s.getPerm());
    }

    @Test
    public void test_constructor_perm_9999999_ok() {
        Student s = new Student("Test",9999999);
        assertEquals(9999999,s.getPerm());
    }

}
