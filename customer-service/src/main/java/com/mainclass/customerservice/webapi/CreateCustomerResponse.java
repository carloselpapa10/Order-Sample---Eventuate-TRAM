package com.mainclass.customerservice.webapi;

public class CreateCustomerResponse {

	private String id;
	
	public CreateCustomerResponse() {
	}

	public CreateCustomerResponse(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
