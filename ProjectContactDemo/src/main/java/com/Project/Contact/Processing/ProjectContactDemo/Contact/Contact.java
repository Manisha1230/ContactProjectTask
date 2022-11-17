package com.Project.Contact.Processing.ProjectContactDemo.Contact;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "integrationIdentifier")
	private String integrationIdentifier;
	
	
	@OneToMany(mappedBy ="contact")
	@JsonIgnore
	private List<ContactDetails> contactDetails = new ArrayList<ContactDetails>();



	public List<ContactDetails> getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(List<ContactDetails> contactDetails) {
		this.contactDetails = contactDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntegrationIdentifier() {
		return integrationIdentifier;
	}

	public void setIntegrationIdentifier(String integrationIdentifier) {
		this.integrationIdentifier = integrationIdentifier;
	}

	public Contact(int id, String name, String integrationIdentifier) {

		this.name = name;
		this.integrationIdentifier = integrationIdentifier;
	}

	public Contact() {

	}

	@Override
	public String toString() {
		return "Contact [Id=" + id + ", name=" + name + ", integrationIdentifier=" + integrationIdentifier + "]";
	}

}
