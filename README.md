# ROOTServices

Room Occupancy Optimization Tool (ROOT) is a Spring Boot based Restful Mircoservice design to optimize the process of selecting a
room based on the available price offered by hotel customers.

Running ROOTservices
To run ROOT you can either clone or download the source code, open it with Netbeans and perform unit tests by clicking on the class you wish to Test OR run the jar file which is located in target folder in this repository.

To run ROOT's jar, open your the commmand prompt/line inferace (CMD)

Change directory to the location of the ROOT jar, the jar should have a name like this root-<Version(eg 1.0.3)>-SNAPSHOT.jar
if downloaded from the target folder in this repository.

From your command-line run
java -jar root-<Version(eg 1.0.3)>-SNAPSHOT.jar

Spring Boot service should start up, once startup is completed copy this link http://localhost:8179/api/occupancy to a restful test tool of your choice or  http://localhost:8179/api/occupancy/bulk for bulk upload. Personally i use Postman 

Use this Json format for a simple test

{
"availablePremiumRooms":8,
"availableEconomyRooms":1
}

User this Json format for bulk test

[
	{
		"availablePremiumRooms":3,
		"availableEconomyRooms":3
	},
	{
		"availablePremiumRooms":7,
		"availableEconomyRooms":5
	},
	{
		"availablePremiumRooms":2,
		"availableEconomyRooms":7
	},
	{
		"availablePremiumRooms":7,
		"availableEconomyRooms":1
	}
]

![postman_sample](https://raw.githubusercontent.com/adedamolaOA/ROOTServices/img/postman_sample.PNG)

![postman_sample_bulk](https://raw.githubusercontent.com/adedamolaOA/ROOTServices/img/postman_sample_bulk.PNG)

 
