package com.ecoomerce.JPA.controller;

import static com.ecoomerce.JPA.datosEjemplo.Datos.*;

import com.ecoomerce.JPA.entitys.Client;
import com.ecoomerce.JPA.repositories.ClientesRepository;
import com.ecoomerce.JPA.services.impl.ClientsServices;
import com.ecoomerce.JPA.services.impl.FormsServices;
import com.ecoomerce.JPA.services.impl.ShoppingCarServices;
import com.ecoomerce.JPA.utils.FormsInfo;
import com.ecoomerce.JPA.utils.Login;
import com.ecoomerce.JPA.utils.RespuestaAuth;
import com.ecoomerce.JPA.utils.UserCreateResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest (AuthController.class)
class AuthControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private ClientsServices clientsServices;
    @MockBean
    private FormsServices formsServices;
    @MockBean
    ClientesRepository clientesRepository;
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void formsRepoTest() throws Exception {
    //Given
        FormsInfo lista = new FormsInfo(
                Arrays.asList(crearDocumento(),crearDocumento()),
                Arrays.asList(crearPais(),crearPais()),
                Arrays.asList(crearTelefono(),crearTelefono())
        );
        when(formsServices.findAllItems()).thenReturn(lista);
    //when
        mvc.perform(get("/Auth/formConfig").contentType(MediaType.APPLICATION_JSON))
    //then
        .andExpect(status().isOk());
    }

    @Test
    void authTest() throws Exception {
    //Given
        Login dto = new Login( "correo", "Abc123*");
        when(clientsServices.verificarUsuario(any())).thenReturn(respuestaPostiva());
    //when
        mvc.perform(post("/Auth/user").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(dto)))
    //then
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.text").value("Logeo exitoso."))
        .andExpect(jsonPath("$.state").value(true));
    }

    @Test
    void guardarNuevoUsuarioTest() throws Exception {
    //Given
        when(clientsServices.saveNewClient(any())).thenReturn(new UserCreateResponse("User created",crearClienteEjemplo().orElseThrow()));
    //when
        mvc.perform(post("/Auth/create").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(crearClienteEjemplo().orElseThrow())))
    //then
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.description").value("User created"))
        .andExpect(jsonPath("$.client.email").value("ejemplo@gmail.com"));
    }

    @Test
    void actualizarUsuarioTest() throws Exception {
    //Given
        when(clientsServices.updateClient(any())).thenReturn(new UserCreateResponse("User updated",crearClienteEjemplo().orElseThrow()));
    //when
        mvc.perform(post("/Auth/update").contentType(MediaType.APPLICATION_JSON).content((objectMapper.writeValueAsString(crearClienteEjemplo().orElseThrow()))))
    //Then
        .andExpect(status().isAccepted())
        .andExpect(jsonPath("$.description").value("User updated"));
    }
}