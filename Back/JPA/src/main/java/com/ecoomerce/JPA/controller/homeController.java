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
import com.ecoomerce.JPA.entitys.Product;
import com.ecoomerce.JPA.entitys.ShoppingCar;
import com.ecoomerce.JPA.repositories.CategoriaRepository;
import com.ecoomerce.JPA.services.impl.ProductsServices;
import com.ecoomerce.JPA.utils.ProductForList;
import com.ecoomerce.JPA.utils.detailResponse;

@CrossOrigin(origins = {"http://localhost:8080","http://localhost:4200/"})
@RestController
@RequestMapping("/home")
public class homeController {

	ProductsServices productos;
	CategoriaRepository categorias;

	public homeController(ProductsServices productos, CategoriaRepository categorias) {
		super();
		this.productos = productos;
		this.categorias = categorias;
	}

	@GetMapping("/list/{gender}")
	public ResponseEntity<List<ProductForList>> productosPorGenero(@PathVariable("gender") String bySex) {
		try {
			return new ResponseEntity<List<ProductForList>>(productos.getList(bySex), HttpStatus.OK);
		}catch(Exception e ){
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}

//	@GetMapping("list/categories")
//	public ResponseEntity<List<Category>> enviarCategorias(){
//		List<Category> CategoriesList = new ArrayList<Category>();
//		try {
//			categorias.findAll().forEach(CategoriesList::add);
//			return new ResponseEntity<List<Category>>(CategoriesList, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<List<Category>>(CategoriesList, HttpStatus.NO_CONTENT);
//		}
//	}
	
	 @PostMapping ("cart")
	 public ResponseEntity<Boolean> productDetailA(@RequestBody ShoppingCar carItem){ 
		 try { 
			Boolean resultado = productos.saveCarItem(carItem); 
		 	return new ResponseEntity<Boolean>(resultado, HttpStatus.OK); 
		 }catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		 } 
	}

	@PostMapping("product/detail")
	public ResponseEntity<detailResponse> productDetail(@RequestBody int product){
		try {
			detailResponse response =  productos.getProductDetail(product);
			return new ResponseEntity<detailResponse>(response, HttpStatus.OK);
		}catch (Exception e){
			System.out.println(e.getMessage());
			return new ResponseEntity<detailResponse>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("products/names/{aBuscar}")
	public ResponseEntity<List<Product>> ObtenernombreProductos(@PathVariable ("aBuscar") String aBuscar){
		try {
			return new ResponseEntity<List<Product>>(productos.searchBarProcess(aBuscar), HttpStatus.OK);
		}catch (Exception e){
			System.out.println(e.getMessage());
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("prodcuts/mostSelling")
	public ResponseEntity<List<Product>> getMostSellingProducts(){
		try {
			return new ResponseEntity<List<Product>>(productos.MostSellingBanner(), HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}