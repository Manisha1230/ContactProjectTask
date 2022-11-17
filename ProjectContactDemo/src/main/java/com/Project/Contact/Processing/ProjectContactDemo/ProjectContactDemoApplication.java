package com.Project.Contact.Processing.ProjectContactDemo;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.service.ServiceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.Project.Contact.Processing.ProjectContactDemo.Contact.Contact;
import com.Project.Contact.Processing.ProjectContactDemo.Contact.ContactDetails;

@SpringBootApplication
public class ProjectContactDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectContactDemoApplication.class, args);

	}

}
