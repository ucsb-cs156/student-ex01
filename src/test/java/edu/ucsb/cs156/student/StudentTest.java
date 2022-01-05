package edu.ucsb.cs156.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    public void test_getName1() {
        Student s = new Student();
        assertEquals("Sample Student", s.getName());
    }

    @Test
    public void test_getName2() {
        Student s = new Student("Chris Gaucho", 1234566);
        assertEquals("Chris Gaucho", s.getName());
    }

    @Test
    public void test_getPerm1() {
        Student s = new Student();
        assertEquals(999999, s.getPerm());
    }

    @Test
    public void test_toString1() {
        Student s = new Student();
        String expected = "[name: Sample Student, perm: 999999]";
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
    public void test_constructor_perm_9999996_ok() {
        Student s = new Student("Test",9999996);
        assertEquals(9999996,s.getPerm());
    }

    @Test
    public void test_validPerm_1111111() {
        assertTrue(Student.validPerm(1111111));
    }

    @Test
    public void test_validPerm_neg1_false() {
        assertFalse(Student.validPerm(-1));
    }

    @Test
    public void test_validPerm_0_false() {
        assertFalse(Student.validPerm(0));
    }

}
