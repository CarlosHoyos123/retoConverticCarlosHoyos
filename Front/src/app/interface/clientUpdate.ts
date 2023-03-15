import { AdressToInvoice } from "./adressToInvoice";
import { AdressToSend } from "./adressToSend";
import { ClientEntity } from "./clientEntity";

export interface ClientUpdate{
    client: ClientEntity;
    adresstosend: AdressToSend;
    adressToInvoice: AdressToInvoice;
}