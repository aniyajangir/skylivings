import { Tenant } from "./tenant";

export class Room {
    roomId!: number;
    roomNumber!: string;
    tenants!: Tenant[];
    rent!: number;
    roomStatus!: string;
}
