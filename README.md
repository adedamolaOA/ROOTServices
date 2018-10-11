# ROOTService

Room Occupancy Optimization Tool (ROOT) is a Spring Boot based Restful Mircoservice design to optimize the process of selecting a
room based on the available price offered by hotel customers.

Running ROOTservice
To run ROOT you can either clone or download the source code and open it has a Netbeans project test units are available in the source code the test unit are designed using JUnit and SpringTest OR run the jar file which is located in target folder on this repository.

To run ROOT's jar, open your the commmand prompt/line inferace (CMD)

Change directory to the location of the ROOT jar, the jar should have a name like this root-<Version(eg 1.0.3)>-SNAPSHOT.jar
if downloaded from the target folder in this repository.

From your command-line run
java -jar root-<Version(eg 1.0.3)>-SNAPSHOT.jar

Spring Boot service should start up, once startup is completed copy this link http://localhost:8179/api/occupancy to a restful test tool of your choice. Personally i use Postman 

The format for testing is using JSON an example of this test can be seen below
{
"availablePremiumRooms":8,
"availableEconomyRooms":1
}

![alt text](https://raw.githubusercontent.com/adedamolaOA/ROOTServices/img/postman_sample.PNG)


 
