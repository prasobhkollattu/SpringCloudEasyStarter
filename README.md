# SpringCloudEasyStarter
A simple Spring cloud project with most common components for easy startup.  
This project address followig issues:  
- Configutaion Management  
- Service discovery  
- Gateway and reverse proxy  
- Log monitoring  
- Load balancing  

Application have following modules and should be started sequentially.   
- **DiscoveryServer**  
  This module will start Euereka server and all services will be registered and discoved here.  
  Eureka:    
  http://localhost:8761/    
  
 - **ConfigServer**    
   This module will take care of all services configuration  
  - **ZipkinServer**  
    This module used for starting zipkin server and all logs can be monitored here.  
    http://localhost:9411/zipkin   
  - **BookService**  
     This is a boot micro service to deliver books and this service internally call StoreService if some books are not available.
     You can start any number of instance of this service.It will automatically get a random port.And this service will be invoked using Gateway url.  Internally it will also do load balancing and decide which instnace of StoreService need to be called.  
     http://localhost:8080/book-service/books    
     **Note:** Port 8080 is of Gateway   
     
   - **BookService**  
     This is a boot micro service to deliver books and this service.You can start any number of instance of this service.It will automatically get a random port.And this service will be invoked using Gateway url.    
     http://localhost:8080/book-service/books    
     port 8080 is of Gateway   
     
  
   


How to start?  
1.Install Spring Tool Suit:  
  [SpringToolSuite](https://spring.io/tools)  
2.Import Existing Maven project and browse root pom.xml.  
  All configurations should be in a seperate git folder, normally it should be in git repo.In tis project I have used file file url.
  The git file url should be update in **ConfigServer\src\main\resources\application.properties**

Application & Test urls:  


Zipkin URL:  
http://localhost:9411/zipkin  
TestUrls:  
http://localhost:8080/book-service/books  
http://localhost:8080/book-service/books/message  
http://localhost:8080/book-service/books/12345  


Enjoy coding :+1:
