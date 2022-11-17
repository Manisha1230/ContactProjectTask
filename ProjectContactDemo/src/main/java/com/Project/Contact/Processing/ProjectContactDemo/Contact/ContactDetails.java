package com.Project.Contact.Processing.ProjectContactDemo.Contact;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity(name = "rawContactsList")
public class ContactDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@ManyToOne
	private Contact contact;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="age")
	private int age;
	
	@Column(name="IsProcessed")
	private boolean IsProcessed=false;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	@Column(name="creatingDate")
	private Date creatingDate;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	@Column(name="completionDate")
	private Date completionDate;
	@Column(name="IsAdult")
	private boolean isAdult=false;
	
	
	public boolean getIsAdult() {
		return isAdult;
	}
	public void setIsAdult(boolean isAdult) {
		this.isAdult = isAdult;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isIsProcessed() {
		return IsProcessed;
	}
	public void setIsProcessed(boolean isProcessed) {
		IsProcessed = isProcessed;
	}
	public Date getCreatingDate() {
		return creatingDate;
	}
	public void setCreatingDate(Date creatingDate) {
		this.creatingDate = creatingDate;
	}
	public Date getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}
	public ContactDetails(int id,String firstName, String lastName, int age, boolean isProcessed,
			Date creatingDate, Date completionDate ,boolean isAdult) {
	
		this.id = id;
	    this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		IsProcessed = isProcessed;
		this.creatingDate = creatingDate;
		this.completionDate = completionDate;
		this.isAdult = isAdult;
	}
	public ContactDetails() {
		
	}
	@JsonProperty("ContactId")
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "ContactDetails [id=" + id + ", contact=" + contact + ", firstName=" + firstName + ", lastName="
				+ lastName + ", age=" + age + ", IsProcessed=" + IsProcessed + ", creatingDate=" + creatingDate
				+ ", completionDate=" + completionDate + ", isAdult=" + isAdult + "]";
	}
	
	

}
