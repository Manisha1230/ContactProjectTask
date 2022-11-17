package com.Project.Contact.Processing.ProjectContactDemo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Project.Contact.Processing.ProjectContactDemo.Contact.ContactDetails;
@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Integer>{

	
	
   List<ContactDetails> findByContactId(int id);

	

	

}
