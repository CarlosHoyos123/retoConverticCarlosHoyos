import { Country } from "./country";
import { IdType } from "./idType";
import { PhoneType } from "./phoneType";

export interface ClientEntity{
    cliente:            number;
    email:              string;
    contrasenia:        string;
    primerNombre:       string;
    segundoNombre:      string;
    primerApellido:     string;
    segundoApellido:    string;
    tipoTelefono:       PhoneType;
    telefono:           string;
    pais:               Country;
    numeroDocumento:    string;
    tipoDocumento:      IdType;
}