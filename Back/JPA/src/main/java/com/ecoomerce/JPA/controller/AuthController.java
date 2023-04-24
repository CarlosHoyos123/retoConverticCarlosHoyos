package com.ecoomerce.JPA.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecoomerce.JPA.entitys.Client;
import com.ecoomerce.JPA.services.impl.ClientsServices;
import com.ecoomerce.JPA.services.impl.FormsServices;
import com.ecoomerce.JPA.utils.FormsInfo;
import com.ecoomerce.JPA.utils.Login;
import com.ecoomerce.JPA.utils.RespuestaAuth;
import com.ecoomerce.JPA.utils.UpdateUserInfo;
import com.ecoomerce.JPA.utils.UserCreateResponse;

@CrossOrigin(origins = {"http://localhost:8080","http://localhost:4200/"})
@RestController
@RequestMapping("/Auth")
public class AuthController {

	ClientsServices clientsServices;
	FormsServices formulariesServices;

	public AuthController(ClientsServices clientsServices, FormsServices formulariesServices) {
		super();
		this.clientsServices = clientsServices;
		this.formulariesServices = formulariesServices;
	}

	@GetMapping("/formConfig")
	public ResponseEntity<FormsInfo> formsRepo(){
		try {
			return new ResponseEntity<FormsInfo>(formulariesServices.findAllItems(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<FormsInfo>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PostMapping("/user")
	public ResponseEntity<RespuestaAuth> Auth(@RequestBody Login user) {
		try {
			return new ResponseEntity<RespuestaAuth>(clientsServices.verificarUsuario(user), HttpStatus.OK);
		}catch(Exception e){
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<UserCreateResponse> guardarNuevoUsuario(@RequestBody Client newClient) {
		try {
			return new ResponseEntity<UserCreateResponse>(clientsServices.saveNewClient(newClient), HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PostMapping("/update")
	public ResponseEntity<UserCreateResponse> ActualizarUsuario(@RequestBody UpdateUserInfo Client) {
		try {
			return new ResponseEntity<UserCreateResponse>(clientsServices.updateClient(Client), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
