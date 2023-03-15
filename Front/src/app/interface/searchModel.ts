import { ProductEntity } from "./productEntity";

export interface SearchModel{
    products: ProductEntity[];
    active: boolean;
}