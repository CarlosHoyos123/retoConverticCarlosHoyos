package com.ecoomerce.JPA.utils;

import com.ecoomerce.JPA.entitys.Client;

public class UserCreateResponse {

	private String description;
	private Client client;
	
	public UserCreateResponse(String description, Client client) {
		super();
		this.description = description;
		this.client = client;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "UserCreateResponse [description=" + description + ", client=" + client + "]";
	}
}
