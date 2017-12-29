import { User } from "app/_models/user";
import { Currency } from "app/_models/currency";
import { OrderType } from "app/_models/orderType";

export class OrderHistoryBot {

    id : number;
    currency : number;
    ordertype : OrderType;
    timestampsend : Date;
    timestampactivated : Date;
    timestampcancelled : Date;
    timestampfinished : Date;
    currencyvalue : number;
    volume : number;
    gainbtc : number;

   constructor(){

   }
}
