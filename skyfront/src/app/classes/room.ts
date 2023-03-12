import { Tenant } from "./tenant";

export class Room {
    roomId!: number;
    propertyType!: string;
    roomSize!: number;
    deposit!: number;
    bedrooms!: number;
    bathrooms!:number;
    roomNumber!: string;
    tenants!: Tenant[];
    rent!: number;
    roomStatus!: string;
    description!: string;
    capacity!: number;
    roomNumbers !: number[];
    quantity !: number;
}
