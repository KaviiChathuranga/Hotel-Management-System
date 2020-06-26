import {Rooms} from './rooms';
import {Facilities} from './facilities';

export class RoomFacility {
  id: number;
  roomDto: Rooms;
  dtolist: Array<Facilities> = [];
}

