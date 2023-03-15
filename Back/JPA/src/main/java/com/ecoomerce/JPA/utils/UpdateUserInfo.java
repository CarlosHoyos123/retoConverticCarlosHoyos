package com.ecoomerce.JPA.utils;

import com.ecoomerce.JPA.entitys.AdressToSend;
import com.ecoomerce.JPA.entitys.Client;
import com.ecoomerce.JPA.entitys.InvoiceAdress;

public class UpdateUserInfo {
	
	private Client client;
	private AdressToSend adresstosend;
	private InvoiceAdress adressToInvoice;
	
	public UpdateUserInfo(Client client, AdressToSend adresstosend, InvoiceAdress adressToInvoice) {
		super();
		this.client = client;
		this.adresstosend = adresstosend;
		this.adressToInvoice = adressToInvoice;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public AdressToSend getAdresstosend() {
		return adresstosend;
	}
	public void setAdresstosend(AdressToSend adresstosend) {
		this.adresstosend = adresstosend;
	}
	public InvoiceAdress getAdressToInvoice() {
		return adressToInvoice;
	}
	public void setAdressToInvoice(InvoiceAdress adressToInvoice) {
		this.adressToInvoice = adressToInvoice;
	}
	
	@Override
	public String toString() {
		return "updateUserInfo [client=" + client + ", adresstosend=" + adresstosend + ", adressToInvoice="
				+ adressToInvoice + "]";
	}
}
