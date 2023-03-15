package com.ecoomerce.JPA.utils;

import java.util.List;

import com.ecoomerce.JPA.entitys.Country;
import com.ecoomerce.JPA.entitys.IdType;
import com.ecoomerce.JPA.entitys.PhoneType;

public class FormsInfo {

	private List<IdType> documents;
	private List<Country> countries;
	private List<PhoneType> phones;
	
	public FormsInfo(List<IdType> documents, List<Country> countries, List<PhoneType> phones) {
		super();
		this.documents = documents;
		this.countries = countries;
		this.phones = phones;
	}
	public List<IdType> getDocuments() {
		return documents;
	}
	public void setDocuments(List<IdType> documents) {
		this.documents = documents;
	}
	public List<Country> getCountries() {
		return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	public List<PhoneType> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneType> phones) {
		this.phones = phones;
	}
	@Override
	public String toString() {
		return "FormsInfo [documents=" + documents + ", countries=" + countries + ", phones=" + phones + "]";
	}
}
