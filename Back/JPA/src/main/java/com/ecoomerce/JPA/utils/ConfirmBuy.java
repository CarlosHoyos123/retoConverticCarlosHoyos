package com.ecoomerce.JPA.utils;

import java.util.List;

import com.ecoomerce.JPA.entitys.Invoice;
import com.ecoomerce.JPA.entitys.InvoiceDetail;

public class ConfirmBuy {

	private Invoice invoice;
	private List<InvoiceDetail> invoiceDetail;
	private List<CarGridResponse> car;
	
	public ConfirmBuy(Invoice invoice, List<InvoiceDetail> invoiceDetail, List<CarGridResponse> car) {
		super();
		this.invoice = invoice;
		this.invoiceDetail = invoiceDetail;
		this.car = car;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public List<InvoiceDetail> getInvoiceDetail() {
		return invoiceDetail;
	}
	public void setInvoiceDetail(List<InvoiceDetail> invoiceDetail) {
		this.invoiceDetail = invoiceDetail;
	}
	public List<CarGridResponse> getCar() {
		return car;
	}
	public void setCar(List<CarGridResponse> car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "ConfirmBuy [invoice=" + invoice + ", invoiceDetail=" + invoiceDetail + ", car=" + car + "]";
	}
}
