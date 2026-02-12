package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/*
	 * TODO:
	 *  - Finish JSP
	 *  - Research functional interfaces + create an Interface for my Service to implement
	 *  - Study Web.XML and how it relates to end points, why they are important in Tomcat
	 *  - Research Bootstrap 5 and DataTable, use DataTable in JSP
	 *  - Do I need to connect endpoints in an abstract class to a Web.XML file
	 *  - Think about Cartesian products - am I creating one? 
	 *  - Write second Hibernate DAO with Score as return type
	 *  - Figure out how JPA loads associated data from joined tables using a DTO without fetch
	 *  - Make two new DAO methods: one with Score entity and fetching, one with Score entity and eager fetching (needs different entity class)
	 * */
}
