package com.opensourzesupport.cloud.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
/**
 * to create a Discovery server.You can also create a Discovery server using
 * spring cloud cli.No need of a separate project for his :)
 * 
 * @author PRASOBH KOLLATTU
 *
 */
public class DiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerApplication.class, args);
	}

}
