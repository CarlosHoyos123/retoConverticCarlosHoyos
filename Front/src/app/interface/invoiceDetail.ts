import { colorsAvailable } from "./color";
import { Size } from "./size";

export interface InvoiceDetail{
    factura: string;
    producto: number;
    color: number;
    talla: number;
    cantidad: number;
    total: number;
}