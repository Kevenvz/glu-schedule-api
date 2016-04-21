# Grafisch Lyceum Utrecht - Timetable Calendar

Application made to put your timetable in your Google Calendar.

## Dependencies

There are a few dependencies you need to have in order to build, and run the project.

* [Java Development Kit (JDK)](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven 3](https://maven.apache.org/)

## Edit the configuration file

You need to edit the configuration file to your credentials. If you do not do this the application will not work. The configuration file is located at`/src/main/resources/application.yml`

## How to build

Make sure `Maven` is in your path so that you can access the `mvn` command. Then open up a terminal and execute the command `mvn package`. A .jar file will be build inside the `target` directory.

## How to run

Make sure you've changed the configuration file and successfully build the project. If the build has been successful you have a `target` directory. If the `target` directory exist open up a terminal and execute the command `java -jar target/timetable-0.0.1-SNAPSHOT.jar`

After you've run the project go to http://localhost:8080 to see the website in action.
