import { Appointment } from "./appointment";

export class Invoice {
      id : number
      number : string;
      status : string; 
      totalAmount : number;
      issued : Date;
      appointments : Appointment[];
} 