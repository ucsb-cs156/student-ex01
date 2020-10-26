package edu.ucsb.cs156.student;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

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

    @Test(expected = IllegalArgumentException.class)
    public void test_constructor_zeroPerm() {
        Student s = new Student("Test",0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_constructor_negPerm() {
        Student s = new Student("Test",-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_constructor_tooBigPerm() {
        Student s = new Student("Test",10000000);
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

    @Test
    public void test_validPerm_1() {
       assertTrue(Student.validPerm(1));
    }

    @Test
    public void test_validPerm_9999996() {
        assertTrue(Student.validPerm(9999996));
    }

    @Test
    public void test_validPerm_999999() {
      assertTrue(Student.validPerm(999999));
    }

    @Test
    public void test_validPerm_1111119() {
      assertFalse(Student.validPerm(1111119));
    }

}
