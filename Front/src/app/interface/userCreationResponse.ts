import { ClientEntity } from "./clientEntity";

export interface UserCreationResponse{
    description: string;
    client: ClientEntity;
}