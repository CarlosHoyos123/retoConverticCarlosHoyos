package com.ecoomerce.JPA;

import com.ecoomerce.JPA.entitys.IdType;
import com.ecoomerce.JPA.repositories.CountryRepository;
import com.ecoomerce.JPA.repositories.IdTypeRepository;
import com.ecoomerce.JPA.repositories.PhoneTypeRepository;
import com.ecoomerce.JPA.services.impl.FormsServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class DataJPA {
    @Autowired
    IdTypeRepository idTypeRepository;
    @Test
    void idTypeRepositoryCrud(){
        System.out.println(idTypeRepository.findAll());
        assertEquals(idTypeRepository.findById(1L).orElseThrow().getTipoDocumento(), "CEDULA");
        assertEquals(idTypeRepository.findAll().size(),4);
        IdType nuevoDoc = new IdType(5, "nuevoDoc");
        IdType creado =  idTypeRepository.save(nuevoDoc);
        creado.setTipoDocumento("doc2");
        IdType actualizado =  idTypeRepository.save(nuevoDoc);
        System.out.println(actualizado.toString());
        assertEquals(idTypeRepository.findAll().size(),5);
    }

}
