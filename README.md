# SpringCloudEasyStarter
A simple Spring cloud project with most common components for easy startup.  
**This project address followig issues:**    
- Configuration Management  
- Service discovery  
- Gateway and reverse proxy  
- Log monitoring  
- Load balancing  

**Application have following modules and should be started sequentially.**    
- **DiscoveryServer**  
  This module will start Euereka server and all services will be registered and discoved here.  
  Eureka:    
  http://localhost:8761/    
  
 - **ConfigServer**    
   This module will take care of all services configuration  
   Please copy folder git_repo\application-config in any of your system folder and update in application.properties.     
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


Enjoy coding :+1:
