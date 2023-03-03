import { Manager } from "./manager";
import { Room } from "./room";

export class Property {
  propertyId!:number;
  propertyCode!: string;
  propertyType!: string;
  propertyName!: string;
  propertyStatus!: string;
  buildingName!: string;
  streetName!: string;
  city !: string;
  state !: string;
  country !: string;
  zip !: number;
  onBoardingDate!: Date;
  rooms!: Room[];
  ownerId!: number;
  firstName!: string;
  lastName!: string;
  contact!: string;
  alternativeContact!: string;
  email!: string;
  gender!: string;
  manager!: Manager;
}
