package com.Project.Contact.Processing.ProjectContactDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.Contact.Processing.ProjectContactDemo.Contact.Contact;
import com.Project.Contact.Processing.ProjectContactDemo.Contact.ContactDetails;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {



}
