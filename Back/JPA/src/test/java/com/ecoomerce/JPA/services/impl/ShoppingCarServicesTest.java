package com.ecoomerce.JPA.services.impl;

import static com.ecoomerce.JPA.datosEjemplo.Datos.*;

import com.ecoomerce.JPA.entitys.Client;
import com.ecoomerce.JPA.entitys.Invoice;
import com.ecoomerce.JPA.entitys.InvoiceDetail;
import com.ecoomerce.JPA.entitys.ShoppingCar;
import com.ecoomerce.JPA.repositories.*;
import com.ecoomerce.JPA.utils.CarGridResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ShoppingCarServicesTest {

    @MockBean
    ShoppingCartRepository shoppingCartRepository;
    @MockBean
    ColorRepository colorRepository;
    @MockBean
    SizeRepository sizeRepository;
    @MockBean
    ProductsRepository productosRepository;
    @MockBean
    InvoiceRepository invoiceRepository;
    @MockBean
    InvoiceDetailRepository invoiceDetailRepository;
    @MockBean
    private QuantityAvailableRepository quantityAvailableRepository;
    @MockBean
    ClientesRepository clientesRepository;
    @Autowired
    ShoppingCarServices shoppingCarServices;

    @Test
    void itemsByUserTest() {
        //given
        when(productosRepository.findById(anyLong())).thenReturn(Optional.of(crearProduct()));
        when(sizeRepository.findById(anyLong())).thenReturn(Optional.of(crearSize()));
        when(colorRepository.findById(anyInt())).thenReturn(Optional.of(crearColor()));
        when(shoppingCartRepository.findByCliente(anyInt())).thenReturn(itemsExList());

        CarGridResponse response = crearCarGrid();
        //when
        List<CarGridResponse> records = shoppingCarServices.itemsByUser(anyInt());
        //then
        assertFalse(records.isEmpty());
        verify(shoppingCartRepository, times(1)).findByCliente(anyInt());
        assertTrue(shoppingCarServices.itemsByUser(anyInt()).size()==2);
    }

    @Test
    void deleteCarByUser() {
        //then
        assertDoesNotThrow(() -> {
            shoppingCarServices.deleteCarByUser(crearClienteEjemplo().orElseThrow());
        });
        assertNotNull(shoppingCarServices.deleteCarByUser(crearClienteEjemplo().orElseThrow()));
    }

    @Test
    void deleteitemByUser() {
        assertDoesNotThrow(() -> {
            shoppingCarServices.deleteitemByUser(crearCarGrid());
        });
        assertNotNull(shoppingCarServices.deleteitemByUser(crearCarGrid()));
    }

    @Test
    void saveItemTest() {
        //Given
        when(shoppingCartRepository.save(any(ShoppingCar.class))).thenReturn(crearCar());
        //then
        assertNotNull(shoppingCarServices.saveItem(crearCar()));
    }

    @Test
    void saveInvoiceTest() {
        //Given
        when(invoiceRepository.save(any(Invoice.class))).thenReturn(crearInvoice());
        //then
        shoppingCarServices.saveInvoice(crearInvoice());
    }

    @Test
    void saveDetail() {
        //Given
        when(productosRepository.findById(anyLong())).thenReturn(Optional.of(crearProduct()));
        when(invoiceDetailRepository.save(any(InvoiceDetail.class))).thenReturn(crearDetalle());
        //then
        assertTrue(shoppingCarServices.saveDetail(listaCarGrid(),crearInvoice()).size()==2);
    }

    @Test
    void confirmProcess() {
        //Given
        when(quantityAvailableRepository.findByProductoAndColorAndTalla(anyInt(),anyInt(),anyInt())).thenReturn(crearInventario());
        when(invoiceRepository.save(any(Invoice.class))).thenReturn(crearInvoice());
        when(clientesRepository.findById(anyLong())).thenReturn(crearClienteEjemplo());
        //then
        assertNotNull(shoppingCarServices.confirmProcess(crearConfirm()));
        System.out.println(shoppingCarServices.confirmProcess(crearConfirm()));
    }
}