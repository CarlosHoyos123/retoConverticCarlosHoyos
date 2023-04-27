package com.ecoomerce.JPA.services.impl;

import static com.ecoomerce.JPA.datosEjemplo.Datos.*;
import com.ecoomerce.JPA.repositories.CountryRepository;
import com.ecoomerce.JPA.repositories.IdTypeRepository;
import com.ecoomerce.JPA.repositories.PhoneTypeRepository;
import com.ecoomerce.JPA.utils.FormsInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class FormsServicesTest {
    @MockBean
    IdTypeRepository idTypeRepository;
    @MockBean
    CountryRepository countryRepository;
    @MockBean
    PhoneTypeRepository phoneTypeRepository;
    @Autowired
    FormsServices formsServices;

    @Test
    void findAllItemsTest() {
        //Given
        when(idTypeRepository.findAll()).thenReturn(listaDocumentos());
        when(countryRepository.findAll()).thenReturn(listaPaises());
        when(phoneTypeRepository.findAll()).thenReturn(listaTelefono());
        //When
        FormsInfo response = formsServices.findAllItems();
        //Then
        assertNotNull(response);
        assertFalse(response.getCountries().isEmpty());
        assertFalse(response.getPhones().isEmpty());
        assertFalse(response.getDocuments().isEmpty());
    }
}