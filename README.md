# student-tutorial

Code for Student tutorial

See: <https://ucsb-cs156.github.io/tutorials/student/>


To run pitest:

```
mvn clean test org.pitest:pitest-maven:mutationCoverage
```

Or simply:

```
mvn test org.pitest:pitest-maven:mutationCoverage
```

Then open this file: (`DATE` is not literally `DATE`, but a date-time string such as `202201051153`)

`target/pit-reports/DATE/index.html`