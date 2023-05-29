import { Customer } from "./customer";
import { Provider } from "./provider";
import { Work } from "./work";


export enum AppointmentStatus{
    SCHEDULED = "SCHEDULED",
    FINISHED = "FINISHED",
    CONFIRMED = "CONFIRMED",
    INVOICED = "INVOICED",
    CANCELED = "CANCELED",
    DENIED = "DENIED",
    REJECTION_REQUESTED = "REJECTION_REQUESTED",
    REJECTED = "REJECTED",
    EXCHANGE_REQUESTED = "EXCHANGE_REQUESTED"
}


export class Appointment{
    id : number;
    canceledAt : Date;
    start : Date;
    end : Date;
}