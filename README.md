Sudoku Rest Service Provider
=============================

This project is a RESTful web application that is an implementation of a Sudoku Web Service. When deployed on the Server, this RESTful web
service validates successive moves done using a HTTP URL against a Sudoku board that is part of the project. The application can also be able
to recognise and indicate if the Sudoku is finished with the current move. A custom user provided Sudoku board is also be provided.

Building The Project
====================

This project compiles with ```JDK >= 1.5``` and uses ```Maven >= 3.1.1``` as the build tool and also to manage the project dependencies.

To run Maven build, execute the following from a console/command prompt with the project root directory as the top level directory:

```mvn clean package```

This will create a distributable and deployable WAR file for the web application. This WAR file can be deployed on the latest versions of web servers/containers e.g Jetty, Tomcat, JBoss etc.

This project includes an embedded Tomcat Server as a plug-in in the Maven Build file. In order to run this project using this plug-in, execute only one of the following commands:

```mvn clean tomcat7:run-war```

```mvn clean tomcat7:run-war -DskipTests -Dinvoker.skip=true```

This will create a distributable WAR file and deploy it in the embedded Tomcat Server.

To interact with the RESTful web services, open a web browser and execute any of the following URLs at the address bar:

```http://localhost:8080/SudokuRestService/sudokuservice/sudoku?row=7&column=7&value=5```

```http://localhost:8080/SudokuRestService/sudokuservice/sudoku?row=3&column=3&value=8```

```http://localhost:8080/SudokuRestService/sudokuservice/sudoku?row=5&column=8&value=4```

```http://localhost:8080/SudokuRestService/sudokuservice/sudoku?row=-1&column=9&value=10```

```http://localhost:8080/SudokuRestService/sudokuservice/sudoku?row=4&column=3&value=2```

```http://localhost:8080/SudokuRestService/sudokuservice/sudoku?row=9&column=9&value=15```

```http://localhost:8080/SudokuRestService/sudokuservice/sudoku?row=7&column=7&value=a```

```http://localhost:8080/SudokuRestService/sudokuservice/sudoku?row=7&column=7&value=```

Alternatively, you can use the web browser plugin/addon called RESTClient(a debugger for RESTful web services) to enable you to interact with the REST services.
[RESTClient](http://www.restclient.net/)

To run Unit tests in this project, execute the following:

```mvn clean test```

### Instructions

Eclipse users run `mvn eclipse:eclipse` and then import the project or just import the code as a Maven project into IntelliJ, NetBeans, or Eclipse.

To generate project documentation of Java source files (Javadoc), run `mvn javadoc:javadoc`