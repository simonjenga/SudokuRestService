Sudoku Rest Service Provider
=============================

This project is a RESTful web application that is an implementation of a Sudoku Web Service. When deployed on the Server, this RESTful web
service validates successive moves done using a HTTP URL against a Sudoku board that is part of the project. The application can also be able
to recognise and indicate if the Sudoku is finished with the current move. A custom user provided Sudoku board is also be provided.

Building The Project
====================

This project compiles with ```JDK >= 1.5``` and uses ```Maven >= 3.1.1``` as the build tool and also to manage the project dependencies.

To run a full Maven build, execute the following from a console/command prompt with the project root directory as the top level directory:

```mvn clean package```

To run a Maven build that skips executing Unit Tests, execute the following from a console/command prompt with the project root directory as the top level directory:

```mvn clean package -DskipTests -Dinvoker.skip=true```

This will create a distributable and deployable WAR file for the web application. This WAR file can be deployed on the latest versions of web servers/containers e.g Jetty, Tomcat, WildFly, TomEE etc.

This project includes some plug-ins it's the Maven Build file for deploying into various commonly used JavaEE Server's.

In order to build and deploy it to the Apache TomEE Server, execute the following command:

```mvn clean package tomee:run -DskipTests -Dinvoker.skip=true```

In order to build and deploy it to the WildFly X.X.X.Final Server, execute the following command:

```mvn clean package antrun:run -Pdeploy-war -DskipTests -Dinvoker.skip=true```

In order to build and deploy it to either Tomcat or Jetty Server, execute only one of the following commands:

```mvn jetty:run-war```

```mvn jetty:run-war -DskipTests -Dinvoker.skip=true```

```mvn tomcat7:run-war```

```mvn tomcat7:run-war -DskipTests -Dinvoker.skip=true```

This will create a distributable WAR file and deploy it in the respective embedded Tomcat or Jetty Server.

To interact with the RESTful web services using Git Bash or a Console window, execute any of the following commands:

`curl -X PUT -L -G -d "row=7&column=7&value=5" http://localhost:8080/SudokuRestService/sudokuservice/sudoku`

`curl -X PUT -L -G -d "row=3&column=3&value=8" http://localhost:8080/SudokuRestService/sudokuservice/sudoku`

`curl -X PUT -L -G -d "row=5&column=8&value=4" http://localhost:8080/SudokuRestService/sudokuservice/sudoku`

`curl -X PUT -L -G -d "row=-1&column=9&value=10" http://localhost:8080/SudokuRestService/sudokuservice/sudoku`

`curl -X PUT -L -G -d "row=4&column=3&value=2" http://localhost:8080/SudokuRestService/sudokuservice/sudoku`

`curl -X PUT -L -G -d "row=9&column=9&value=15" http://localhost:8080/SudokuRestService/sudokuservice/sudoku`

`curl -X PUT -L -G -d "row=7&column=7&value=" http://localhost:8080/SudokuRestService/sudokuservice/sudoku`

`curl -X PUT -L -G -d "row=7&column=7&value=a" http://localhost:8080/SudokuRestService/sudokuservice/sudoku`

Alternatively, you can use the web browser plugin/add-on called RESTClient (a debugger for RESTful web services) or you can also use Postman so as
to enable you to interact with the RESTful web services.

To run Unit tests in this project, execute the following:

```mvn clean test```

### Instructions

Eclipse users run `mvn eclipse:eclipse` and then import the project or just import the code as a Maven project into IntelliJ, NetBeans, or Eclipse.

To generate project documentation of Java source files (Javadoc), run `mvn javadoc:javadoc`