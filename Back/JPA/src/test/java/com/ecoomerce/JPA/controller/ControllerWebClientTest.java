package com.ecoomerce.JPA.controller;

import static com.ecoomerce.JPA.datosEjemplo.Datos.*;
import com.ecoomerce.JPA.entitys.ShoppingCar;
import com.ecoomerce.JPA.repositories.ColorRepository;
import com.ecoomerce.JPA.repositories.ProductsRepository;
import com.ecoomerce.JPA.repositories.SizeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;
import static reactor.core.publisher.Mono.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class ControllerWebClientTest {
    private ObjectMapper objectMapper;
    private MockMvc mockMvc;
    ColorRepository colorRepository;
    SizeRepository sizeRepository;
    ProductsRepository productsRepository;
    @Autowired
    private WebTestClient client;
    @BeforeEach
    void setUp(){
        objectMapper= new ObjectMapper();
    }
    @Order(1)
    @Test
    void saveItemTest() {
    //Given
    ShoppingCar dto = crearCar();
    //When
    client.post().uri("/car/addItem")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(dto)
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.cliente").value(is(1))
            ;
    //Then

    }
    @Order(2)
    @Test
    void savedItemsByUsertest(){
    //Given
        /*when(colorRepository.findById(anyInt())).thenReturn(crearColor());
        when(sizeRepository.findById(anyLong())).thenReturn(crearSize());
        when(productsRepository.findById(anyLong())).thenReturn(crearProduct());*/
    //When
    client.get().uri("/car/myCar/1")
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$").isArray()
            .jsonPath("$").value(hasSize(2))
            ;
    //Then
    }
   @Test
    void listCategoriesTest() {
    //When
        client.get().uri("/home/categories")
    //Then
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("$").isArray()
        .jsonPath("$").value(hasSize(11))
    ;
    }

    /*@Test
    void confirmSellTest() {
    //Given

    //When
    //client.post().uri()
    //Then

    }*/
}