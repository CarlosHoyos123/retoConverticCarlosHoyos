package com.ecoomerce.JPA;

import static com.ecoomerce.JPA.datosEjemplo.Datos.*;

import com.ecoomerce.JPA.datosEjemplo.Datos;
import com.ecoomerce.JPA.entitys.Country;
import com.ecoomerce.JPA.entitys.IdType;
import com.ecoomerce.JPA.entitys.PhoneType;
import com.ecoomerce.JPA.repositories.CountryRepository;
import com.ecoomerce.JPA.repositories.IdTypeRepository;
import com.ecoomerce.JPA.repositories.PhoneTypeRepository;
import com.ecoomerce.JPA.repositories.ProductsRepository;
import com.ecoomerce.JPA.services.impl.FormsServices;
import com.ecoomerce.JPA.services.impl.ProductsServices;
import com.ecoomerce.JPA.services.impl.ShoppingCarServices;
import com.ecoomerce.JPA.utils.CarGridResponse;
import com.ecoomerce.JPA.utils.FormsInfo;
import com.ecoomerce.JPA.utils.ProductForList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
class JpaApplicationTests {

	@MockBean
	ProductsRepository productsRepository;
	@MockBean
	IdTypeRepository idTypeRepository;
	@MockBean
	CountryRepository countryRepository;
	@MockBean
	PhoneTypeRepository phoneTypeRepository;
	@Autowired
	FormsServices formsServices;

	@BeforeEach
	void setUp(){
    /*	productsRepository = mock(ProductsRepository.class);
		idTypeRepository = mock(IdTypeRepository.class);
		countryRepository = mock(CountryRepository.class);
		phoneTypeRepository = mock(PhoneTypeRepository.class);
		formsServices = new FormsServices(idTypeRepository, countryRepository, phoneTypeRepository);*/
	}

	@Test
	void FormulariesInfoTest(){
		when(idTypeRepository.findAll()).thenReturn(listaDocumentos());
		when(phoneTypeRepository.findAll()).thenReturn(listaTelefono());
		when(countryRepository.findAll()).thenReturn(Datos.listaPaises());
		FormsInfo response = formsServices.findAllItems();
		assertTrue(response.getCountries().size()==2);

	}
}
