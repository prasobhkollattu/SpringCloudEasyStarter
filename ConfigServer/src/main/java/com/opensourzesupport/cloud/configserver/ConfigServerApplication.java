package com.opensourzesupport.cloud.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
/**
 * to create a Configuration server.You can also create a Configuration server
 * using spring cloud cli.No need of a separate project for his :)
 * 
 * @author PRASOBH KOLLATTU
 *
 */
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
