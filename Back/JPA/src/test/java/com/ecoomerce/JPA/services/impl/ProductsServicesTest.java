package com.ecoomerce.JPA.services.impl;

import static com.ecoomerce.JPA.datosEjemplo.Datos.*;

import com.ecoomerce.JPA.entitys.Product;
import com.ecoomerce.JPA.entitys.ShoppingCar;
import com.ecoomerce.JPA.repositories.*;
import com.ecoomerce.JPA.utils.ProductDetailed;
import com.ecoomerce.JPA.utils.ProductForList;
import com.ecoomerce.JPA.utils.detailResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


@SpringBootTest
@ActiveProfiles("test")
class ProductsServicesTest {
    @MockBean
    ProductsRepository productosRepository;
    @MockBean
    QuantityAvailableRepository quantityAvailableRepository;
    @MockBean
    SizeRepository sizeRepository;
    @MockBean
    ColorRepository colorRepository;
    @MockBean
    FabricanteRepository fabricanteRepository;
    @MockBean
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    ProductsServices productsServices;

    /*@Test
    void getListTest() {
        //Given
        when(productsServices.productsByGender(any())).thenReturn(listaProdGender());
        when(productosRepository.findByGenero(any())).thenReturn(listaProductos());
        //When
        List<ProductForList> response =  productsServices.getList("man");
        //Then
        assertNotNull(response);
    }*/

    @Test
    void productsByGenderTest() {
        //Given
            when(productosRepository.findByGenero(anyInt())).thenReturn(listaProductos());
        //When
            List<ProductForList> response =  productsServices.productsByGender(anyInt());
        //Then
        assertNotNull(response);
        assertEquals(response.size(),2);
    }

    @Test
    void mostSellingBannerTest() {
        //Given
        when(productosRepository.findFirst4ByOrderByBusquedasDesc()).thenReturn(listaProductos());
        //When
        List<Product> response = productsServices.MostSellingBanner();
        //Then
    assertNotNull(response);
    assertEquals(response.size(),2);
    }

    @Test
    void saveCarItemTest() {
        //Given
        when(shoppingCartRepository.save(any(ShoppingCar.class))).thenReturn(crearCar());
        //When
        ShoppingCar response = productsServices.saveCarItem(crearCar());
        //Then
        assertNotNull(response);
        assertEquals(response.getId(),1);
    }

    /*@Test
    void getProductDetailTest() {
        //Given
        when(quantityAvailableRepository.findByProducto(anyInt())).thenReturn(listaQuantity());
        when(colorRepository.findById(anyInt())).thenReturn(Optional.of(crearColor()));
        when(sizeRepository.findById(anyLong())).thenReturn(Optional.of(crearSize()));
        when(productsServices.informacionProducto(anyInt())).thenReturn(crearProdDetail());
        //When
        //detailResponse response = productsServices.getProductDetail(anyInt());
        //Then
        //assertEquals(response.getColorsAvailable(),3);

    }*/

    @Test
    void informacionProductoTest() {
        //Given
        when(productosRepository.findById(anyLong())).thenReturn(Optional.of(crearProduct()));
       // when(productosRepository.save(any(Product.class))).thenReturn();
        when(fabricanteRepository.findById(anyLong())).thenReturn(Optional.of(crearFabricante()));
        //When
        ProductDetailed response = productsServices.informacionProducto(anyInt());
        //Then
        assertNotNull(response);
        assertEquals(response.getFabricante(),"nombre");
        assertEquals(response.getDescripcion(),"descripcionEjemplo");
    }

    @Test
    void obtenerlistaNombreProductosTest() {
        //Given

        //When

        //Then

    }

    @Test
    void searchBarProcessTest() {
        //Given

        //When

        //Then

    }
}