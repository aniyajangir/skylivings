import { Property } from "./property";

export class Tenant {
  id!: number;
  firstName!: string;
  lastName!: string;
  contact!: string;
  alternativeContact!: string;
  email!: string;
  gender!: string;
  headRoomMate!: boolean;
  flatNumber!: string;
  streetName!: string;
  city !: string;
  intendedStay !: string;
  state !: string;
  country !: string;
  zip !: number;
  propertyName !: string;
  checkInDate !: Date;
  roomNumber !: number;
  rent !: number;
  property!: Property;
}
