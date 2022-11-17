package com.Project.Contact.Processing.ProjectContactDemo.Contact;

import java.util.List;

public class Response {
	
	private String status;
	private String exception_code;
	private String exception_message;
	private Report report;
	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getException_code() {
		return exception_code;
	}

	public void setException_code(String exception_code) {
		this.exception_code = exception_code;
	}

	public String getException_message() {
		return exception_message;
	}

	public void setException_message(String exception_message) {
		this.exception_message = exception_message;
	}

	public Response() {

	}

}
