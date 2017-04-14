[![Build Status](https://travis-ci.org/snaketl/triangle-challenge.svg?branch=master)](https://travis-ci.org/snaketl/triangle-challenge)

# Triangle challenge

>Write a program that will determine the type of a triangle. It should take the lengths of the triangle's three sides as input, and return whether the triangle is equilateral, isosceles or scalene.

This app solves triangle problem using the length of 3 sides.

Input:

- The three sides of the triangle. Could be any number (decimal or integer) greater than zeros. It must respect the triangle inequality formula.

Output:

- The type of triangle (scalene, equilateral or isosceles) or the message detailing the problem with the input values.

## Build and run

To build this project:

```mvn clean install```

### You could use the Command Line Interface (CLI):

Run using Maven:

```mvn exec:java -Dexec.mainClass="br.com.luizfeltes.triangle.cli.TriangleCLI" -Dexec.args="-sides a b c"```

Where the values **a**, **b** and **c** are the sides of triangle. Example:

```mvn exec:java -Dexec.mainClass="br.com.luizfeltes.triangle.cli.TriangleCLI" -Dexec.args="-sides 2 2 2"```

### Or you could use the http API running the embedded http server:

Run using Maven to create the server:

```mvn exec:java -Dexec.mainClass="br.com.luizfeltes.triangle.api.TriangleServer"```

And make some calls using the web browser, using this url:

http://localhost:8080/triangle/type?a=X&b=Y&c=Z

Where the values **X**, **Y** and **Z** are the sides of triangle. Example:

http://localhost:8080/triangle/type?a=2&b=2&c=2

## Details

- Apache maven as a build tool
- Apache Commons CLI as a command line tool
- Jetty as a embedded http server
- Jersey to build the web service API
- JUnit as a unit testing tool
