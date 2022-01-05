import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertEquals("[name: Sample Student, perm: 9999999]", s.toString());
    }


}
