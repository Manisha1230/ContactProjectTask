package com.Project.Contact.Processing.ProjectContactDemo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Contact.Processing.ProjectContactDemo.Contact.Contact;
import com.Project.Contact.Processing.ProjectContactDemo.Contact.ContactDetails;
import com.Project.Contact.Processing.ProjectContactDemo.Repository.ContactDetailsRepository;
import com.Project.Contact.Processing.ProjectContactDemo.Repository.ContactRepository;

@Service
public class ServiceClass {

	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private ContactDetailsRepository contactDetailsRepository;
	private Iterable<Integer> id;

	public Contact save(Contact contact) {

		return contactRepository.save(contact);

	}

	public Contact getContact(int id) {
		Optional<Contact> result = contactRepository.findById(id);
		Contact contact = null;
		if (result.isPresent()) {
			contact = result.get();
		}

		return contact;
	}

	public void save(ContactDetails contactDetails) {

		contactDetailsRepository.save(contactDetails);

	}

	public List<ContactDetails> getdetails() {

		List<ContactDetails> details = contactDetailsRepository.findAll();
		return details;
	}

//add the list of details in the database 
	public void addContactdetails(List<ContactDetails> contactDetails) {
		contactDetailsRepository.saveAll(contactDetails);

	}

//fetching the data from database by id
	public ContactDetails getContactDetailById(int id) {
		Optional<ContactDetails> result = contactDetailsRepository.findById(id);
		ContactDetails cds = null;
		if (result.isPresent()) {
			cds = result.get();
		}

		return cds;
	}

	// updating data in the database
	public void update(Contact contact) {
		contactRepository.save(contact);

	}

	public List<ContactDetails> getDetailsById(int id) {
		List<ContactDetails> list = contactDetailsRepository.findByContactId(id);
		List<ContactDetails> result = new ArrayList<ContactDetails>();
		result.addAll(list);

		return result;

	}

}
