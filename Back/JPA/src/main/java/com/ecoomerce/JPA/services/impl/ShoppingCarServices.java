package com.ecoomerce.JPA.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.ecoomerce.JPA.entitys.*;
import com.ecoomerce.JPA.repositories.*;
import org.springframework.stereotype.Service;

import com.ecoomerce.JPA.utils.CarGridResponse;
import com.ecoomerce.JPA.utils.ConfirmBuy;

import jakarta.transaction.Transactional;

@Service
public class ShoppingCarServices {

	private ShoppingCartRepository shoppingCartRepository;
	private ColorRepository colorRepository;
	private SizeRepository sizeRepository;
	private ProductsRepository productosRepository;
	private InvoiceRepository invoiceRepository;
	private InvoiceDetailRepository invoiceDetailRepository;
	private QuantityAvailableRepository quantityAvailableRepository;

	private ClientesRepository clientesRepository;

	public ShoppingCarServices(ShoppingCartRepository shoppingCartRepository, ColorRepository colorRepository, SizeRepository sizeRepository, ProductsRepository productosRepository, InvoiceRepository invoiceRepository, InvoiceDetailRepository invoiceDetailRepository, QuantityAvailableRepository quantityAvailableRepository, ClientesRepository clientesRepository) {
		this.shoppingCartRepository = shoppingCartRepository;
		this.colorRepository = colorRepository;
		this.sizeRepository = sizeRepository;
		this.productosRepository = productosRepository;
		this.invoiceRepository = invoiceRepository;
		this.invoiceDetailRepository = invoiceDetailRepository;
		this.quantityAvailableRepository = quantityAvailableRepository;
		this.clientesRepository = clientesRepository;
	}
	public List<CarGridResponse> itemsByUser(int client) {
		List<CarGridResponse> response = new ArrayList<CarGridResponse>();
		List<ShoppingCar> items = shoppingCartRepository.findByCliente(client);
		for (ShoppingCar item : items) {
			try {
				CarGridResponse information = new CarGridResponse(item.getId(), null, null, null, item.getCantidad());
				information.setColor(colorRepository.findById(item.getColor()).orElseThrow(() -> new NullPointerException("Product not found")));
				information.setTalla(sizeRepository.findById((long) item.getTalla()).orElseThrow(() -> new NullPointerException("Product not found")));
				information.setProducto(productosRepository.findById((long) item.getProducto()).orElseThrow(() -> new NullPointerException("Product not found")));
				response.add(information);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return response;
	}

	@Transactional
	public Client deleteCarByUser(Client client) {
		try {
			shoppingCartRepository.deleteByCliente(client.getCliente());
			return client;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public CarGridResponse deleteitemByUser(CarGridResponse carItem) {
		try {
			shoppingCartRepository.deleteById((long) carItem.getIdCar());
			return carItem;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public ShoppingCar saveItem(ShoppingCar item) {
		try {
			return shoppingCartRepository.save(item);
		} catch (Exception e) {
			return null;
		}
	}

	public Invoice saveInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

	public List<InvoiceDetail> saveDetail(List<CarGridResponse> invoiceDetail, Invoice invoiceSaved) {
		List<InvoiceDetail> savedDetail = new ArrayList<InvoiceDetail>();
		for (CarGridResponse invoice : invoiceDetail) {
			InvoiceDetail detail = new InvoiceDetail();
			detail.setFactura(invoiceSaved.getId());
			detail.setCantidad(invoice.getCantidad());
			detail.setProducto(invoice.getProducto().getId());
			detail.setColor(invoice.getColor().getId());
			detail.setTalla(invoice.getTalla().getId());
			Product productInfo = productosRepository.findById((long) invoice.getProducto().getId()).orElseThrow();
			double precio = productInfo.getPrecio();
			float total = (float) (precio * invoice.getCantidad());
			detail.setTotal(total);
			InvoiceDetail result = invoiceDetailRepository.save(detail);
			savedDetail.add(result);
		}
		return savedDetail;
	}

	@Transactional
	public ConfirmBuy confirmProcess(ConfirmBuy info) {
		List<CarGridResponse> clientCar = itemsByUser(info.getInvoice().getCliente());
		float total = 0;
		Invoice result = saveInvoice(info.getInvoice());
		List<InvoiceDetail> resultDetail = saveDetail(clientCar, result);
		for (InvoiceDetail oneDetail : resultDetail) {
			total += oneDetail.getTotal();
			QuantityAvailable productAvailable = quantityAvailableRepository.findByProductoAndColorAndTalla(oneDetail.getProducto(), oneDetail.getColor(), oneDetail.getTalla());
			productAvailable.setCantidad(productAvailable.getCantidad()-oneDetail.getCantidad());
			quantityAvailableRepository.save(productAvailable);
		}
		result.setTotal(total);
		Invoice savedInovice = saveInvoice(result);
		deleteCarByUser(clientesRepository.findById((long) info.getInvoice().getCliente()).orElseThrow());
		ConfirmBuy response = new ConfirmBuy(savedInovice, resultDetail, null);


//		 Google announced that 
//		 On May 30 2022 Google will no longer support the use of third-party apps or devices which ask you to sign in to your
//		 Google Account using only your username and password. Instead, you’ll need to sign in using Sign in with Google or 
//		 other more secure technologies, like OAuth 2.0. Learn more.
//		 try {
//			emailService.send("chrodriguez.bmdc@gmail.com", "chrodriguez.bmdc@gmail.com", "desde Java", "Este es un correo de prueba desde e-commerce ConverTIC");
//		}catch (Exception e) {
//			System.out.println(e.getCause());
//		}
		return response;

	}
}
