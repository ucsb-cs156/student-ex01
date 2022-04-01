package edu.ucsb.cs156.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TimeTest {
    @Test
    public void test_getHours1() {
       Time t = new Time(14,7);
       assertEquals(14, t.getHours());
    }

    @Test
    public void test_getMinutes1() {
        Time t = new Time(14,7);
        assertEquals(7, t.getMinutes());
     }

     @Test
     public void test_toString1() {
        Time t = new Time(14,7);
        assertEquals("02:07pm", t.toString());
     }

     @Test
     public void test_toString2() {
        Time t = new Time(2,7);
        assertEquals("02:07am", t.toString());
     }

     @Test
     public void test_toStringNoon() {
        Time t = new Time(12,0);
        assertEquals("12:00pm", t.toString());
     }

     @Test
     public void test_toString1201() {
        Time t = new Time(12,1);
        assertEquals("12:01pm", t.toString());
     }

     @Test
     public void test_toString1159() {
        Time t = new Time(11,59);
        assertEquals("11:59am", t.toString());
     }

     @Test
     public void test_toString1pm() {
        Time t = new Time(13,00);
        assertEquals("01:00pm", t.toString());
     }
}