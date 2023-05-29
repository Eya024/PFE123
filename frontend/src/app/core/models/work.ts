import { Appointment } from "./appointment";
import { Banque } from "./banque";
import { Invoice } from "./invoice";
import { Provider } from "./provider";

export class Work {
    id: number;
    name: string;
    description: string;
    price: number;
    duration: number;
    editable: boolean;
    target: string;
    provider: Provider;
    banque: Banque;
}