# SocketsExample
This repo is for assignment 1 in CSE411: Distributed Computer Systems course


## Running the application
You have to download java jdk first.
- For Windows:
Execute `runServer.bat` then `runSensors.bat` then `runComputer.bat`
- For Linux and Mac:
Open three terminals and go to `src/main/java` directory in each of them then execute:<br>
`javac  'src/main/java/com/mycompany/assignment1/Server.java' 'src/main/java/com/mycompany/assignment1/Computer.java' 'src/main/java/com/mycompany/assignment1/Sensors.java' 'src/main/java/com/mycompany/assignment1/SensorsMultiThreaded.java' 'src/main/java/com/mycompany/assignment1/ServerMultiThreaded.java' 
`<br>
and
<br>
`java com.mycompany.assignment1.Server` in the first terminal.<br>
`java com.mycompany.assignment1.Sensors` in the second terminal.<br>
`java com.mycompany.assignment1.Computer` in the third terminal.
