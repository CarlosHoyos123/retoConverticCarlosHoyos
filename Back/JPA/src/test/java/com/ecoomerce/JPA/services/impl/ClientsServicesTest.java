package com.ecoomerce.JPA.services.impl;

import static com.ecoomerce.JPA.datosEjemplo.Datos.*;
import com.ecoomerce.JPA.entitys.Client;
import com.ecoomerce.JPA.entitys.Country;
import com.ecoomerce.JPA.entitys.IdType;
import com.ecoomerce.JPA.entitys.PhoneType;
import com.ecoomerce.JPA.repositories.AdressToSendRepository;
import com.ecoomerce.JPA.repositories.ClientesRepository;
import com.ecoomerce.JPA.repositories.InvoiceAdressRepository;
import com.ecoomerce.JPA.utils.UpdateUserInfo;
import com.ecoomerce.JPA.utils.UserCreateResponse;
import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ClientsServicesTest {
    @MockBean
    ClientesRepository clientesRepository;
    @MockBean
    AdressToSendRepository adressToSendRepository;
    @MockBean
    InvoiceAdressRepository invoiceAdressRepository;
    @Autowired
    ClientsServices clientsServices;

    @Test
    void saveNewClientTest() {
        //Given
        Optional<Client> nuevo = crearClienteEjemplo();
        when(clientesRepository.save(any())).thenReturn(nuevo);
        //When
        UserCreateResponse response = clientsServices.saveNewClient(nuevo.orElseThrow());
        //Then
        System.out.println(response);
        assertNotNull(clientsServices.saveNewClient(nuevo.orElseThrow()));
    }

    @Test
    void verificarUsuarioTest() {
        //given
        when(clientesRepository.findByEmail(any())).thenReturn(crearClienteEjemplo().orElseThrow());
        //then
        assertEquals(clientsServices.verificarUsuario(UserAuth()).getText(),"Logeo exitoso." );
    }

    @Test
    void updateClientTest() {
        //Given
        UpdateUserInfo user = new   UpdateUserInfo(crearClienteEjemplo().orElseThrow(),
                                    createAdressTpSend().orElseThrow(),
                                    createInoviceAdress().orElseThrow());
        user.getClient().setContrasenia("nuevaContrasenia");
        user.getAdresstosend().setZipCode("050041");
        //when
        UserCreateResponse response = clientsServices.updateClient(user);
        //then
        assertEquals(response.getDescription(),"User updated");
        assertEquals(response.getClient().getContrasenia(), "nuevaContrasenia");
    }
}