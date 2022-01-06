# Planning
### Start,  Backend
To make this project we should use Spring Boot with dependencies: Spring Data JPA, postgreSQL and Thymeleaf.<br>
There should also have to be installed in our computer postgreSQL, maven and some IDE for work(IntellijIDEA .etc). Connection between Spring Boot and postgreSQL is done within terminal using Google. 
#### Track classes
Create Track class ith fields id, title, author, release, genre, submitter, urlposter, then their setters and getters with toString method.<br>

![img2](https://user-images.githubusercontent.com/60456879/112560001-658dd100-8dfc-11eb-88c9-32d8263c78c6.png)<br>
To create table track in database, we use the following lines:<br>
![img1](https://user-images.githubusercontent.com/60456879/112560000-645ca400-8dfc-11eb-9c61-3baf646e63e6.png)<br>
Configuration class for Track is following: <br>
![img3configurationtrack](https://user-images.githubusercontent.com/60456879/112560003-658dd100-8dfc-11eb-9053-a8c5a916aaaa.png)<br>
Repository class for Track is following: <br>.

![repositoryclass](https://user-images.githubusercontent.com/60456879/112560781-1648a000-8dfe-11eb-9ed3-4c28133ec1cb.png)<br>

There is a Controller class, which connects frontend with the server and has GET, POST, PUT, DELETE mapping operations:<br>
![imagecontroller](https://user-images.githubusercontent.com/60456879/112561055-a1c23100-8dfe-11eb-8b89-f3e3315e2d51.png)
![imagecontroller2](https://user-images.githubusercontent.com/60456879/112561056-a2f35e00-8dfe-11eb-926a-b18ba477014e.png)<br>
Controller class calls functions from Service class, which operates with database through Repository class.<br>
There is also a PageController class, which helps to navigate between several html files. <br>

### Frontend
There are about, API, index html files, through which we can navigate. There is also nvb.html file, which is navbar used in other html files.<br>
![header](https://user-images.githubusercontent.com/60456879/112561600-c23ebb00-8dff-11eb-855e-cd9b5100e881.png)
#### index.html
List of all tracks is implemented in following:<br>
![indexhtml](https://user-images.githubusercontent.com/60456879/112561601-c2d75180-8dff-11eb-87d2-eb68ffeed146.png)<br>
alltracks list of objects is created in controller class, which is provides data from database to the list.<br>
To view more about one specific track we press view button. This button links to onetrack file:<br>
![onetrack](https://user-images.githubusercontent.com/60456879/112561605-c2d75180-8dff-11eb-8401-38b95a021d6b.png)<br>
onetrack file contains several parts where edit and delete buttons provided.<br>
Edit and delete functions are in controller class, buttons link to methods of this class.<br>
![editdelete](https://user-images.githubusercontent.com/60456879/112562063-b0a9e300-8e00-11eb-9a91-2a84db02091d.png)

![edit](https://user-images.githubusercontent.com/60456879/112561597-c1a62480-8dff-11eb-93da-aee5c5582827.png)<br>
Adding file is quite the same as edit file:<br>
![adding](https://user-images.githubusercontent.com/60456879/112561596-c074f780-8dff-11eb-9777-d77724eca390.png)<br>
### Thank you for attention!







