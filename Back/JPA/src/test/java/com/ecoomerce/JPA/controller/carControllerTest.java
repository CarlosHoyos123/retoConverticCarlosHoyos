package com.ecoomerce.JPA.controller;

import static com.ecoomerce.JPA.datosEjemplo.Datos.*;
import com.ecoomerce.JPA.entitys.ShoppingCar;
import com.ecoomerce.JPA.services.impl.ShoppingCarServices;
import com.ecoomerce.JPA.utils.CarGridResponse;
import com.ecoomerce.JPA.utils.ConfirmBuy;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@WebMvcTest(carController.class)
class carControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShoppingCarServices shoppingCarServices;

    ObjectMapper objectMapper;

    @BeforeEach
     void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void savedItemsByUserTest() throws Exception {
        //Given
        when(shoppingCarServices.itemsByUser(1)).thenReturn(listaCarGrid());
        //when
        mockMvc.perform(get("/car/myCar/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                ;
    }

    @Test
    void saveItemTest() throws Exception {
        //Given
        ShoppingCar dto = crearCar();
        when(shoppingCarServices.saveItem(any())).thenReturn(crearCar());
        //When
        mockMvc.perform(post("/car/addItem")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto))
        )
        //Then
        .andExpect(status().isOk())
        ;
    }

    @Test
    void removeItemTest() throws Exception {
        //Given
        CarGridResponse dto = crearCarGrid();
        when(shoppingCarServices.deleteitemByUser(any())).thenReturn(crearCarGrid());
        //When
        mockMvc.perform(post("/car/removeItem")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto))
        )
        //Then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idCar").value(0));
                verify(shoppingCarServices, times(1)).deleteitemByUser(any())
                ;
    }

    @Test
    void confirmSell() throws Exception {
        //Given
        ConfirmBuy dto = crearConfirm();
        when(shoppingCarServices.confirmProcess(any())).thenReturn(crearConfirm());
        //When
        mockMvc.perform(post("/car/carConfirm")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                //Then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.invoice.cliente").value(1))
                ;
    }
}