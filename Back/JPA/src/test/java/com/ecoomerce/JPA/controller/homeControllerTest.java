package com.ecoomerce.JPA.controller;

import static com.ecoomerce.JPA.datosEjemplo.Datos.*;

import com.ecoomerce.JPA.entitys.ShoppingCar;
import com.ecoomerce.JPA.repositories.CategoriaRepository;
import com.ecoomerce.JPA.services.impl.ProductsServices;
import com.ecoomerce.JPA.utils.ProductForList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(homeController.class)
class homeControllerTest {
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductsServices productos;
    @MockBean
    private CategoriaRepository categorias;
    @BeforeEach
    void setUp(){
        objectMapper = new ObjectMapper();
    }

    @Test
    void productosPorGeneroTest() throws Exception {
    //Given
    when(productos.getList(any())).thenReturn(listaProdGender());
    //When
    mockMvc.perform(get("/home/list/cadena").contentType(MediaType.APPLICATION_JSON))
    //Then
    .andExpect(status().isOk())
    .andExpect(jsonPath("$").isArray())
    .andExpect(jsonPath("$",hasSize(2)))
    .andExpect(jsonPath("$[0].plu").value("Plu"))
    ;//.andExpect(content().json(objectMapper.writeValueAsString(ProductForList.class)));
    }

    @Test
    void enviarCategoriasTest() throws Exception {
    //Given
    when(categorias.findAll()).thenReturn(listaCategorias());
    //When
    mockMvc.perform(get("/home/categories").contentType(MediaType.APPLICATION_JSON))
    //Then
    .andExpect(status().isOk());
    }

    @Test
    void productDetailATest() throws Exception {
    //Given
    ShoppingCar carrito = crearCar();
    when(productos.saveCarItem(any())).thenReturn(crearCar());
    //When
    mockMvc.perform(post("/home/cart").contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(carrito)))
    //Then
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.cantidad").value(10))
    ;
    }

    @Test
    void productDetailTest() throws Exception {
    //Given
        int id = 1;
    //When
        mockMvc.perform(post("/home/product/detail").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(id)))
    //Then
        .andExpect(status().isOk())
        ;
    }

    @Test
    void obtenernombreProductosTest() throws Exception {
    //Given
        when(productos.searchBarProcess(any())).thenReturn(listaProductos());
    //When
        mockMvc.perform(get("/home/products/names/cadena").contentType(MediaType.APPLICATION_JSON))
    //Then
        .andExpect(status().isOk())
    ;
    }

    @Test
    void getMostSellingProductsTest() throws Exception {
    //Given
        when(productos.MostSellingBanner()).thenReturn(listaProductos());
    //When
        mockMvc.perform(get("/home/prodcuts/mostSelling").contentType(MediaType.APPLICATION_JSON))
    //Then
        .andExpect(status().isOk());
    }
}