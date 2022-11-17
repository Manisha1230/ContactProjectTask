package com.Project.Contact.Processing.ProjectContactDemo.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Contact.Processing.ProjectContactDemo.Contact.Contact;
import com.Project.Contact.Processing.ProjectContactDemo.Contact.ContactDetails;
import com.Project.Contact.Processing.ProjectContactDemo.Contact.Report;
import com.Project.Contact.Processing.ProjectContactDemo.Contact.Response;
import com.Project.Contact.Processing.ProjectContactDemo.Service.ServiceClass;

@RestController
@RequestMapping(value = "/enrich")
public class ContactController {
	@Autowired
	private ServiceClass serviceclass;

	// Endpoint: http://localhost:8888/enrich/create
	@PostMapping("/create")
	public Contact addContact(@RequestBody Contact contact) {
		Contact response = serviceclass.save(contact);
		return response;

	}

	// Endpoint - http://localhost:8888/enrich/contact/add
	@PostMapping("/contact/add/{id}")
	public void addContactDetails(@RequestBody ContactDetails contactDetails, @PathVariable int id) {

		Contact contact = serviceclass.getContact(id);
		if (contact != null) {
			contactDetails.setContact(contact);

			serviceclass.save(contactDetails);
		} else {
			throw new RuntimeException("Did not find contact with this-" + id + " to set in contact field");
		}
	}

	// Endpoint - http://localhost:8888/enrich/contact/startAnalysis/<id>
	@PostMapping("/contact/startAnalysis/{id}")
	public String updateContactDetails(@PathVariable int id) {
		List<ContactDetails> ContactDetailslist = serviceclass.getDetailsById(id);
		List<ContactDetails> finalDetails = new ArrayList<>();
		for (ContactDetails contactDetails : ContactDetailslist) {
			if (contactDetails.isIsProcessed() == false) {
				contactDetails.setIsProcessed(true);
				contactDetails.setCompletionDate(new Date());
				int ageDetails = contactDetails.getAge();
				if (ageDetails >= 18) {
					contactDetails.setIsAdult(true);
				} else {
					contactDetails.setIsAdult(false);
				}
				finalDetails.add(contactDetails);
			} else {
				return "Task - Analysis started, you cannot add more data, please create a new Enrichment Task";
			}
		}
		serviceclass.addContactdetails(finalDetails);
		return "status: completed";

	}

	@GetMapping("/contact/get")
	public List<ContactDetails> getContactDetails() {
		List<ContactDetails> detail = serviceclass.getdetails();
		return detail;
	}

	// Endpoints - http://localhost:8080/enrich/contact/add/<id>
	@PostMapping("/contact/addList/{id}")
	public String addContactDetailsList(@RequestBody List<ContactDetails> contactDetails, @PathVariable int id) {
		List<ContactDetails> ContactDetailslist = serviceclass.getDetailsById(id);
		List<ContactDetails> finalcontactDetails = new ArrayList<ContactDetails>();
		boolean status = false;
		for (ContactDetails existingDetails : ContactDetailslist) {
			if (existingDetails.isIsProcessed()) {
				status = true;
				break;
			}
		}
		if (!status) {
			Contact contact = serviceclass.getContact(id);

			for (ContactDetails cds : contactDetails) {

				if (contact != null) {
					cds.setContact(contact);
				} else {
					throw new RuntimeException(
							"Did not find contact with this-" + cds.getId() + " to set in contact field");
				}
				finalcontactDetails.add(cds);
			}
		} else {
			return "Task - Analysis started, you cannot add more data, please create a new Enrichment Task";
		}
		serviceclass.addContactdetails(finalcontactDetails);
		return "";

	}

//3.Report API
	@GetMapping("/report/{id}")
	public Response detailsById(@PathVariable int id) {
		List<ContactDetails> list = serviceclass.getDetailsById(id);
		Response response = new Response();
		Report report = new Report();
		List<String> names = new ArrayList<String>();
		int count = 0;
		if (list != null) {
			for (ContactDetails cds : list) {
				if (cds.getIsAdult()) {
					count++;
					names.add(cds.getFirstName() + " " + cds.getLastName());
				}
			}

			report.setNoOfAdults(count);
			report.setNameOfAdults(names);

		}
		response.setReport(report);
		response.setStatus("Completed");
		return response;

	}
}
