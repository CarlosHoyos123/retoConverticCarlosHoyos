package com.ecoomerce.JPA.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecoomerce.JPA.entitys.ShoppingCar;
import com.ecoomerce.JPA.services.impl.ShoppingCarServices;
import com.ecoomerce.JPA.utils.CarGridResponse;
import com.ecoomerce.JPA.utils.ConfirmBuy;

@CrossOrigin(origins = {"http://localhost:8090","http://localhost:4200/"})
@RestController
@RequestMapping("/car")
public class carController {

	ShoppingCarServices shoppingCarServices;
	
	public carController(ShoppingCarServices shoppingCarServices) {
		super();
		this.shoppingCarServices = shoppingCarServices;
	}

	@GetMapping("myCar/{client}")
	public ResponseEntity<List<CarGridResponse>> savedItemsByUser(@PathVariable("client") int client){
		List<CarGridResponse> savedItems = shoppingCarServices.itemsByUser(client); 
		try {
			return new ResponseEntity<List<CarGridResponse>>(savedItems, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<List<CarGridResponse>>(HttpStatus.NO_CONTENT);
		}
	}

	 @PostMapping ("addItem")
	 public ResponseEntity<ShoppingCar> saveItem(@RequestBody ShoppingCar carItem){ 
		 try { 
		 	ShoppingCar resultado = shoppingCarServices.saveItem(carItem);
			return new ResponseEntity<ShoppingCar>(resultado , HttpStatus.OK); 
		 }catch(Exception e) { 
				System.out.println(e.getMessage());
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		 } 
	}
 
	 @PostMapping ("removeItem")
	 public ResponseEntity<CarGridResponse> removeItem(@RequestBody CarGridResponse carItem){ 
		 try { 
			CarGridResponse resultado = shoppingCarServices.deleteitemByUser(carItem);
			return new ResponseEntity<CarGridResponse>(resultado , HttpStatus.OK); 
		 }catch(Exception e) { 
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		 } 
	}
	 
	 @PostMapping("carConfirm")
	 public ResponseEntity<ConfirmBuy> confirmSell(@RequestBody ConfirmBuy info){
		 System.out.println(info.toString());
		 try {
			 ConfirmBuy response = shoppingCarServices.confirmProcess(info);
			 return new ResponseEntity<ConfirmBuy>(response, HttpStatus.OK);
		 }catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	 }
}
