# school-project-kiosk
Kiosk project for System design class at Seattle Central

Dependencies
----
- Java SE 11 (LTS) JDK
- [Maven](https://maven.apache.org/install.html)

Run
----
- Build: 
`mvn clean install`
- Run the JAR: 
`java -jar target/kiosk-0.0.1-SNAPSHOT.jar`
- Run the JAR with optional args
  - `--status=users` -> prints the users table after running the program
