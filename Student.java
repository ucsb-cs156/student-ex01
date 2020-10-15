public class Student {
    private String name;
    private int perm;

    public Student() {
        name = "Sample Student";
        perm = 9999999;
    }

    public Student(String name, int perm) {
        this.name = name;
        this.perm = perm;
    }

    public String name() {
        return this.name;
    }

    public int perm() {
        return this.perm;
    }
}
