# student-ex01

Code for Student tutorial, ex01

See: <https://ucsb-cs156.github.io/tutorials/student_ex01/>

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