# student-tutorial

Code for Student tutorial

See: <https://ucsb-cs156.github.io/tutorials/student/>


## To compile and run with simple `javac`/`java` workflow:

* `cd src/main/java`
* `javac Main.java`
* `java main`

Example:

```
pconrad@Phillips-MacBook-Pro student-ex01 % ls
LICENSE		Main.class	README.md	Student.class	pom.xml		src		target
pconrad@Phillips-MacBook-Pro student-ex01 % cd src/main/java 
pconrad@Phillips-MacBook-Pro java % ls
Main.java	Student.java
pconrad@Phillips-MacBook-Pro java % javac Main.java
pconrad@Phillips-MacBook-Pro java % ls
Main.class	Main.java	Student.class	Student.java
pconrad@Phillips-MacBook-Pro java % java Main
Usage: java Main name perm
  perm should be a positive integer between 1 and 9999999
pconrad@Phillips-MacBook-Pro java % java Main "Phill Conrad" 1234567
s1 = Student@7344699f
s2 = Student@6b95977
pconrad@Phillips-MacBook-Pro java % 
```

## To compile and run with Maven

* `cd` into the main level of the repo (the one with `pom.xml`)
* `mvn compile` to compile (`.class` files end up under `target/classes`)
* `mvn test-compile` to compile the test code
* `mvn test` to run the tests
* `mvn pacakge` to produce a `.jar` file for the project and place it in the `target` directory
* `mvn clean` to eliminate the `target` directory so you can start fresh

To run, run `mvn package` first to produce a `.jar` file under `target/`

Then, to run without command line args:

```
java -cp target/student-1.0.0.jar Main
```

To run with command line arguments:

```
java -cp target/student-1.0.0.jar Main Phill 12345 
```


(Updated for Java 17, 01/05/22)