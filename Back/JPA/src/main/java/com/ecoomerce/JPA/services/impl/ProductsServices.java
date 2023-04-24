package com.ecoomerce.JPA.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecoomerce.JPA.entitys.Color;
import com.ecoomerce.JPA.entitys.Fabricante;
import com.ecoomerce.JPA.entitys.Product;
import com.ecoomerce.JPA.entitys.QuantityAvailable;
import com.ecoomerce.JPA.entitys.ShoppingCar;
import com.ecoomerce.JPA.entitys.Size;
import com.ecoomerce.JPA.repositories.ColorRepository;
import com.ecoomerce.JPA.repositories.FabricanteRepository;
import com.ecoomerce.JPA.repositories.ProductsRepository;
import com.ecoomerce.JPA.repositories.QuantityAvailableRepository;
import com.ecoomerce.JPA.repositories.ShoppingCartRepository;
import com.ecoomerce.JPA.repositories.SizeRepository;
import com.ecoomerce.JPA.utils.ProductDetailed;
import com.ecoomerce.JPA.utils.ProductForList;
import com.ecoomerce.JPA.utils.detailResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;


@Service
public class ProductsServices {

	ProductsRepository productosRepository;
	QuantityAvailableRepository quantityAvailableRepository;
	SizeRepository sizeRepository;
	ColorRepository colorRepository;
	FabricanteRepository fabricanteRepository;
	ShoppingCartRepository shoppingCartRepository;
	
	@PersistenceContext
	public EntityManager manager;		

	public ProductsServices(ProductsRepository productosRepository,
			QuantityAvailableRepository quantityAvailableRepository, SizeRepository sizeRepository,
			ColorRepository colorRepository, FabricanteRepository fabricanteRepository,
			ShoppingCartRepository shoppingCartRepository, EntityManager manager) {
		super();
		this.productosRepository = productosRepository;
		this.quantityAvailableRepository = quantityAvailableRepository;
		this.sizeRepository = sizeRepository;
		this.colorRepository = colorRepository;
		this.fabricanteRepository = fabricanteRepository;
		this.shoppingCartRepository = shoppingCartRepository;
		this.manager = manager;
	}

	public List<ProductForList> getList(String bySex) {
		List<ProductForList> ProductsList= new ArrayList<ProductForList>();
		if(bySex.equals("man")) {
			productsByGender(1).forEach(ProductsList::add);
		}else if (bySex.equals("woman")) {
			productsByGender(2).forEach(ProductsList::add);
		}
		return ProductsList;
	}
		
	public List<ProductForList> productsByGender(int gender){
		List<ProductForList> ProductsList = new ArrayList<ProductForList>();
		Iterable<Product> productosCompletos =  productosRepository.findByGenero(gender);
		for (Product producto : productosCompletos) {
			ProductForList productoLista = new ProductForList();
			productoLista.setId(producto.getId()); 
			productoLista.setPlu(producto.getPlu());
			productoLista.setProducto(producto.getProducto()); 
			productoLista.setPrecio(producto.getPrecio());
			productoLista.setDescripcion(producto.getDescripcion());
			productoLista.setGenero(producto.getGenero());
			productoLista.setRutaFoto(producto.getRutaFoto());
			ProductsList.add(productoLista);
		}
		return ProductsList;
	}

	public List<Product> MostSellingBanner(){
		List<Product> mostSelling =  (List<Product>) productosRepository.findFirst4ByOrderByBusquedasDesc();
		return mostSelling;
	}
	
	public Boolean saveCarItem(ShoppingCar carItem) {
		try {
			shoppingCartRepository.save(carItem);
			return true;
		}catch (Exception e) {
			return false;
		} 
	}
	 
	public detailResponse getProductDetail(int producto) {
		List<QuantityAvailable> StockAvailable = (List<QuantityAvailable>) quantityAvailableRepository.findByProducto(producto);
		List<Size> sizesAvailable = new ArrayList<Size>();
		List<Color> colorsAvailable = new ArrayList<Color>();
		ProductDetailed productInfo = informacionProducto(producto);
		boolean bandera = true;
		for (QuantityAvailable stock : StockAvailable) {
			Size size = sizeRepository.findById((long) stock.getTalla()).orElseThrow();
			Color color = colorRepository.findById(stock.getColor()).orElseThrow();
			if(bandera){
				//Esta bandera agrega un primer registro para las siguientes comparaciones y evitar registros duplicados
				sizesAvailable.add(size);
				colorsAvailable.add(color);
			}
			bandera = false;
			if(!sizesAvailable.contains(size)) {
				sizesAvailable.add(size);
			}
			if(!colorsAvailable.contains(color)) {
				colorsAvailable.add(color);
			}
		}
		detailResponse fullInformation = new detailResponse(StockAvailable, colorsAvailable, sizesAvailable, productInfo);
		return fullInformation;
	}
	
	public ProductDetailed informacionProducto(int idProducto){
		ProductDetailed productDetailed= new ProductDetailed();
		Product fullProducto = productosRepository.findById((long) idProducto).orElseThrow();
		int busquedas = fullProducto.getBusquedas();
		busquedas++;
		fullProducto.setBusquedas(busquedas);
		productosRepository.save(fullProducto);
		Fabricante fabricanteProducto = fabricanteRepository.findById((long) fullProducto.getFabricante()).orElseThrow();
		productDetailed.setNombre(fullProducto.getProducto());
		productDetailed.setPlu(fullProducto.getPlu());
		productDetailed.setPrecio(fullProducto.getPrecio());
		productDetailed.setDescripcion(fullProducto.getDescripcion());
		productDetailed.setFabricante(fabricanteProducto.getNombre());
		productDetailed.setRutaFoto(fullProducto.getRutaFoto());
		return productDetailed;
	}
	
	public List<String> obtenerlistaNombreProductos() {
		ArrayList<String> listaNombresProductos = new ArrayList<>();
		Iterable<Product> listaProductos = productosRepository.findAll();
		for (Product producto : listaProductos) {
			listaNombresProductos.add(producto.getProducto());
		}
		return listaNombresProductos;
	}

	public List<Product> searchBarProcess(String cadena) {
		try
		{
			StoredProcedureQuery storedProcedure = manager.createNamedStoredProcedureQuery("filtrarresultados");
			System.out.println(cadena);
			storedProcedure.setParameter("aBuscar", cadena);			
			storedProcedure.execute();
			@SuppressWarnings("unchecked")
			List<Product>  resultados = storedProcedure.getResultList();
			return resultados;
		}
		catch (Exception e) {
			System.out.println("exepcion");
			e.printStackTrace();
			return null;
		}
	}
}
