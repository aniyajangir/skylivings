import { Address } from "./address";
import { Property } from "./property";
import { Room } from "./room";

export class Tenant {
  tenantId!: number;
  firstName!: string;
  lastName!: string;
  contact!: string;
  alternativeContact!: string;
  email!: string;
  gender!: string;
  headRoomMate!: string;
  flatNumber!: string;
  streetName!: string;
  city !: string;
  intendedStay !: string;
  state !: string;
  country !: string;
  zip !: number;
  propertyName !: string;
  checkInDate !: Date;
  checkOutDate !: Date;
  roomNumber !: number;
  rent !: number;
  deposit!: number;
  property!: Property;
  tenantStatus!: string;
  address!: Address;
  room!:Room;
  aadharNumber!: string;
  panNumber!: string;
  passportNumber!: string;
  passportExpiryDate!: Date;
  visaNumber!: string;
  visaExpiryDate!: Date;
  visaType!: string;
  nationality!: string;
  
}
