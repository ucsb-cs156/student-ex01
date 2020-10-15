public class Student {
    private String name;
    private int perm;

    public Student() {
        this.name = "Sample Student";
        this.perm = 9999999;
    }

    public Student(String name, int perm) {
        this.name = name;
        this.perm = perm;
    }

    public String getName() {
        return this.name;
    }

    public int getPerm() {
        return this.perm;
    }

    @Override
    public String toString() {
        return "[name: " + this.name + ", perm: " + this.perm + "]";
    }
}
