public class Main { // implicit: public class Main extends object

    public static void main(String[] args) {

        String usageMessage = "Usage: java Main name perm\n"
                + "  perm should be a positive integer between 1 and 9999999";

        // Similar to argc/argv in C++

        if (args.length != 2) {
            System.err.println(usageMessage);
            System.exit(1);
        }

        String name = args[0];
        int perm = 0; // avoids the "perm may not have been assigned" error
        try {
            perm = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println(usageMessage);
            System.exit(2);
        }

        Student s1 = new Student();
        Student s2 = new Student(name, perm);

        System.out.println("s1 = " + s1); // implicit: s1.toString()
        System.out.println("s2 = " + s2); // implicit: s2.toString()

    } // main

}