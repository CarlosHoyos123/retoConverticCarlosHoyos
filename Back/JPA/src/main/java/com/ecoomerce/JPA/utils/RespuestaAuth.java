package com.ecoomerce.JPA.utils;

import com.ecoomerce.JPA.entitys.Client;
import com.ecoomerce.JPA.entitys.InvoiceAdress;
import com.ecoomerce.JPA.entitys.AdressToSend;

public class RespuestaAuth {
	
	private Boolean state;
	private String text;
	private String type;
	private Client client;
	private InvoiceAdress invoiceAdress;
	private AdressToSend sendAdress;
	
	public RespuestaAuth() {
		
	}

	public RespuestaAuth(Boolean state, String text, String type, Client cliente, InvoiceAdress invoiceAdress,
			AdressToSend sendAdress) {
		super();
		this.state = state;
		this.text = text;
		this.type = type;
		this.client = cliente;
		this.invoiceAdress = invoiceAdress;
		this.sendAdress = sendAdress;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client cliente) {
		this.client = cliente;
	}

	public InvoiceAdress getInvoiceAdress() {
		return invoiceAdress;
	}

	public void setInvoiceAdress(InvoiceAdress invoiceAdress) {
		this.invoiceAdress = invoiceAdress;
	}

	public AdressToSend getSendAdress() {
		return sendAdress;
	}

	public void setSendAdress(AdressToSend sendAdress) {
		this.sendAdress = sendAdress;
	}

	@Override
	public String toString() {
		return "RespuestaAuth [state=" + state + ", text=" + text + ", type=" + type + ", cliente=" + client
				+ ", invoiceAdress=" + invoiceAdress + ", sendAdress=" + sendAdress + "]";
	}
}
