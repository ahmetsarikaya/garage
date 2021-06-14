# garage
<br/><b>Java Version:</b> 11
<br/><b>SpringBoot version:</b> 2.5.1

<b>To start project:</b>
./mvnw spring-boot:run

<b>To run test</b>
 ./mvnw test

After project start:

In the Postman, call the following urls:
To park Car:(POST) <br/>
http://localhost:8080/garage/park/car?color=Black&plate=34-SO-1988  

To park Jeep:<br/>
http://localhost:8080/garage/park/jeep?color=Black&plate=34-SO-1988  

To park Truck<br/>
http://localhost:8080/garage/park/truck?color=Black&plate=34-SO-1988  

to leave a vehicle at the slot (3) (DELETE)<br/>
http://localhost:8080/garage/leave/3

to get garage status (GET)<br/>
http://localhost:8080/garage/status
