package com.ecoomerce.JPA.services.impl;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.ecoomerce.JPA.entitys.AdressToSend;
import com.ecoomerce.JPA.entitys.Client;
import com.ecoomerce.JPA.entitys.InvoiceAdress;
import com.ecoomerce.JPA.repositories.AdressToSendRepository;
import com.ecoomerce.JPA.repositories.ClientesRepository;
import com.ecoomerce.JPA.repositories.InvoiceAdressRepository;
import com.ecoomerce.JPA.utils.Login;
import com.ecoomerce.JPA.utils.RespuestaAuth;
import com.ecoomerce.JPA.utils.UpdateUserInfo;
import com.ecoomerce.JPA.utils.UserCreateResponse;

@Service
public class ClientsServices {
	
	ClientesRepository clientesRepository;
	AdressToSendRepository adressToSendRepository;
	InvoiceAdressRepository invoiceAdressRepository;

	public ClientsServices(ClientesRepository clientesRepository, AdressToSendRepository adressToSendRepository,
			InvoiceAdressRepository invoiceAdressRepository) {
		super();
		this.clientesRepository = clientesRepository;
		this.adressToSendRepository = adressToSendRepository;
		this.invoiceAdressRepository = invoiceAdressRepository;
	}

	public UserCreateResponse saveNewClient(Client client) {
		UserCreateResponse response = new UserCreateResponse("", client); 
		try {
			Client newClient = clientesRepository.save(client);
			AdressToSend emptyForCreationSendAdress = new AdressToSend("", "", newClient.getCliente(), newClient.getPais().getId());
			InvoiceAdress emptyForCreationInvoiceAdress = new InvoiceAdress("", "", newClient.getCliente(), newClient.getPais().getId());
			adressToSendRepository.save(emptyForCreationSendAdress);
			invoiceAdressRepository.save(emptyForCreationInvoiceAdress);
			response.setDescription("User created");
			return response;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			if(e instanceof SQLException) {
				SQLException sqe = (SQLException) e;
				if(sqe.getSQLState() == "23505") {
					response.setDescription("Usuario o numero ya estan registrados");
					return response;
				}
			}
			response.setDescription("Error");
			return response;
		}		
	}
	
	public RespuestaAuth verificarUsuario(Login user) {
		RespuestaAuth respuesta = new RespuestaAuth();
		com.ecoomerce.JPA.entitys.Client client = clientesRepository.findByEmail(user.getCorreo());
		if(client == null)
			System.out.println("La busqeda es nula");
		if (client.getContrasenia().equals(user.getClave())) {
			respuesta.setClient(client);
			respuesta.setState(true);
			respuesta.setText("Logeo exitoso.");
			respuesta.setInvoiceAdress(invoiceAdressRepository.findByCliente(client.getCliente()));
			respuesta.setSendAdress(adressToSendRepository.findByCliente(client.getCliente()));
			return respuesta;
		}else {
			respuesta.setClient(null);
			respuesta.setState(false);
			respuesta.setText("Nombre y usuario no son validos.");
			return respuesta;
		}
	}

	public UserCreateResponse updateClient(UpdateUserInfo client) {
		UserCreateResponse response = new UserCreateResponse("", client.getClient()); 
		try {
			clientesRepository.save(client.getClient());
			invoiceAdressRepository.save(client.getAdressToInvoice());
			adressToSendRepository.save(client.getAdresstosend());
			response.setDescription("User updated");
			return response;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			response.setDescription("Error");
			return response;
		}
	}
}
