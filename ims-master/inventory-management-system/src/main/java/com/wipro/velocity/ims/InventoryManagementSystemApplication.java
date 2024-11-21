package com.wipro.velocity.ims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication annotation, means this is the starting point for our Spring Boot application.

 

Its a wrapper of following:

 

@Configuration – Flags the class as a source of bean definitions for the application context.
@ComponentScan – Searches for beans and components (e.g., Controllers, Services, Repositories, etc.) in the package hierarchy.
@EnableAutoCofiguration – Inspects the application context and classpath and automatically configures the required beans using opinionated assumptions.

 
It also automatically configures front controller - dispatcher servelet
*/

@SpringBootApplication
public class InventoryManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementSystemApplication.class, args);
	}

}

