import { RoleStatus } from "./roles";

export class User{
    id:number;
    username : string;
    password : string;
    firstName : string;
    lastName : string;
    email : string;
    mobile : string;
    street : string;
    city : string;
    postcode : string;
    roles : RoleStatus;
}