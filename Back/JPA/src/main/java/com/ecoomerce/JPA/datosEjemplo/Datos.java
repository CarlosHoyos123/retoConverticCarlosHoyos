package com.ecoomerce.JPA.datosEjemplo;

import com.ecoomerce.JPA.entitys.*;
import com.ecoomerce.JPA.utils.*;
import jakarta.persistence.Column;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.UUID.randomUUID;

public class Datos {

/*    public static final IdType documento = new IdType(0, "String tipoDocumento");
    public static final Country pais = new Country(0, "String nombrePais");
    public static final List<Country> paises = Arrays.asList(new Country(0, "String nombrePais"),new Country(1, "String nombre Otro Pais "));
    public  static final PhoneType telefono = new PhoneType(0, "String tipoTelefono");
    public  static final List<PhoneType> telefonos = Arrays.asList(new PhoneType(0, "ejemplo"),new PhoneType(1,"ejemplo1"));
    */
    public static PhoneType crearTelefono (){
        return new PhoneType(0, "String tipoTelefono");
    }
    public static IdType crearDocumento(){
        return new IdType(0, "String tipoDocumento");
    }
    public static Country crearPais(){
        return new Country(0, "String nombrePais");
    }
    public static List<Country> listaPaises(){
        return Arrays.asList(new Country(0, "String nombrePais"),new Country(1, "String nombre Otro Pais "));
    }
    public static List<PhoneType> listaTelefono(){
        return Arrays.asList(new PhoneType(0, "ejemplo telefono"),new PhoneType(1, "ejemplo telefono2"));
    }

    public static List<IdType> listaDocumentos(){
        return Arrays.asList(new IdType(0, "ejemplo documento"),new IdType(1, "ejemplo documento2"));
    }
    public static Optional<Client> crearClienteEjemplo(){
        return Optional.of(new Client("ejemplo@gmail.com",
                "contrasenia1",
                "carlos",
                "andres",
                "hoyos",
                "rodriguez",
                new PhoneType(1, "MOVIL"),
                "3109203038",
                new Country( 3, "PARAGUAY"),
                "1128300400",
                new IdType(4, "CEDULA DE EXTRANGERIA")));
    }

    public static Optional<InvoiceAdress> createInoviceAdress(){
        return Optional.of(new InvoiceAdress("DireccionEjemploI", "zipCodeEjemploI", 0, 0));
    }

    public static Optional<AdressToSend> createAdressTpSend(){
        return Optional.of(new AdressToSend("direccionEjemploA",  "zipCodeEjemploA", 0, 0));
    }

    public static Login UserAuth(){
        return new Login("ejemplo@gmail.com", "contrasenia1");
    }

    public static List<ShoppingCar> itemsExList(){
        return Arrays.asList(
                new ShoppingCar(1, 1, new java.sql.Date(2023,06,02), 4, 1, 2, 10),
                new ShoppingCar(2, 1, new java.sql.Date(2023,06,02), 4, 1, 2, 10));
    }

    public static List<CarGridResponse> listaCarGrid(){
        return Arrays.asList(crearCarGrid(), crearCarGrid());
    }

    public static ShoppingCar crearCar(){
        return new ShoppingCar(1, 1, new java.sql.Date(2023,06,02), 4, 1, 2, 10);
    }

    public static Color crearColor(){
        return new Color(1,"nombreColor","hexEjemplo");
    }

    public static Size crearSize(){
        return new Size(1,"ejemploTalla","tallaEjemplo");
    }
    public static Invoice crearInvoice(){
        return  new Invoice(randomUUID(), new java.sql.Date(2023,9,8),1, 200.00, 2, 1, 2);
    }

    public static Product crearProduct(){
        return new Product( 0, "pluEjemplo", "productoEjemplo",
                2, 100,
                "descripcionEjemplo", new Date(2023-02-02),
                1, 20, "rutaFotoEjemplo");
    }

    public static CarGridResponse crearCarGrid(){
        return new CarGridResponse(0, crearProduct(), crearSize(), crearColor(), 10);
    }

    public static InvoiceDetail crearDetalle() {
        return new InvoiceDetail(9, UUID.randomUUID(), 4, 3, 1, 10, 200);
    }

    public static  List<InvoiceDetail> listaDetalle(){
        return Arrays.asList(crearDetalle(),crearDetalle());
    }
    public static ConfirmBuy crearConfirm(){
        return new ConfirmBuy(crearInvoice(), listaDetalle(), listaCarGrid());
    }
    public static QuantityAvailable crearInventario(){
        return new QuantityAvailable(6, 2, 1, 4, 10);
    }

    public static RespuestaAuth respuestaPostiva(){
        return new RespuestaAuth(true, "Logeo exitoso.", "String type", crearClienteEjemplo().orElseThrow(), createInoviceAdress().orElseThrow(),
                createAdressTpSend().orElseThrow());
    }

}
