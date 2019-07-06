# SpringCloudEasyStarter
A simple Spring cloud project with most common spring cloud components for easy project setup :blush:. 
SpringCloud is a wrapper around SpringBoot to address issues in distributed environments.  

**This project address followig issues in a distributed environment:**    
- Configuration Management  
- Service discovery  
- Gateway and reverse proxy  
- Log monitoring  
- Load balancing  

**SpringCloudEasyStarter have following modules and should be started sequentially.**    
- **DiscoveryServer**  
  This module will start Euereka server and all services will be registered and discoved here.  
  Eureka:    
  http://localhost:8761/    
  
 - **ConfigServer**    
   This module will take care of all services configuration  
   Please copy folder **git_repo\application-config** into any of your system folder and update in application.properties.     
   All configurations should be in a seperate git folder, normally it should be in git repo.In this project I have used file url.
  The git file url should be updated in **ConfigServer\src\main\resources\application.properties**  
  - **ZipkinServer**  
    This module used for starting zipkin server and all logs can be monitored here.  
    http://localhost:9411/zipkin   
  - **BookService**  
     This is a boot micro service to deliver books and this service internally call StoreService if some books are not available.
     **You can start any number of instance of this service**.It will automatically get a random port.And this service will be invoked using Gateway url.  Internally it will also do load balancing and decide which instnace of StoreService need to be called.  
     http://localhost:8080/book-service/books    
     **Note:** Port 8080 is of Gateway   
     
     In the BookService controller we have a property called **message**.This can be reloaded from external configuration in book-service.properties.Just add some new value, this values will be refelcted in all services.  
     
     http://localhost:8080/book-service/books/message
     
     However we have to make a explicit refresh call to our service using actuator.
     Find any instance of the bookservice from Eureka admin console and click on it it will showing like http://192.168.0.87:64826/actuator/info, port may be diffrent.Change info with refresh and hit.This will refesh prop value in all service instances.       
     Eg URL: http://192.168.0.87:64826/actuator/refresh  
     
    Try calling http://localhost:8080/book-service/books/message again.It will show new message.Its also show server instance id in reponse to show load balancing.    
    **Note**: Please refer BookServiceApplicationTests to see a baci unit testing with mocking.  
     
     **How to create new instance of the service ?**  
     Navigate to Boot Dashboard in SpringToolSuite IDE and right click the service and select Duplicate config :stuck_out_tongue_winking_eye:  
     
   - **StoreService**  
     This is a boot micro service to deliver books and this service.**You can start any number of instance of this service**.It will automatically get a random port.And this service will be invoked using Gateway url.    
     http://localhost:8080/store-service/book     
     **Note** Port 8080 is of Gateway     
     
  - **Gateway**  
     This module will act as a gateway and reverse proxy for our application.  
     Client only need to know the Gateway domain and port and no need to bother about CORS issues, it will internally mapping request to corresponding service.Also request will be load balanced internally.Even though we have many micro services, for the client, they will feel like calling a traditional Monolithic application :smile:  
     You can add you autentication and authorization logic may be here.  
     


**How to start?**  
- Install Spring Tool Suit:  
  [SpringToolSuite](https://spring.io/tools)  
- Import Existing Maven project and browse root pom.xml.  
  

**Test urls:**   
TestUrls:  
http://localhost:8080/book-service/books  
http://localhost:8080/book-service/books/message  
http://localhost:8080/book-service/books/12345  


Note: I have not captured authentication,authorization,transaction management etc.And this is currently not in the scope of this project.

Enjoy coding :+1:
